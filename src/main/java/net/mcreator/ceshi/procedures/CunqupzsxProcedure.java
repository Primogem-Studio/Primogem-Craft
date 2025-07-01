package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class CunqupzsxProcedure {
	public static String execute(ItemStack itemstack) {
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("pgc_cunchu")
				? (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("bwd_yinhang")
						? "\u00A79\u4E0D\u7A33\u5B9A \u00A78\u9884\u8BA1\u53D6\u51FA\u81F3\u591A<\u00A7d240%\u00A78>\u6570\u91CF\u00A77<"
						: "\u00A7d\u771F\u5B9E\u6709\u6548 \u00A78\u9884\u8BA1\u53D6\u51FA\u00A77<") + ""
						+ new java.text.DecimalFormat("##.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("pgc_cunchu")) + ">\u00A78\u5B87\u5B99\u788E\u7247"
				: "\u00A7c\u6682\u4E14\u65E0\u6548 \u00A74\u7A7A\u7684\u5B58\u50A8\u51ED\u8BC1\uFF01";
	}
}