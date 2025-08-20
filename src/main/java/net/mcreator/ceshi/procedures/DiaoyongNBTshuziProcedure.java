package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class DiaoyongNBTshuziProcedure {
	public static double execute(ItemStack itemstack, String zhi) {
		if (zhi == null)
			return 0;
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(zhi);
	}
}