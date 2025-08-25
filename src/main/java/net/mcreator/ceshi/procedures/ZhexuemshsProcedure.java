package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class ZhexuemshsProcedure {
	public static String execute(Entity entity, ItemStack itemstack, String zhi) {
		if (entity == null || zhi == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + zhi + "\u00A7e\u65F6\uFF0C\u6709\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.06 + 0.015 * a)
				+ "\u00A7e\u6982\u7387\u6389\u843D\u00A7b1~" + new java.text.DecimalFormat("").format(1 + 1 * a) + "\u00A7e\u6982\u7387\u6389\u843D\u6469\u62C9\uFF0C\u51B7\u53740.1\u79D2");
	}
}