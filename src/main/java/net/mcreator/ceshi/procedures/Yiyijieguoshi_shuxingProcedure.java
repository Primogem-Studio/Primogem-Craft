package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Yiyijieguoshi_shuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		YimuguoshisxhsProcedure.execute(world, x, y, z, entity, itemstack, itemstack, false, itemstack.getItem() == PrimogemcraftModItems.QWKWZG.get() ? false : true, 2);
	}
}
