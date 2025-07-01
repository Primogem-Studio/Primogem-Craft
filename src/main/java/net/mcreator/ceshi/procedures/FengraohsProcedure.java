package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class FengraohsProcedure {
	public static void execute(LevelAccessor world, Entity entity, double zhi) {
		if (entity == null)
			return;
		if (Math.random() < zhi * (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FENGRAO, 2000000, 0));
		}
	}
}