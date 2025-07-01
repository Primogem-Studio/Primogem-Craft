package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class XixiangdanganlaoshiyongxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		HssmhfProcedure.execute(world, x, y, z, entity, true, 0.3, new ItemStack(PrimogemcraftModItems.XIANGDANGANLAO.get()).getDisplayName().getString());
	}
}