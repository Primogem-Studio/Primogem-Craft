package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;

public class DiaoyongwupindiaoluoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack item, double shu_liang) {
		double a1 = 0;
		double a11 = 0;
		double a = 0;
		double a2 = 0;
		double b = 0;
		double c = 0;
		ItemStack i1 = ItemStack.EMPTY;
		i1 = item;
		i1.setCount((int) shu_liang);
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, i1);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}