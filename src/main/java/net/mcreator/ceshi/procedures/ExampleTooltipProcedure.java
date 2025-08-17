package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

import net.hackermdch.pgc.CustomAPI;

public class ExampleTooltipProcedure {
	public static String execute(ItemStack itemstack, String zhi) {
		if (zhi == null)
			return "";
		ItemStack stack = ItemStack.EMPTY;
		stack = itemstack.copy();
		var bar = CustomAPI.getCustomBar(stack);
		return (zhi + ":") + "" + bar.numerator + "/" + bar.denominator;
	}
}