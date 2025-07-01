package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Qianye_shuxingProcedure;

public class QianyeMobEffect extends MobEffect {
	public QianyeMobEffect() {
		super(MobEffectCategory.HARMFUL, -5243565);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Qianye_shuxingProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}