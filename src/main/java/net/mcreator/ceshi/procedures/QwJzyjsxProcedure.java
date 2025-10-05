package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.h;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class QwJzyjsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double h = 0;
		ItemStack stack = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			stack = itemstack;
			if (EwaishhsProcedure.execute(entity, "jzyj")) {
				h = entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1;
				EwaishhsProcedure.sl(Math.min(h * 0.3, h * 0.003 * EwaishhsProcedure.obd(entity)), "jzyj", itemstack);
			}
		}
	}
}