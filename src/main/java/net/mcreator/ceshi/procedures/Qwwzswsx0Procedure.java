package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Qwwzswsx0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			HS0wzswProcedure.execute(world, x, y, z, entity, ItemStack.EMPTY, itemstack, true, 5, 10, "loot spawn ~ ~ ~ loot primogemcraft:entities/qqiwuzhanlipinshiti");
		}
	}
}