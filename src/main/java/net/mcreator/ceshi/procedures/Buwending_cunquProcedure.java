package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class Buwending_cunquProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("bwd_yinhang");
	}
}