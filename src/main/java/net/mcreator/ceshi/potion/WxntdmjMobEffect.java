package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Wxntdmj_xg_sxProcedure;

public class WxntdmjMobEffect extends MobEffect {
	public WxntdmjMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Wxntdmj_xg_sxProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}