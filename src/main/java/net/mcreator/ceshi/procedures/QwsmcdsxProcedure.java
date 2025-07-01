package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QwsmcdsxProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return false;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (entity.getPersistentData().getBoolean("guan_zi_po_huai")) {
				entity.getPersistentData().putBoolean("guan_zi_po_huai", false);
				a = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()).copy();
				a.setCount(Mth.nextInt(RandomSource.create(), 1, 5));
				if (HSqwwsnProcedure.execute(world, x, y, z, entity, a, itemstack, true, true, 1, 1, "loot spawn ~ ~ ~ loot primogemcraft:blocks/daguanzi", itemstack.getDisplayName().getString(),
						"loot spawn ~ ~ ~ loot primogemcraft:blocks/xiaoguanzi")) {
					return true;
				}
			}
		}
		return false;
	}
}