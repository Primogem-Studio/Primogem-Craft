package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Heisenlin_ggz_xiaoguo_sx_0Procedure;

public class HeisenlinggzMobEffect extends MobEffect {
	public HeisenlinggzMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10066330);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Heisenlin_ggz_xiaoguo_sx_0Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}