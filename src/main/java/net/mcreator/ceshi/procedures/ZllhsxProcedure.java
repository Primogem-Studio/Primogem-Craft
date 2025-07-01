package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class ZllhsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (itemstack.getItem() == PrimogemcraftModItems.QHZLH.get()) {
			ZllhsxhsProcedure.execute(world, x, y, z, entity, itemstack, itemstack, "loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_01");
		}
		if (itemstack.getItem() == PrimogemcraftModItems.QHZLLH_2.get()) {
			ZllhsxhsProcedure.execute(world, x, y, z, entity, itemstack, itemstack, "loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_02");
		}
		if (itemstack.getItem() == PrimogemcraftModItems.Q_QU_HANG_ZHOULLH.get()) {
			ZllhsxhsProcedure.execute(world, x, y, z, entity, itemstack, itemstack, "loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_03");
		}
		if (itemstack.getItem() == PrimogemcraftModItems.QHZLLH_4.get()) {
			ZllhsxhsProcedure.execute(world, x, y, z, entity, itemstack, itemstack, "loot spawn ~ ~1 ~ loot primogemcraft:entities/zllh_4zlp");
		}
	}
}