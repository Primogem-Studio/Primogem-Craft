package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class ShenmilihewenbenProcedure {
	public static String execute(ItemStack itemstack) {
		return Diaoyongshift0Procedure.execute("\u00A7b\u53F3\u952E\u00A77\u6216"
				+ (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lihe_jishi_0") == 0
						? "1:00"
						: "" + (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lihe_jishi_0") > 50 ? "0:0" : "0:"))
				+ (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lihe_jishi_0") == 0
						? ""
						: new java.text.DecimalFormat("##.##").format(60 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lihe_jishi_0")))
				+ "\u540E\u81EA\u52A8\u00A7e\u6253\u5F00", "\u8BE6\u60C5");
	}
}