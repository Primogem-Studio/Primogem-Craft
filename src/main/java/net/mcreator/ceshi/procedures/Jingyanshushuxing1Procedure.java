package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class Jingyanshushuxing1Procedure {
	public static String execute(LevelAccessor world, ItemStack itemstack) {
		if (world != null && world.isClientSide()) {
			return JingyanshuhuoqumiaoshuProcedure.execute(itemstack);
		}
		return "";
	}
}