package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class Jslyzhsx1Procedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("jing_lian_shua_xin")) {
			JlqhewaiProcedure.execute(entity, itemstack);
			entity.getPersistentData().putBoolean("jing_lian_shua_xin", true);
		}
	}
}