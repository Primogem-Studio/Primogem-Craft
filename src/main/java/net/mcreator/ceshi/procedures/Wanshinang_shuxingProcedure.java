package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Wanshinang_shuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String a = "";
		if (!world.isClientSide()) {
			if (entity.getPersistentData().getBoolean("guan_zi_po_huai")) {
				entity.getPersistentData().putBoolean("guan_zi_po_huai", false);
				HSqwwsnProcedure.execute(world, x, y, z, entity, ItemStack.EMPTY, itemstack, false, true, 1, 1, "loot spawn ~ ~ ~ loot primogemcraft:blocks/daguanzi", itemstack.getDisplayName().getString(),
						"loot spawn ~ ~ ~ loot primogemcraft:blocks/xiaoguanzi");
			}
		}
	}
}