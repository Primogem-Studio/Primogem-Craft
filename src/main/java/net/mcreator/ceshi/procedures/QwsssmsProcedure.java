package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class QwsssmsProcedure {
	public static String execute(ItemStack itemstack) {
		return Diaoyongshift0Procedure.execute("\u00A77\u5C06\u81EA\u8EAB\u7684\u751F\u547D\u503C \u9971\u98DF\u5EA6 \u9971\u548C\u5EA6\u56DE\u590D\u81F3100%" + "\n"
				+ "\u00A77 \u5E76\u79FB\u9664\u6240\u6709\u6548\u679C\u540E\u8BB0\u5F55\u6216\u8986\u76D6\u4E00\u6B21\u5F53\u524D\u5750\u6807" + "\n"
				+ "\u00A77\u6548\u679C\u51B7\u53745\u5206\u949F\u3002\u51B7\u5374\u671F\u95F4\u5DE6\u952E\u56DE\u5230\u8BB0\u5F55\u70B9" + "\n" + "\u00A7c\u00A7l\u4F20\u9001\u6548\u679C\u4E0D\u53EF\u8DE8\u7EAC\u5EA6\uFF01" + "\n" + "" + "\n"
				+ "\u00A7e\u8BB0\u5F55\u7684\u5750\u6807\uFF1A" + "\n"
				+ (("\u00A7bx\u00A7f:" + new java.text.DecimalFormat("").format(Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("x1")))) + ""
						+ ("\u00A7by\u00A7f:" + new java.text.DecimalFormat("").format(Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("y1"))))
						+ ("\u00A7bz\u00A7f:" + new java.text.DecimalFormat("").format(Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("z1"))))),
				"");
	}
}