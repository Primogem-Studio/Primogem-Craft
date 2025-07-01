package net.mcreator.ceshi.entity;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.procedures.QqiwushitisiwangluojiProcedure;

public class QqiwuzhanlipinshitiEntity extends PathfinderMob {
	public QqiwuzhanlipinshitiEntity(EntityType<QqiwuzhanlipinshitiEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(true);
		setPersistenceRequired();
		this.setPathfindingMalus(PathType.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (QqiwuzhanlipinshitiEntity.this.isInWater())
					QqiwuzhanlipinshitiEntity.this.setDeltaMovement(QqiwuzhanlipinshitiEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !QqiwuzhanlipinshitiEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - QqiwuzhanlipinshitiEntity.this.getX();
					double dy = this.wantedY - QqiwuzhanlipinshitiEntity.this.getY();
					double dz = this.wantedZ - QqiwuzhanlipinshitiEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * QqiwuzhanlipinshitiEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					QqiwuzhanlipinshitiEntity.this.setYRot(this.rotlerp(QqiwuzhanlipinshitiEntity.this.getYRot(), f, 10));
					QqiwuzhanlipinshitiEntity.this.yBodyRot = QqiwuzhanlipinshitiEntity.this.getYRot();
					QqiwuzhanlipinshitiEntity.this.yHeadRot = QqiwuzhanlipinshitiEntity.this.getYRot();
					if (QqiwuzhanlipinshitiEntity.this.isInWater()) {
						QqiwuzhanlipinshitiEntity.this.setSpeed((float) QqiwuzhanlipinshitiEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						QqiwuzhanlipinshitiEntity.this.setXRot(this.rotlerp(QqiwuzhanlipinshitiEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(QqiwuzhanlipinshitiEntity.this.getXRot() * (float) (Math.PI / 180.0));
						QqiwuzhanlipinshitiEntity.this.setZza(f3 * f1);
						QqiwuzhanlipinshitiEntity.this.setYya((float) (f1 * dy));
					} else {
						QqiwuzhanlipinshitiEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					QqiwuzhanlipinshitiEntity.this.setSpeed(0);
					QqiwuzhanlipinshitiEntity.this.setYya(0);
					QqiwuzhanlipinshitiEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:wu_sheng"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:wu_sheng")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:wu_sheng"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:wu_sheng"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		QqiwushitisiwangluojiProcedure.execute(this.level(), this);
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 0);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 0);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(NeoForgeMod.SWIM_SPEED, 0);
		return builder;
	}
}