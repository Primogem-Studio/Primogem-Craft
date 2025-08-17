package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class XfcqmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n" + "\u00A7e\u5C06\u6709\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.6 + 0.1 * a) + "\u00A7e\u6982\u7387\u6062\u590D\u00A7b"
						+ new java.text.DecimalFormat("##.##").format(6 + 1 * a) + "\u00A7e\u70B9\u9971\u98DF\u5EA6\uFF0C\u00A7b" + new java.text.DecimalFormat("##.##").format(3 + 1 * a) + "\u00A7e\u70B9\u9971\u548C\u5EA6\u548C\u00A7b"
						+ new java.text.DecimalFormat("##.##").format(6 + 1 * a) + "\u00A7e\u70B9\u751F\u547D\u503C" + "\n" + "\u00A7e\u89E6\u53D1\u540E\u51B7\u5374\u00A7d\u00A7b" + new java.text.DecimalFormat("##.##").format(12 - 1.5 * a)
						+ "\u00A7e\u79D2" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u751F\u547D\u503C\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.1 + 0.025 * a));
	}
}