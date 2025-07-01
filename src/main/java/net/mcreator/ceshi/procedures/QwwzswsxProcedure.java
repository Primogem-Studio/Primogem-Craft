package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class QwwzswsxProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			HSWzswsProcedure.execute(world, x, z, entity, itemstack, 6000, 300);
		}
	}
}