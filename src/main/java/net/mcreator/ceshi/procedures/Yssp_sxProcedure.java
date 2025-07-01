package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class Yssp_sxProcedure {
	public static double execute(LevelAccessor world, ItemStack itemstack) {
		if (world != null && world.isClientSide()) {
			return itemstack.getCount();
		}
		return 0;
	}
}