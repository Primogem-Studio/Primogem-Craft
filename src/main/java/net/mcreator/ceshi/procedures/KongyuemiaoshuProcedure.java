package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.client.gui.screens.Screen;

import net.hackermdch.pgc.CustomAPI;

public class KongyuemiaoshuProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack stack = ItemStack.EMPTY;
		stack = itemstack;
		var bar = CustomAPI.getCustomBar(stack);
		if (Screen.hasShiftDown()) {
			bar.visible = true;
		} else {
			bar.visible = false;
		}
		return "\u00A77\u624B\u6301\u957F\u6309\u5373\u53EF\u9886\u53D6" + "\n"
				+ Diaoyongshift0Procedure.execute("\u00A77\u6BCF\u5929\u53EF\u4EE5\u9886\u53D610~90\u539F\u77F3\u788E\u7247" + "\n" + ("\u00A7b\u8DDD\u79BB\u6708\u5361\u5230\u671F\u8FD8\u5269 " + bar.numerator + " \u5929"), "\u8BE6\u60C5");
	}
}