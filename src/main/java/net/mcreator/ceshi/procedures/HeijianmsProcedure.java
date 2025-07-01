package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class HeijianmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n" + "\u00A7e\u5927\u6982\u7387\u6062\u590D\u81EA\u8EAB\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.3 + 0.075 * a)
				+ "\u00A7e\u751F\u547D\u503C\uFF0C\u51B7\u537420\u79D2" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u6700\u5927\u653B\u51FB\u529B\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.2 + 0.05 * a));
	}
}