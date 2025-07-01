package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.DjqjkaishiProcedure;
import net.mcreator.ceshi.procedures.DjppguochengProcedure;

public class DjppMobEffect extends MobEffect {
	public DjppMobEffect() {
		super(MobEffectCategory.NEUTRAL, -3342337);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		DjqjkaishiProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		DjppguochengProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}