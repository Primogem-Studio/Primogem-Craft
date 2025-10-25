package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Axby_f_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n" + "\u00A7e\u6D88\u8017\u96F7\u5143\u7D20\u788E\u5C51\u9020\u6210\u4F24\u5BB3" + "\n" + "\u00A76\u4EC5\u53D7\u706B\u6F06\u5F71\u54CD");
	}
}