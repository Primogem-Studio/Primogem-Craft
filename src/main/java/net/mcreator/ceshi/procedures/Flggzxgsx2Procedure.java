package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.PrimogemcraftMod;

public class Flggzxgsx2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("fenlie_ggz_b")) {
			PrimogemcraftMod.queueServerWork(1, () -> {
				if (entity.getPersistentData().getBoolean("fenlie_ggz_c")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FZGGZXG_1, 100, (int) (entity.getPersistentData().getDouble("fenlie_ggz_c") - 1), false, false));
				}
			});
		}
	}
}