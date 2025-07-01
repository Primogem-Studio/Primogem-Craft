package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import net.hackermdch.pgc.CustomAPI;

public class QxzhqsxpfProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack i1 = ItemStack.EMPTY;
		ItemStack i2 = ItemStack.EMPTY;
		var recipe = CustomAPI.findConvertRecipe(world, x, y, z);
		if (recipe.getA() != null) {
			i1 = recipe.getA().input();
			i2 = recipe.getA().output();
			QxzhqsxhsProcedure.execute(world, x, y, z, i2, i1, recipe.getA().cost(), 1, i1.getCount(), i2.getCount());
		}
		if (recipe.getB() != null) {
			i1 = recipe.getB().input();
			i2 = recipe.getB().output();
			QxzhqsxhsProcedure.execute(world, x, y, z, i2, i1, recipe.getB().cost(), 3, i1.getCount(), i2.getCount());
		}
	}
}