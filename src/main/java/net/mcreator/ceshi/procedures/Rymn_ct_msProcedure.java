package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Rymn_ct_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u53EF\u4EE5\u8015\u4F5C\u4E0B\u754C\u5CA9" + "\n" + "\u00A7c\u4E0D\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}