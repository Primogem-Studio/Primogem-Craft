package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Ceshi_3Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.BNXXU, -1, 5, false, false));
	}
}