package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Zuoshao_sxProcedure;

public class ZhuoshaoMobEffect extends MobEffect {
	public ZhuoshaoMobEffect() {
		super(MobEffectCategory.HARMFUL, -21961);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Zuoshao_sxProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}