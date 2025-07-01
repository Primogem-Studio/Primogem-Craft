package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Fengrao_lizishuxingProcedure;

public class FengraoMobEffect extends MobEffect {
	public FengraoMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16038607);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Fengrao_lizishuxingProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}