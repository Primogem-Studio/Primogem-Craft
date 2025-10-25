package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Szbf_f_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n" + "\u00A7e\u751F\u6210\u4E00\u68F5\u6811\uFF0C\u5E76\u5C06\u81EA\u8EAB\u4F4D\u7F6E\u8FC1\u79FB" + "\n" + "\u00A7c\u4E0D\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}