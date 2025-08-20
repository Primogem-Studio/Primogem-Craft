package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class DiaoyongNBTluojiProcedure {
	public static boolean execute(ItemStack itemstack, String zhi) {
		if (zhi == null)
			return false;
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean(zhi);
	}
}