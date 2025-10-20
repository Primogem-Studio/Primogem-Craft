package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.BnxxusxProcedure;

public class BnxxuMobEffect extends MobEffect {
	public BnxxuMobEffect() {
		super(MobEffectCategory.NEUTRAL, -6684673);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		BnxxusxProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}