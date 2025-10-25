package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Rymn_c_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u53F3\u952E\u65B9\u5757" + "\n" + "\u00A7e\u53EF\u4EE5\u7194\u70BC\u65B9\u5757\uFF0C\u83B7\u5F971~4\u500D\u4EA7\u51FA" + "\n" + "\u00A7e\u89E6\u53D1\u6982\u7387\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}