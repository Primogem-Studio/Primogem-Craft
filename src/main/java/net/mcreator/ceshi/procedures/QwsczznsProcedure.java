package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class QwsczznsProcedure {
	public static String execute(ItemStack itemstack) {
		double n1 = 0;
		String s1 = "";
		n1 = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("qw");
		switch ((int) n1) {
			case 1 : {
				s1 = "§f低品质";
			}
				break;
			case 2 : {
				s1 = "§b中品质";
			}
				break;
			case 3 : {
				s1 = "§6高品质";
			}
				break;
		}
		return n1 > 0 ? "\u00A77\u53F3\u952E\u9009\u62E9" + s1 + "\u00A77\u5947\u7269" : "\u00A77\u6682\u672A\u663E\u73B0\u54C1\u8D28";
	}
}