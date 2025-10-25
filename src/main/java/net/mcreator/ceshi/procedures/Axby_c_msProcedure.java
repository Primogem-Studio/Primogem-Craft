package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Axby_c_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u53F3\u952E\u65B9\u5757" + "\n" + "\u00A7e\u5C06\u51B0\u8F6C\u5316\u4E3A\u84DD\u51B0" + "\n" + "\u00A7c\u4E0D\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}