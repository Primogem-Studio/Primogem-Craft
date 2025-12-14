package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.entity.QQQyuanchulan01Entity;

public class Qiyuanshiti_chushengxiaoguoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean o1 = false;
		double a = 0;
		double b = 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI, (int) (entity instanceof QQQyuanchulan01Entity ? 40 : 20), 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 5, false, false));
	}
}