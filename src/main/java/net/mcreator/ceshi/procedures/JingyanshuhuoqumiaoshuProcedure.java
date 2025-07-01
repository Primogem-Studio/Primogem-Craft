package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

public class JingyanshuhuoqumiaoshuProcedure {
	public static String execute(ItemStack itemstack) {
		return !itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean((Minecraft.getInstance().player.getDisplayName().getString()))
				? "\u00A76\u624B\u6301\u53F3\u952E\u83B7\u53D6\u5176\u4E2D\u77E5\u8BC6"
				: "\u00A7c\u8BE5\u7ECF\u9A8C\u4E66\u5DF2\u88AB\u4F60\u5B66\u4E60";
	}
}