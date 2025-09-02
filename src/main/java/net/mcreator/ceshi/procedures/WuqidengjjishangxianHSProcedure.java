package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class WuqidengjjishangxianHSProcedure {
	public static double execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return 0;
		double a11 = 0;
		a11 = (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGXIAN));
		return a11 + (HSjinglianupProcedure.execute(entity, itemstack) > 3 ? Math.floor((a11 + 1) / 9) : 0);
	}
}