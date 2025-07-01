package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Qwlhsx0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (!world.isClientSide()) {
			if (itemstack.getItem() == PrimogemcraftModItems.QWLHS.get()) {
				QwlhsxProcedure.execute(world, x, y, z, entity, itemstack, "c:curio/normal/s");
			}
			if (itemstack.getItem() == PrimogemcraftModItems.QWLHA.get()) {
				QwlhsxProcedure.execute(world, x, y, z, entity, itemstack, "c:curio/normal/a");
			}
			if (itemstack.getItem() == PrimogemcraftModItems.QWLHB.get()) {
				QwlhsxProcedure.execute(world, x, y, z, entity, itemstack, "c:curio/normal/b");
			}
		}
	}
}