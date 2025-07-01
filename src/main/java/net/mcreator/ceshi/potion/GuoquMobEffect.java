package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.GuoqukaishiProcedure;

public class GuoquMobEffect extends MobEffect {
	public GuoquMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -479233);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GuoqukaishiProcedure.execute(entity.level(), entity);
	}
}