package net.AI;

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
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
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
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.EnderpearlItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.List;
import java.util.Optional;
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

	private int remainingTicks;
	private int attackCooldown;
	private int attackInterval = 20;
	private int useCooldown;
	private int scanCooldown;
	private double attackRange = 3.0;
	private boolean reverted;

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
		double damage = 0.0;
		double speed = 4.0;
		ItemAttributeModifiers mods = stack.get(DataComponents.ATTRIBUTE_MODIFIERS);
		if (mods != null) {
			for (ItemAttributeModifiers.Entry entry : mods.modifiers()) {
				Holder<net.minecraft.world.entity.ai.attributes.Attribute> attribute = entry.attribute();
				AttributeModifier modifier = entry.modifier();
				if (attribute.is(Attributes.ATTACK_DAMAGE.getKey()) && modifier.operation() == AttributeModifier.Operation.ADD_VALUE) {
					damage += modifier.amount();
				}
				if (attribute.is(Attributes.ATTACK_SPEED.getKey()) && modifier.operation() == AttributeModifier.Operation.ADD_VALUE) {
					speed += modifier.amount();
				}
			}
		}
		if (this.getAttribute(Attributes.ATTACK_DAMAGE) != null) {
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(Math.max(0.0, damage));
		}
		this.attackInterval = (int) Math.max(1, Math.round(20.0 / Math.max(0.1, speed))) + 4;
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
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		return false;
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
			revertToItem();
			return;
		}
		if (this.useCooldown > 0) {
			this.useCooldown--;
		} else {
			this.useCooldown = 120 + this.random.nextInt(120);
			attemptRightClick(owner);
		}
		LivingEntity target = this.getTarget();
		if (target != null && target.isAlive() && !target.isRemoved() && this.distanceToSqr(target) < 32.0 * 32.0) {
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

	private void followOwner(Player owner) {
		double distSq = this.distanceToSqr(owner);
		if (distSq > 24.0 * 24.0) {
			this.teleportTo(owner.getX(), owner.getY() + 1.5, owner.getZ());
			return;
		}
		if (distSq > 8.0 * 8.0) {
			this.getNavigation().moveTo(owner.getX(), owner.getY() + 1.5, owner.getZ(), 1.2);
			this.lookAt(owner, 30.0F, 30.0F);
		}
	}

	private void updateCombat(Player owner, LivingEntity target) {
		if (this.attackCooldown > 0) {
			this.attackCooldown--;
			return;
		}
		this.lookAt(target, 30.0F, 30.0F);
		ItemStack stack = this.getCarriedStack();
		if (isBowLike(stack)) {
			if (bowShot(owner, target)) {
				this.entityData.set(DATA_SWING, 5);
				this.attackCooldown = Math.max(10, this.attackInterval);
			} else {
				this.attackCooldown = 5;
			}
			return;
		}
		double distSq = this.distanceToSqr(target);
		if (distSq > this.attackRange * this.attackRange) {
			this.getNavigation().moveTo(target, 1.2);
			this.attackCooldown = 2;
			return;
		}
		float damage = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
		if (target.hurt(this.level().damageSources().playerAttack(owner), damage)) {
			this.entityData.set(DATA_SWING, 5);
			this.attackCooldown = this.attackInterval;
			stack.getItem().hurtEnemy(stack, target, owner);
		}
	}

	private Mob findTarget(Player owner) {
		double range = Math.max(8.0, this.attackRange * 2.0);
		List<Mob> mobs = this.level().getEntities(EntityTypeTest.forClass(Mob.class), this.getBoundingBox().inflate(range), mob -> {
			if (mob == this || mob.isDeadOrDying() || mob.getUUID().equals(owner.getUUID())) {
				return false;
			}
			if (mob.getTarget() != owner && mob.getLastHurtByMob() != owner && mob.getTarget() != this) {
				return false;
			}
			return !mob.isAlliedTo(this);
		});
		Mob nearest = null;
		double nearestDist = Double.MAX_VALUE;
		for (Mob mob : mobs) {
			double d = this.distanceToSqr(mob);
			if (d < nearestDist) {
				nearestDist = d;
				nearest = mob;
			}
		}
		return nearest;
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
		if (!canRightClick(stack)) {
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
		if (item instanceof ProjectileItem projectileItem) {
			launchProjectile(owner, focus, stack, projectileItem);
			return;
		}
		useAsPlayer(owner, stack);
	}

	private void launchProjectile(Player owner, LivingEntity focus, ItemStack stack, ProjectileItem projectileItem) {
		Vec3 pos = this.position().add(0, this.getBbHeight() * 0.8, 0);
		Vec3 dir = focus.getEyePosition().subtract(pos).normalize();
		if (stack.getItem() instanceof EnderpearlItem) {
			if (owner != null) {
				ThrownEnderpearl pearl = new ThrownEnderpearl(this.level(), owner);
				pearl.setPos(pos.x, pos.y, pos.z);
				pearl.setItem(stack);
				pearl.shoot(dir.x, dir.y, dir.z, 1.5F, 1.0F);
				this.level().addFreshEntity(pearl);
			}
		} else {
			Projectile projectile = projectileItem.asProjectile(this.level(), pos, stack, Direction.UP);
			if (owner != null) {
				projectile.setOwner(owner);
			}
			projectile.setPos(pos.x, pos.y, pos.z);
			projectile.setDeltaMovement(dir.scale(1.2));
			this.level().addFreshEntity(projectile);
		}
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

	private static boolean isBowLike(ItemStack stack) {
		Item item = stack.getItem();
		return item instanceof BowItem || item instanceof CrossbowItem;
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
		Item item = stack.getItem();
		Player owner = getOwner();
		LivingEntity aim = this.getTarget() != null ? this.getTarget() : owner;
		Vec3 pos = this.position().add(0, this.getBbHeight() * 0.8, 0);
		Vec3 dir = aim != null ? aim.getEyePosition().subtract(pos).normalize() : this.getLookAngle();
		if (item instanceof EnderpearlItem) {
			if (owner != null) {
				ThrownEnderpearl pearl = new ThrownEnderpearl(this.level(), owner);
				pearl.setPos(pos.x, pos.y, pos.z);
				pearl.setItem(stack);
				pearl.shoot(dir.x, dir.y, dir.z, 1.5F, 1.0F);
				this.level().addFreshEntity(pearl);
			}
		} else if (item instanceof ProjectileItem projectileItem) {
			Projectile projectile = projectileItem.asProjectile(this.level(), pos, stack, Direction.UP);
			if (owner != null) {
				projectile.setOwner(owner);
			}
			projectile.setPos(pos.x, pos.y, pos.z);
			projectile.setDeltaMovement(dir.scale(1.2));
			this.level().addFreshEntity(projectile);
		} else {
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

	private void revertToItem() {
		if (this.reverted) {
			return;
		}
		this.reverted = true;
		playDisappearEffects();
		ItemStack stack = this.getCarriedStack();
		Player owner = getOwner();
		boolean added = false;
		if (owner != null && !stack.isEmpty()) {
			added = owner.getInventory().add(stack);
		}
		if (!stack.isEmpty() && !added) {
			double x = owner != null ? owner.getX() : this.getX();
			double y = owner != null ? owner.getY() : this.getY();
			double z = owner != null ? owner.getZ() : this.getZ();
			LivingItemDrop drop = new LivingItemDrop(this.level(), x, y + 0.5, z, stack, owner != null ? owner.getUUID() : null);
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
