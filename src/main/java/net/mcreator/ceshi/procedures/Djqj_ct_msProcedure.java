package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Djqj_ct_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u8FD9\u662F\u4E00\u628A\u53EF\u4EE5\u9504\u5730\u7684\u5251" + "\n" + "\u00A7c\u4E0D\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}