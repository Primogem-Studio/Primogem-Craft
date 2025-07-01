package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Qianye_shuxingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("qianye_shuxing", (entity.getPersistentData().getDouble("qianye_shuxing") + 1));
		if (entity.getPersistentData().getDouble("qianye_shuxing") >= 40) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)),
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.QIANYE) ? _livEnt.getEffect(PrimogemcraftModMobEffects.QIANYE).getAmplifier() : 0);
			entity.getPersistentData().putDouble("qianye_shuxing", 0);
		}
	}
}