package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Zzss_g_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n" + "\u00A7e\u4F7F\u81EA\u8EAB\u98DE\u5411\u9AD8\u7A7A" + "\n" + "\u00A7e\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}