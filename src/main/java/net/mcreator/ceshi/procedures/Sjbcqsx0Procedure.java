package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class Sjbcqsx0Procedure {
	public static String execute(ItemStack itemstack) {
		return "\u00A78\u5305\u542B\u4E00\u6B21" + ("" + (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shijianbuchang") == 1
				? "\u00A77\u4F4E\u54C1\u8D28"
				: "" + (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shijianbuchang") == 2
						? "\u00A7b\u4E2D\u54C1\u8D28"
						: "" + (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shijianbuchang") == 3
								? "\u00A76\u9AD8\u54C1\u8D28"
								: "" + (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shijianbuchang") == 4 ? "\u00A7c\u7279\u7EA7\u54C1\u8D28" : "\u00A77[\u7A7A]")))))
				+ "\u00A78\u9644\u9B54";
	}
}