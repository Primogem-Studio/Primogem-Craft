package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Wqzhg_sx_0Procedure {
	public static void execute(LevelAccessor world, Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		if (!world.isClientSide()) {
			itemstack.setDamageValue((int) (itemstack.getDamageValue() - 0.5 * HSjinglianProcedure.execute(sourceentity, itemstack)));
		}
	}
}