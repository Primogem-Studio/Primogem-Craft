package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class FenliejinbishuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			FenliejinbisxhsProcedure.execute(world, x, y, z, entity, new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), itemstack, true, 10, 0.5, 12, 10);
		}
	}
}