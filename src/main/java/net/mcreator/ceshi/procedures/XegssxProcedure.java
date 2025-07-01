package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class XegssxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (YimuguoshisxhsProcedure.execute(world, x, y, z, entity, itemstack, itemstack, false, true, 5, 1200, 2)) {
			entity.getPersistentData().putBoolean("ypz_ymgs", true);
		}
	}
}