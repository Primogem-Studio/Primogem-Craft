package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.YjsxProcedure;
import net.mcreator.ceshi.procedures.Yjsx2Procedure;

public class YijiMobEffect extends MobEffect {
	public YijiMobEffect() {
		super(MobEffectCategory.NEUTRAL, -8123894);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		YjsxProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Yjsx2Procedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}