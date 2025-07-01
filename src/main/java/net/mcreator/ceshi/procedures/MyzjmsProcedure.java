package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class MyzjmsProcedure {
	public static String execute(ItemStack itemstack) {
		return "\u00A77\u653E\u5165\u534E\u4E3D\u953B\u9020\u53F0\u4E5F\u8BB8\u80FD\u53D1\u751F\u4EC0\u4E48" + "\n"
				+ Diaoyongshift0Procedure.execute(
						("\u00A7e\u89E6\u53D1\u6982\u7387:\u00A7f" + new java.text.DecimalFormat("##.##%").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("qianghua_touzi_gailv"))) + "\n"
								+ ("\u00A7e\u51CF\u514D\u8303\u56F4:\u00A76" + "1%-" + new java.text.DecimalFormat("##.##%").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("touzi_fenwei_1"))),
						"\u52A0\u6210");
	}
}