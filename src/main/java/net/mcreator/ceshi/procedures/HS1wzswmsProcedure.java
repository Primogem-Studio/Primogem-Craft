package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class HS1wzswmsProcedure {
	public static String execute(ItemStack itemstack, double zhi) {
		double a = 0;
		a = Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("wzsw") / zhi);
		return Diaoyongshift0Procedure.execute(!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("shi_yong")
				? ("\u00A76\u4E00\u6BB5\u65F6\u95F4\u540E\uFF0C\u5C06\u5728\u4E16\u754C\u9644\u8FD1\u4F4D\u7F6E\u751F\u6210\u5947\u9047" + "\n"
						+ "\u00A76\u4F7F\u7528\u7269\u54C1\u53F3\u952E\u5947\u9047\u63D0\u4F9B\u7684\u5750\u6807\u65B9\u5757\uFF0C\u5373\u53EF" + "\n" + "\u00A76\u83B7\u5F97\u5956\u52B1")
						+ "\n"
						+ (a > 99
								? (("x:" + new java.text.DecimalFormat("").format(Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xa")))) + ""
										+ ("y:" + new java.text.DecimalFormat("").format(Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ya"))))
										+ ("z:" + new java.text.DecimalFormat("").format(Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("za"))))) + "\n" + "\u00A7a\u5947\u9047\u5DF2\u6D6E\u73B0"
								: ("\u00A77\u5F53\u524D\u8FDB\u5EA6\uFF1A" + ("\u00A7c" + new java.text.DecimalFormat("##.##").format(a) + "%/100%")) + "\n" + "\u00A7c\u5947\u9047\u672A\u6D6E\u73B0")
				: "\u00A7c\u5DF2\u635F\u574F\uFF01" + "\n" + "\u00A7c\u8BE5\u5947\u7269\u65E0\u6CD5\u4FEE\u590D", "");
	}
}