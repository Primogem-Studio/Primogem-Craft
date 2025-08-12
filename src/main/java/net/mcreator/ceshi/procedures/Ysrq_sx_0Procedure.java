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
		String s1 = "";
		String s2 = "";
		if (!world.isClientSide()) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("qidong")) {
				a = Mth.nextInt(RandomSource.create(), 0, 5);
				if (a == 0) {
					s1 = "feng";
					s2 = "\u00A72\u5143\u7D20\u7194\u73E0";
				}
				if (a == 1) {
					s1 = "yan";
					s2 = "\u00A76\u5143\u7D20\u7194\u73E0";
				}
				if (a == 2) {
					s1 = "lei";
					s2 = "\u00A7d\u5143\u7D20\u7194\u73E0";
				}
				if (a == 3) {
					s1 = "cao";
					s2 = "\u00A7a\u5143\u7D20\u7194\u73E0";
				}
				if (a == 4) {
					s1 = "shui";
					s2 = "\u00A79\u5143\u7D20\u7194\u73E0";
				}
				if (a == 5) {
					s1 = "huo";
					s2 = "\u00A7c\u5143\u7D20\u7194\u73E0";
				}
				Ysrz_hs_hs(s1, s2, itemstack);
				{
					final String _tagName = "qidong";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			}
		}
	}

	public static void Ysrz_hs_hs(String s1, String s2, ItemStack itemstack) {
		String _tagName = s1;
		final double _tagValue = 1;
		CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(String.valueOf(s2)));
	}
}