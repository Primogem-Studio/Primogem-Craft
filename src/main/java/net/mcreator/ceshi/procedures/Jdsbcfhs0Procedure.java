package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Jdsbcfhs0Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return false;
		if (!world.isClientSide()) {
			if (itemstack.getDamageValue() == 0) {
				itemstack.setDamageValue(99);
				DiaoyongqwyisunhuaiProcedure.execute(world, x, y, z, entity, itemstack);
				return true;
			}
		}
		return false;
	}
}