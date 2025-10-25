package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Jlhy_c_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u6F5C\u884C\u53F3\u952E" + "\n" + "\u00A7e\u9020\u6210\u7206\u70B8\uFF01" + "\n" + "\u00A7e\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}