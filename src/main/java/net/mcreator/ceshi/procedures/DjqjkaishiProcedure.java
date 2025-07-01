package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class DjqjkaishiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(PrimogemcraftModMobEffects.DJPPXIANZHI);
	}
}