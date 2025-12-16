package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class JczymsProcedure {
	public static String execute(ItemStack itemstack) {
		return "\u00A77\u957F\u6309\u53F3\u952E\u4F7F\u7528" + "\n"
				+ (itemstack.getItem() == PrimogemcraftModItems.JIJIUCHANZHIYUAN.get()
						? "\u00A7e\u00A7l\u6F5C\u884C\u4F7F\u7528\u5168\u90E8\uFF01" + "\n"
								+ Diaoyongshift0Procedure
										.execute(
												("\u00A78\u51FA\u7D2B\u6982\u7387:\u00A7d"
														+ new java.text.DecimalFormat("##.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 5 + 20) + "%")
														+ "\n"
														+ ("\u00A78\u51FA\u91D1\u6982\u7387:\u00A76"
																+ new java.text.DecimalFormat("##.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 10 + 3) + "%"),
												"\u6982\u7387")
						: Diaoyongshift0Procedure
								.execute(
										("\u00A78\u5355\u4E2A\u51FA\u7D2B\u6982\u7387:\u00A7d"
												+ new java.text.DecimalFormat("##.##").format((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 5) / 10 + 20) + "%")
												+ "\n"
												+ ("\u00A78\u5355\u4E2A\u51FA\u91D1\u6982\u7387:\u00A76"
														+ new java.text.DecimalFormat("##.##").format((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 10) / 10 + 3) + "%"),
										"\u6982\u7387"));
	}
}