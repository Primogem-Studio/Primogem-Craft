package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.ceshi.procedures.Jdsbcf_0_xg_sx_1Procedure;
import net.mcreator.ceshi.procedures.Jdsbcf0xgsx0Procedure;

public class Jdsbcf0xgMobEffect extends MobEffect {
	public Jdsbcf0xgMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		Jdsbcf0xgsx0Procedure.execute(entity.level(), entity);
	}

	@Override
	public void onMobHurt(LivingEntity entity, int amplifier, DamageSource damagesource, float damage) {
		Jdsbcf_0_xg_sx_1Procedure.execute(entity.level(), entity);
	}
}