package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Mlf_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u57FA\u7840\u653B\u51FB\u529B\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("").format(2 + 0.5 * a) + "\u00A7e\u70B9" + "\n"
				+ "\u00A7e\u65B9\u5757\u6316\u6398\u901F\u5EA6\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("").format(1 + 0.25 * a) + "\u00A7e\u70B9");
	}
}