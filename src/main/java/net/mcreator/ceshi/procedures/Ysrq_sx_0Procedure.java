package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class Ysrq_sx_0Procedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		double a = 0;
		if (!world.isClientSide()) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("qidong")) {
				a = Mth.nextInt(RandomSource.create(), 1, 6);
				if (a == 1) {
					{
						final String _tagName = "feng";
						final double _tagValue = 1;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A72\u5143\u7D20\u7194\u73E0"));
				}
				if (a == 2) {
					{
						final String _tagName = "yan";
						final double _tagValue = 1;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A76\u5143\u7D20\u7194\u73E0"));
				}
				if (a == 3) {
					{
						final String _tagName = "lei";
						final double _tagValue = 1;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7d\u5143\u7D20\u7194\u73E0"));
				}
				if (a == 4) {
					{
						final String _tagName = "cao";
						final double _tagValue = 1;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7a\u5143\u7D20\u7194\u73E0"));
				}
				if (a == 5) {
					{
						final String _tagName = "shui";
						final double _tagValue = 1;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A79\u5143\u7D20\u7194\u73E0"));
				}
				if (a == 6) {
					{
						final String _tagName = "huo";
						final double _tagValue = 1;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7c\u5143\u7D20\u7194\u73E0"));
				}
				{
					final String _tagName = "qidong";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			}
		}
	}
}