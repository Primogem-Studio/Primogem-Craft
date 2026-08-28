package net.ai;

import net.hackermdch.pgc.CustomAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.EnderpearlItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.SweepAttackEvent;
import net.neoforged.neoforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class LivingItemEntity extends PathfinderMob {
	public static final EntityDataAccessor<ItemStack> DATA_ITEM = SynchedEntityData.defineId(LivingItemEntity.class, EntityDataSerializers.ITEM_STACK);
	public static final EntityDataAccessor<Integer> DATA_SWING = SynchedEntityData.defineId(LivingItemEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_ROTATE = SynchedEntityData.defineId(LivingItemEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Optional<UUID>> DATA_OWNER = SynchedEntityData.defineId(LivingItemEntity.class, EntityDataSerializers.OPTIONAL_UUID);

	private static final String NBT_ITEM = "LivingItemStack";
	private static final String NBT_OWNER = "LivingItemOwner";
	private static final String NBT_TICKS = "LivingItemTicks";
	private static final String NBT_ATTACK_CD = "LivingItemAttackCd";
	private static final String NBT_USE_CD = "LivingItemUseCd";
	private static final String NBT_RANGE = "LivingItemRange";

	private static final TagKey<Item> TAG_RIGHT_CLICK = TagKey.create(Registries.ITEM, ResourceLocation.parse("pgc:living_item_right_click"));

	private static final double BASE_ATTACK_DAMAGE = 0.3;
	public static final int BOW_DRAW_TICKS = 16;
	private static final double MAX_CHASE_DISTANCE = 24.0;
	private static final long OWNER_ATTACK_MEMORY = 100;
	private static final long ATTACK_BLACKLIST_TIME = 100;
	private static final String MODIFIER_PREFIX = "pgc:living_item_";
	private static final double MOVE_SPEED_IDLE = 0.1;
	private static final double MOVE_SPEED_ATTACK = 0.6;
	private static final double COMBAT_SPREAD_RADIUS = 1.8;
	private static final int CHASE_STUCK_TICKS = 40;
	private static final float RETARGET_CHANCE = 0.35F;

	private int remainingTicks;
	private int attackCooldown;
	private int attackInterval = 20;
	private int useCooldown;
	private int scanCooldown;
	private double attackRange = 3.0;
	private Vec3 hoverTarget;
	private int hoverTimer;
	private boolean reverted;
	private double orbitAngle = Double.NaN;
	private double lastChaseDist = Double.MAX_VALUE;
	private int chaseStuckTicks;
	private final Map<UUID, Long> ownerAttackMemory = new HashMap<>();
	private final Map<UUID, Long> attackBlacklist = new HashMap<>();

	public LivingItemEntity(EntityType<LivingItemEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoGravity(true);
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	public void startLiving(Player owner, ItemStack stack, int ticks) {
		this.entityData.set(DATA_OWNER, Optional.of(owner.getUUID()));
		this.entityData.set(DATA_ITEM, stack.copy());
		this.remainingTicks = ticks < 0 ? -1 : Math.max(1, ticks);
		applyItemStats();
		this.attackCooldown = this.random.nextInt(Math.max(1, this.attackInterval));
		joinOwnerTeam(owner);
	}

	public boolean isInfinite() {
		return this.remainingTicks < 0;
	}

	public void setInfinite() {
		this.remainingTicks = -1;
	}

	public int getRemainingTicks() {
		return this.remainingTicks;
	}

	public void setRemainingTicks(int ticks) {
		this.remainingTicks = ticks < 0 ? -1 : Math.max(1, ticks);
	}

	public void applyItemStats() {
		ItemStack stack = this.getCarriedStack();
		ItemAttributeModifiers mods = stack.get(DataComponents.ATTRIBUTE_MODIFIERS);
		double attackSpeed = 4.0;
		boolean hasAttackSpeedModifier = false;
		if (mods != null) {
			for (ItemAttributeModifiers.Entry entry : mods.modifiers()) {
				AttributeModifier modifier = entry.modifier();
				if (modifier.operation() != AttributeModifier.Operation.ADD_VALUE) {
					continue;
				}
				if (entry.attribute().is(Attributes.ATTACK_SPEED)) {
					attackSpeed += modifier.amount();
					hasAttackSpeedModifier = true;
				}
			}
		}
		if (!hasAttackSpeedModifier) {
			attackSpeed = 1.0;
		}
		this.attackInterval = Math.max(10, (int) Math.round(20.0 / Math.max(0.1, attackSpeed)) + 4);

		AttributeInstance attack = this.getAttribute(Attributes.ATTACK_DAMAGE);
		if (attack != null) {
			clearItemModifiers(attack);
			attack.setBaseValue(BASE_ATTACK_DAMAGE);
			addItemModifiers(attack, mods, Attributes.ATTACK_DAMAGE);
		}
	}

	private void clearItemModifiers(AttributeInstance instance) {
		for (AttributeModifier modifier : instance.getModifiers()) {
			if (modifier.id().getNamespace().equals("pgc") && modifier.id().getPath().startsWith("living_item_")) {
				instance.removeModifier(modifier.id());
			}
		}
	}

	private void addItemModifiers(AttributeInstance instance, ItemAttributeModifiers mods, Holder<Attribute> attribute) {
		if (mods == null) {
			return;
		}
		for (ItemAttributeModifiers.Entry entry : mods.modifiers()) {
			if (!entry.attribute().is(attribute)) {
				continue;
			}
			AttributeModifier source = entry.modifier();
			ResourceLocation id = ResourceLocation.parse(MODIFIER_PREFIX + source.id().getNamespace() + "_" + source.id().getPath());
			instance.addTransientModifier(new AttributeModifier(id, source.amount(), source.operation()));
		}
	}

	public void setAttackRange(double range) {
		this.attackRange = Math.max(1.0, range);
	}

	public double getAttackRange() {
		return this.attackRange;
	}

	public ItemStack getCarriedStack() {
		return this.entityData.get(DATA_ITEM);
	}

	public int getSwingTicks() {
		return this.entityData.get(DATA_SWING);
	}

	public int getRotateTicks() {
		return this.entityData.get(DATA_ROTATE);
	}

	public Player getOwner() {
		UUID uuid = this.entityData.get(DATA_OWNER).orElse(null);
		if (uuid == null || this.level().isClientSide) {
			return null;
		}
		if (this.level() instanceof ServerLevel serverLevel) {
			return serverLevel.getServer().getPlayerList().getPlayer(uuid);
		}
		return null;
	}

	public UUID getOwnerUuid() {
		return this.entityData.get(DATA_OWNER).orElse(null);
	}

	public void joinOwnerTeam(Player owner) {
		if (this.level().isClientSide) {
			return;
		}
		PlayerTeam team = owner.getTeam();
		if (team != null) {
			this.level().getScoreboard().addPlayerToTeam(this.getStringUUID(), team);
		}
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
	}

	@Override
	public void setTarget(@Nullable LivingEntity target) {
		super.setTarget(target);
		if (target == null) {
			this.lastChaseDist = Double.MAX_VALUE;
			this.chaseStuckTicks = 0;
		} else {
			if (Double.isNaN(this.orbitAngle)) {
				this.orbitAngle = this.random.nextDouble() * Math.PI * 2.0;
			}
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entity) {
	}

	@Override
	public void push(Entity entity) {
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.level().isClientSide || this.isRemoved() || this.isDeadOrDying()) {
			return false;
		}
		if (!(source.getEntity() instanceof Player attacker)) {
			return false;
		}
		UUID ownerUuid = this.getOwnerUuid();
		if (ownerUuid != null && ownerUuid.equals(attacker.getUUID())) {
			return false;
		}
		if (!super.hurt(source, amount)) return false;
		if (attacker.isAlive() && this.isAlive()) {
			this.setLastHurtByMob(attacker);
			this.ownerAttackMemory.put(attacker.getUUID(), this.level().getGameTime());
			this.setTarget(attacker);
			double dx = this.getX() - attacker.getX();
			double dz = this.getZ() - attacker.getZ();
			this.knockback(0.4, dx, dz);
		}
		if (this.getHealth() <= 0.0F) {
			this.setHealth(0.0F);
			revertByDeath();
			return true;
		}
		return true;
	}

	@Override
	public boolean ignoreExplosion(Explosion explosion) {
		return true;
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		return false;
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	@Override
	public void travel(Vec3 travelVector) {
		if (this.isEffectiveAi() || this.isControlledByLocalInstance()) {
			if (this.isInWater()) {
				this.moveRelative(0.02F, travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.8));
			} else if (this.isInLava()) {
				this.moveRelative(0.02F, travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.5));
			} else {
				float f = 0.91F;
				if (this.onGround()) {
					f = this.level().getBlockState(this.getBlockPosBelowThatAffectsMyMovement()).getBlock().getFriction() * 0.91F;
				}
				float f1 = 0.16277137F / (f * f * f);
				f = 0.91F;
				if (this.onGround()) {
					f = this.level().getBlockState(this.getBlockPosBelowThatAffectsMyMovement()).getBlock().getFriction() * 0.91F;
				}
				this.moveRelative(this.onGround() ? 0.1F * f1 : 0.02F, travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(f));
			}
		}
		this.calculateEntityAnimation(false);
	}

	private void steerTo(double x, double y, double z, double speed) {
		double dx = x - this.getX();
		double dy = y - this.getY();
		double dz = z - this.getZ();
		double distSq = dx * dx + dy * dy + dz * dz;
		if (distSq < 1.0E-4) {
			this.setDeltaMovement(0.0, 0.0, 0.0);
			return;
		}
		double dist = Math.sqrt(distSq);
		double step = Math.min(speed, dist);
		double k = step / dist;
		this.setDeltaMovement(dx * k, dy * k, dz * k);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_ITEM, ItemStack.EMPTY);
		builder.define(DATA_SWING, 0);
		builder.define(DATA_ROTATE, 0);
		builder.define(DATA_OWNER, Optional.empty());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		ItemStack stack = this.getCarriedStack();
		if (!stack.isEmpty()) {
			compound.put(NBT_ITEM, stack.save(this.level().registryAccess()));
		}
		this.entityData.get(DATA_OWNER).ifPresent(uuid -> compound.putUUID(NBT_OWNER, uuid));
		compound.putInt(NBT_TICKS, this.remainingTicks);
		compound.putInt(NBT_ATTACK_CD, this.attackCooldown);
		compound.putInt(NBT_USE_CD, this.useCooldown);
		compound.putDouble(NBT_RANGE, this.attackRange);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setNoGravity(true);
		if (compound.contains(NBT_ITEM)) {
			ItemStack.parse(this.level().registryAccess(), compound.get(NBT_ITEM)).ifPresent(this::setCarriedStackSilent);
		}
		if (compound.hasUUID(NBT_OWNER)) {
			this.entityData.set(DATA_OWNER, Optional.of(compound.getUUID(NBT_OWNER)));
		}
		this.remainingTicks = compound.getInt(NBT_TICKS);
		this.attackCooldown = compound.getInt(NBT_ATTACK_CD);
		this.useCooldown = compound.getInt(NBT_USE_CD);
		this.attackRange = compound.getDouble(NBT_RANGE);
		applyItemStats();
	}

	private void setCarriedStackSilent(ItemStack stack) {
		this.entityData.set(DATA_ITEM, stack.copy());
	}

	@Override
	public void tick() {
		super.tick();
		this.setNoGravity(true);
		int swing = this.entityData.get(DATA_SWING);
		if (swing > 0) {
			this.entityData.set(DATA_SWING, swing - 1);
		}
		int rotate = this.entityData.get(DATA_ROTATE);
		if (rotate > 0) {
			this.entityData.set(DATA_ROTATE, rotate - 1);
		}
		if (this.level().isClientSide) {
			return;
		}
		Vec3 motion = this.getDeltaMovement();
		if (motion.y < -0.6) {
			this.setDeltaMovement(motion.multiply(1.0, 0.5, 1.0));
		}
		if (this.onGround() && motion.y < 0) {
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.0, 1.0));
		}
		if (this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 0.0001) {
			this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.4, 0.0));
		}
		if (this.remainingTicks > 0) {
			this.remainingTicks--;
			if (this.remainingTicks <= 0) {
				if (!tryThrowSelf()) {
					revertToItem();
				}
				return;
			}
		}
		Player owner = getOwner();
		if (owner == null) {
			return;
		}
		if (owner.isDeadOrDying() || !owner.isAlive()) {
			if (this.isInfinite()) {
				return;
			}
			revertToItem();
			return;
		}
		syncInvisibility(owner);
		if (this.useCooldown > 0) {
			this.useCooldown--;
		} else {
			this.useCooldown = 120 + this.random.nextInt(120);
			attemptRightClick(owner);
		}
		LivingEntity target = this.getTarget();
		if (target != null && target.isAlive() && !target.isRemoved() && isValidTarget(target, owner)) {
			updateCombat(owner, target);
		} else {
			this.setTarget(null);
			if (this.scanCooldown > 0) {
				this.scanCooldown--;
			} else {
				this.scanCooldown = 10;
				Mob found = findTarget(owner);
				if (found != null) {
					this.setTarget(found);
					updateCombat(owner, found);
				}
			}
			if (this.getTarget() == null) {
				followOwner(owner);
			}
		}
	}

	private void syncInvisibility(Player owner) {
		MobEffectInstance ownerInvis = owner.getEffect(MobEffects.INVISIBILITY);
		if (ownerInvis != null) {
			MobEffectInstance mine = this.getEffect(MobEffects.INVISIBILITY);
			if (mine == null || mine.getAmplifier() != ownerInvis.getAmplifier() || mine.getDuration() < 40) {
				this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, Math.max(ownerInvis.getDuration(), 200), ownerInvis.getAmplifier(), false, false));
			}
		} else if (this.hasEffect(MobEffects.INVISIBILITY)) {
			this.removeEffect(MobEffects.INVISIBILITY);
		}
	}

	private void followOwner(Player owner) {
		if (this.level().dimension() != owner.level().dimension()) {
			if (owner.level() instanceof ServerLevel ownerLevel) {
				this.teleportTo(ownerLevel, owner.getX(), owner.getY() + 2.5, owner.getZ(), Set.of(), owner.getYRot(), 0);
			} else {
				this.teleportTo(owner.getX(), owner.getY() + 2.5, owner.getZ());
			}
			this.hoverTarget = null;
			return;
		}
		double distSq = this.distanceToSqr(owner);
		if (distSq > 24.0 * 24.0) {
			this.teleportTo(owner.getX(), owner.getY() + 2.5, owner.getZ());
			this.hoverTarget = null;
			return;
		}
		if (this.hoverTarget == null || this.hoverTimer-- <= 0) {
			this.hoverTarget = pickHoverPoint(owner);
			this.hoverTimer = 80 + this.random.nextInt(80);
		}
		double hdx = this.hoverTarget.x - owner.getX();
		double hdz = this.hoverTarget.z - owner.getZ();
		if (hdx * hdx + hdz * hdz > 6.0 * 6.0) {
			this.hoverTarget = pickHoverPoint(owner);
			this.hoverTimer = 80 + this.random.nextInt(80);
		}
		double distToHover = this.distanceToSqr(this.hoverTarget.x, this.hoverTarget.y, this.hoverTarget.z);
		if (distToHover > 0.5 * 0.5) {
			steerTo(this.hoverTarget.x, this.hoverTarget.y, this.hoverTarget.z, MOVE_SPEED_IDLE);
			this.lookAt(owner, 30.0F, 30.0F);
		} else {
			this.hoverTarget = null;
		}
	}

	private Vec3 pickHoverPoint(Player owner) {
		for (int attempt = 0; attempt < 5; attempt++) {
			Vec3 point = randomHoverPoint(owner);
			if (isHoverPointFree(point)) {
				return point;
			}
		}
		return randomHoverPoint(owner);
	}

	private Vec3 randomHoverPoint(Player owner) {
		double angle = this.random.nextDouble() * Math.PI * 2.0;
		double radius = 1.5 + this.random.nextDouble() * 2.5;
		double x = owner.getX() + Math.cos(angle) * radius;
		double z = owner.getZ() + Math.sin(angle) * radius;
		double y = owner.getY() + 2.2 + this.random.nextDouble() * 1.2;
		if (!this.level().getBlockState(BlockPos.containing(x, y, z)).canBeReplaced()) {
			y += 1.0;
		}
		return new Vec3(x, y, z);
	}

	private boolean isHoverPointFree(Vec3 point) {
		if (this.level().isClientSide) {
			return true;
		}
		AABB box = new AABB(point.x - 1.2, point.y - 1.2, point.z - 1.2, point.x + 1.2, point.y + 1.2, point.z + 1.2);
		return this.level().getEntities(EntityTypeTest.forClass(LivingItemEntity.class), box,
				e -> e != this && Objects.equals(e.getOwnerUuid(), this.getOwnerUuid())).isEmpty();
	}

	private void updateCombat(Player owner, LivingEntity target) {
		this.hoverTarget = null;
		this.lookAt(target, 30.0F, 30.0F);
		ItemStack stack = this.getCarriedStack();
		if (isBowLike(stack)) {
			if (this.attackCooldown > 0) {
				this.attackCooldown--;
				this.entityData.set(DATA_SWING, this.attackCooldown);
			} else if (bowShot(owner, target)) {
				this.entityData.set(DATA_SWING, 0);
				this.attackCooldown = Math.max(10, this.attackInterval);
			} else {
				this.attackCooldown = 5;
			}
			return;
		}
		if (this.attackCooldown > 0) {
			this.attackCooldown--;
			return;
		}
		double distSq = target.getBoundingBox().distanceToSqr(this.position());
		if (distSq > this.attackRange * this.attackRange) {
			chaseTarget(owner, target, distSq);
			return;
		}
		if (target.invulnerableTime > 0) {
			this.attackCooldown = 3;
			if (this.random.nextFloat() < 0.25F) {
				Mob alt = findTarget(owner);
				if (alt != null && alt != target && isValidTarget(alt, owner)) {
					this.setTarget(alt);
				}
			}
			return;
		}
		if (attackWithStack(owner, target)) {
			this.entityData.set(DATA_SWING, 5);
			this.attackCooldown = this.attackInterval;
			if (this.random.nextFloat() < RETARGET_CHANCE) {
				Mob alt = findTarget(owner);
				if (alt != null && alt != target && isValidTarget(alt, owner)) {
					this.setTarget(alt);
				}
			}
		}
	}

	private void chaseTarget(Player owner, LivingEntity target, double distSq) {
		double prev = this.lastChaseDist;
		this.lastChaseDist = distSq;
		if (distSq < prev - 0.25) {
			this.chaseStuckTicks = 0;
		} else {
			this.chaseStuckTicks++;
		}
		if (this.chaseStuckTicks >= CHASE_STUCK_TICKS) {
			this.chaseStuckTicks = 0;
			this.orbitAngle += 1.0 + this.random.nextDouble() * 2.0;
		}
		if (isCrowded()) {
			this.orbitAngle += 0.35;
		}
		Vec3 point = combatHoverPoint(target);
		steerTo(point.x, point.y, point.z, MOVE_SPEED_ATTACK);
		this.attackCooldown = 2;
	}

	private Vec3 combatHoverPoint(LivingEntity target) {
		double radius = Math.max(1.0, this.attackRange * 0.65);
		double x = target.getX() + Math.cos(this.orbitAngle) * radius;
		double z = target.getZ() + Math.sin(this.orbitAngle) * radius;
		double y = target.getY() + 1.0;
		if (!this.level().getBlockState(BlockPos.containing(x, y, z)).canBeReplaced()) {
			y += 1.0;
		}
		return new Vec3(x, y, z);
	}

	private boolean isCrowded() {
		if (this.level().isClientSide) {
			return false;
		}
		return !this.level().getEntities(EntityTypeTest.forClass(LivingItemEntity.class),
				this.getBoundingBox().inflate(COMBAT_SPREAD_RADIUS),
				e -> e != this && Objects.equals(e.getOwnerUuid(), this.getOwnerUuid())).isEmpty();
	}

	private boolean attackWithStack(Player owner, LivingEntity target) {
		if (this.level().isClientSide) {
			return false;
		}
		if (!(this.level() instanceof ServerLevel serverLevel)) {
			return false;
		}
		ItemStack stack = this.getCarriedStack().copy();
		if (stack.isEmpty()) {
			return false;
		}
		if (NeoForge.EVENT_BUS.post(new AttackEntityEvent(owner, target)).isCanceled()) {
			return false;
		}
		DamageSource source = this.level().damageSources().playerAttack(owner);
		float baseDamage = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
		float finalDamage = EnchantmentHelper.modifyDamage(serverLevel, stack, target, source, baseDamage);
		if (CustomAPI.GenshinCraftLoaded) {
			source = LivingItemGenshin.elementSource(stack, source, target);
		}
		if (!target.hurt(source, finalDamage)) {
			this.attackBlacklist.put(target.getUUID(), this.level().getGameTime());
			this.setTarget(null);
			return false;
		}
		if (target.invulnerableTime > 0) {
			target.invulnerableTime = Math.max(1, target.invulnerableTime / 4);
		}
		if (stack.canPerformAction(ItemAbilities.SWORD_SWEEP) || stack.getItem().getAttackDamageBonus(target, baseDamage, source) > 0.0F) {
			sweepAttack(serverLevel, owner, target, stack, baseDamage);
		}
		double knockback = this.getAttributeValue(Attributes.ATTACK_KNOCKBACK) + EnchantmentHelper.modifyKnockback(serverLevel, stack, target, source, 0.0F);
		if (knockback > 0.0) {
			double dx = target.getX() - this.getX();
			double dz = target.getZ() - this.getZ();
			target.knockback(knockback * 0.5, dx, dz);
		}
		boolean hurtEnemy = stack.getItem().hurtEnemy(stack, target, owner);
		EnchantmentHelper.doPostAttackEffectsWithItemSource(serverLevel, target, source, stack);
		if (hurtEnemy) {
			stack.getItem().postHurtEnemy(stack, target, owner);
		}
		if (!stack.isEmpty() && !this.isInfinite()) {
			stack.hurtAndBreak(1, owner, EquipmentSlot.MAINHAND);
		}
		this.entityData.set(DATA_ITEM, stack.copy());
		this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_STRONG, SoundSource.HOSTILE, 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
		if (stack.isEmpty()) {
			revertToItem();
		}
		return true;
	}

	private void sweepAttack(ServerLevel serverLevel, Player owner, LivingEntity target, ItemStack stack, float baseDamage) {
		SweepAttackEvent event = new SweepAttackEvent(owner, target, true);
		NeoForge.EVENT_BUS.post(event);
		if (!event.isSweeping()) {
			return;
		}
		int sweepLevel = stack.getEnchantmentLevel(serverLevel.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE));
		float ratio = sweepLevel <= 0 ? 0.0F : 1.0F - 1.0F / (sweepLevel + 1.0F);
		float sweepDamage = 1.0F + ratio * baseDamage;
		DamageSource source = serverLevel.damageSources().playerAttack(owner);
		if (CustomAPI.GenshinCraftLoaded) {
			source = LivingItemGenshin.elementSource(stack, source, target);
		}
		List<LivingEntity> list = serverLevel.getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(1.0, 0.25, 1.0), e ->
				e != this && e != target && !this.isAlliedTo(e)
						&& e.getType() != EntityType.ARMOR_STAND
						&& !(e instanceof LivingItemEntity li && Objects.equals(li.getOwnerUuid(), this.getOwnerUuid()))
						&& this.distanceToSqr(e) < 9.0);
		for (LivingEntity e : list) {
			if (e.hurt(source, EnchantmentHelper.modifyDamage(serverLevel, stack, e, source, sweepDamage)) && e.invulnerableTime > 0) {
				e.invulnerableTime = Math.max(1, e.invulnerableTime / 4);
			}
		}
		serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 1.0F, 1.0F);
		serverLevel.sendParticles(ParticleTypes.SWEEP_ATTACK, this.getX(), this.getY() + 0.3, this.getZ(), 1, 0.0, 0.0, 0.0, 0.0);
	}

	private Mob findTarget(Player owner) {
		double range = Math.max(8.0, this.attackRange * 2.0);
		long now = this.level().getGameTime();
		List<Mob> mobs = this.level().getEntities(EntityTypeTest.forClass(Mob.class), this.getBoundingBox().inflate(range), mob -> {
			if (mob == this || mob.isDeadOrDying() || mob.isRemoved() || mob.getUUID().equals(owner.getUUID())) {
				return false;
			}
			if (mob instanceof LivingItemEntity) {
				return false;
			}
			if (mob instanceof TamableAnimal tamable && owner.getUUID().equals(tamable.getOwnerUUID())) {
				return false;
			}
			if (mob.isAlliedTo(this)) {
				return false;
			}
			Long blacklisted = this.attackBlacklist.get(mob.getUUID());
			return blacklisted == null || now - blacklisted >= ATTACK_BLACKLIST_TIME;
		});
		this.attackBlacklist.entrySet().removeIf(entry -> now - entry.getValue() >= ATTACK_BLACKLIST_TIME);
		this.ownerAttackMemory.entrySet().removeIf(entry -> now - entry.getValue() >= OWNER_ATTACK_MEMORY);
		Mob best = null;
		int bestLock = Integer.MAX_VALUE;
		double bestDistance = Double.MAX_VALUE;
		for (Mob mob : mobs) {
			if (!isThreat(mob, owner, now)) {
				continue;
			}
			int lock = countLocksOn(mob);
			double d = this.distanceToSqr(mob);
			if (lock < bestLock || (lock == bestLock && d < bestDistance)) {
				bestLock = lock;
				bestDistance = d;
				best = mob;
			}
		}
		return best;
	}

	private int countLocksOn(LivingEntity candidate) {
		if (this.level().isClientSide) {
			return 0;
		}
		int count = 0;
		List<LivingItemEntity> allies = this.level().getEntities(EntityTypeTest.forClass(LivingItemEntity.class),
				this.getBoundingBox().inflate(MAX_CHASE_DISTANCE),
				e -> e != this && Objects.equals(e.getOwnerUuid(), this.getOwnerUuid()));
		for (LivingItemEntity ally : allies) {
			if (ally.getTarget() == candidate) {
				count++;
			}
		}
		return count;
	}

	private boolean isThreat(Mob mob, Player owner, long now) {
		if (mob.getTarget() == owner || mob.getTarget() == this) {
			return true;
		}
		Long attacked = this.ownerAttackMemory.get(mob.getUUID());
		return attacked != null && now - attacked < OWNER_ATTACK_MEMORY;
	}

	private boolean isValidTarget(LivingEntity target, Player owner) {
		long now = this.level().getGameTime();
		if (this.distanceToSqr(target) > MAX_CHASE_DISTANCE * MAX_CHASE_DISTANCE) {
			return false;
		}
		if (target instanceof Mob mob && (mob.getTarget() == owner || mob.getTarget() == this)) {
			return true;
		}
		Long attacked = this.ownerAttackMemory.get(target.getUUID());
		return attacked != null && now - attacked < OWNER_ATTACK_MEMORY;
	}

	public void onOwnerAttack(Entity target) {
		if (this.level().isClientSide || this.isRemoved()) {
			return;
		}
		if (target == this || target instanceof LivingItemEntity other && Objects.equals(other.getOwnerUuid(), this.getOwnerUuid())) {
			return;
		}
		if (target instanceof LivingEntity living && living.isAlive() && !living.isRemoved()) {
			this.ownerAttackMemory.put(living.getUUID(), this.level().getGameTime());
			if (this.getTarget() == null && countLocksOn(living) < 1) {
				this.setTarget(living);
			}
		}
	}

	private void attemptRightClick(Player owner) {
		ItemStack stack = this.getCarriedStack();
		if (stack.isEmpty() || owner == null) {
			return;
		}
		Item item = stack.getItem();
		if (owner.getCooldowns().isOnCooldown(item)) {
			return;
		}
		this.entityData.set(DATA_ROTATE, 10);
		LivingEntity focus = this.getTarget() != null ? this.getTarget() : owner;
		if (isBowLike(stack)) {
			if (focus != owner) {
				bowShot(owner, focus);
			}
			return;
		}
		if (item == Items.WATER_BUCKET || item == Items.LAVA_BUCKET || item == Items.POWDER_SNOW_BUCKET) {
			placeFluidAt(focus, item);
			return;
		}
		if (item instanceof ProjectileItem) {
			launchProjectile(owner, focus, stack);
			return;
		}
		if (!canRightClick(stack)) {
			return;
		}
		useAsPlayer(owner, stack);
	}

	private void launchProjectile(Player owner, LivingEntity focus, ItemStack stack) {
		Vec3 pos = this.position().add(0, this.getBbHeight() * 0.8, 0);
		Vec3 dir = focus.getEyePosition().subtract(pos).normalize();
		if (!throwProjectile(owner, stack.copy(), pos, dir)) {
			return;
		}
		if (!this.isInfinite()) {
			stack.shrink(1);
		}
		if (stack.isEmpty()) {
			this.entityData.set(DATA_ITEM, ItemStack.EMPTY);
			revertToItem();
		} else {
			this.entityData.set(DATA_ITEM, stack.copy());
		}
	}

	private boolean throwProjectile(Player owner, ItemStack thrown, Vec3 pos, Vec3 dir) {
		Item item = thrown.getItem();
		if (item instanceof EnderpearlItem) {
			if (owner == null) {
				return false;
			}
			ThrownEnderpearl pearl = new ThrownEnderpearl(this.level(), owner);
			pearl.setPos(pos.x, pos.y, pos.z);
			pearl.setItem(thrown);
			pearl.shoot(dir.x, dir.y, dir.z, 1.5F, 1.0F);
			this.level().addFreshEntity(pearl);
			return true;
		}
		if (item instanceof ProjectileItem projectileItem) {
			Projectile projectile = projectileItem.asProjectile(this.level(), pos, thrown, Direction.UP);
			if (owner != null) {
				projectile.setOwner(owner);
			}
			projectile.setPos(pos.x, pos.y, pos.z);
			projectile.setDeltaMovement(dir.scale(1.2));
			this.level().addFreshEntity(projectile);
			return true;
		}
		return false;
	}

	private void placeFluidAt(LivingEntity focus, Item item) {
		Level level = this.level();
		if (level.isClientSide) {
			return;
		}
		BlockPos pos = focus.blockPosition();
		if (!level.getBlockState(pos).canBeReplaced()) {
			pos = pos.above();
		}
		BlockState state = null;
		if (item == Items.WATER_BUCKET) {
			state = Fluids.WATER.defaultFluidState().createLegacyBlock();
		} else if (item == Items.LAVA_BUCKET) {
			state = Fluids.LAVA.defaultFluidState().createLegacyBlock();
		} else if (item == Items.POWDER_SNOW_BUCKET) {
			state = Blocks.POWDER_SNOW.defaultBlockState();
		}
		if (state != null && level.getBlockState(pos).canBeReplaced()) {
			level.setBlockAndUpdate(pos, state);
			level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
			this.entityData.set(DATA_ITEM, new ItemStack(Items.BUCKET));
		}
	}

	private void useAsPlayer(Player owner, ItemStack stack) {
		int slot = owner.getInventory().selected;
		ItemStack oldHand = owner.getInventory().getItem(slot);
		owner.getInventory().setItem(slot, stack);
		ItemStack out;
		try {
			out = stack.getItem().use(this.level(), owner, InteractionHand.MAIN_HAND).getObject();
		} finally {
			owner.getInventory().setItem(slot, oldHand);
		}
		if (out.isEmpty()) {
			if (this.isInfinite()) {
				return;
			}
			this.entityData.set(DATA_ITEM, ItemStack.EMPTY);
			revertToItem();
			return;
		}
		if (!ItemStack.isSameItemSameComponents(stack, out) || stack.getCount() != out.getCount()) {
			this.entityData.set(DATA_ITEM, out.copy());
		}
	}

	private static boolean canRightClick(ItemStack stack) {
		return stack.is(TAG_RIGHT_CLICK);
	}

	public static boolean isBowLike(ItemStack stack) {
		if (stack == null || stack.isEmpty()) {
			return false;
		}
		UseAnim anim = stack.getUseAnimation();
		return anim == UseAnim.BOW || anim == UseAnim.CROSSBOW;
	}

	private static ItemStack findArrow(Player owner) {
		Inventory inv = owner.getInventory();
		for (ItemStack s : inv.items) {
			if (isArrow(s)) {
				return s;
			}
		}
		for (ItemStack s : inv.offhand) {
			if (isArrow(s)) {
				return s;
			}
		}
		return ItemStack.EMPTY;
	}

	private static boolean isArrow(ItemStack stack) {
		Item item = stack.getItem();
		return item == Items.ARROW || item == Items.SPECTRAL_ARROW || item == Items.TIPPED_ARROW;
	}

	private boolean bowShot(Player owner, LivingEntity target) {
		ItemStack ammo = findArrow(owner);
		if (ammo == null || ammo.isEmpty()) {
			return false;
		}
		ItemStack arrowStack = ammo.copy();
		ammo.shrink(1);
		AbstractArrow arrow = ProjectileUtil.getMobArrow(owner, arrowStack, 2.5F, this.getCarriedStack());
		double y = this.getY() + this.getBbHeight() * 0.8;
		arrow.setPos(this.getX(), y, this.getZ());
		Vec3 to = new Vec3(target.getX() - this.getX(), target.getEyeY() - y, target.getZ() - this.getZ());
		arrow.shoot(to.x, to.y, to.z, 2.2F, 0.8F);
		this.level().addFreshEntity(arrow);
		return true;
	}

	private boolean tryThrowSelf() {
		ItemStack stack = this.getCarriedStack();
		if (stack.isEmpty()) {
			return false;
		}
		Player owner = getOwner();
		LivingEntity aim = this.getTarget() != null ? this.getTarget() : owner;
		Vec3 pos = this.position().add(0, this.getBbHeight() * 0.8, 0);
		Vec3 dir = aim != null ? aim.getEyePosition().subtract(pos).normalize() : this.getLookAngle();
		if (!throwProjectile(owner, stack, pos, dir)) {
			return false;
		}
		if (owner != null && stack.getCount() > 1) {
			ItemStack rest = stack.copy();
			rest.setCount(stack.getCount() - 1);
			owner.getInventory().add(rest);
		}
		playDisappearEffects();
		this.reverted = true;
		this.discard();
		return true;
	}

	private void playDisappearEffects() {
		if (this.level() instanceof ServerLevel serverLevel) {
			serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.AMBIENT, 1.0F, 1.0F);
			serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.BEACON_DEACTIVATE, SoundSource.AMBIENT, 1.0F, 1.0F);
			serverLevel.sendParticles(ParticleTypes.FIREWORK, this.getX(), this.getY() + 0.6, this.getZ(), 24, 0.4, 0.4, 0.4, 0.2);
		}
	}

	public void revertToItem() {
		if (this.isInfinite()) {
			return;
		}
		revert();
	}

	public void revertByDeath() {
		revert();
	}

	public void revertByOwner() {
		revert();
	}

	private void revert() {
		if (this.reverted) {
			return;
		}
		this.reverted = true;
		playDisappearEffects();
		ItemStack stack = this.getCarriedStack();
		Player owner = getOwner();
		boolean deathDrop = owner != null && owner.isDeadOrDying() && !owner.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY);
		boolean added = false;
		if (owner != null && !stack.isEmpty() && !deathDrop) {
			added = owner.getInventory().add(stack);
		}
		if (!stack.isEmpty() && !added) {
			double x = owner != null && !deathDrop ? owner.getX() : this.getX();
			double y = owner != null && !deathDrop ? owner.getY() : this.getY();
			double z = owner != null && !deathDrop ? owner.getZ() : this.getZ();
			if (this.level() instanceof ServerLevel serverLevel && y < serverLevel.getMinBuildHeight() + 5) {
				BlockPos spawn = serverLevel.getSharedSpawnPos();
				x = spawn.getX() + 0.5;
				y = spawn.getY() + 1.0;
				z = spawn.getZ() + 0.5;
			}
			BlockPos pos = BlockPos.containing(x, y, z);
			while (!this.level().getBlockState(pos).canBeReplaced() && pos.getY() < this.level().getMaxBuildHeight() - 1) {
				pos = pos.above();
			}
			LivingItemDrop drop = new LivingItemDrop(this.level(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack, owner != null ? owner.getUUID() : null);
			this.level().addFreshEntity(drop);
		}
		if (!this.level().isClientSide) {
			this.level().getScoreboard().removePlayerFromTeam(this.getStringUUID());
		}
		this.discard();
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.8);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2.0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
		builder = builder.add(Attributes.FLYING_SPEED, 0.8);
		builder = builder.add(NeoForgeMod.SWIM_SPEED, 1);
		return builder;
	}
}
