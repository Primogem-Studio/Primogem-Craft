package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Szbf_c_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u6F5C\u884C\u53F3\u952E" + "\n" + "\u00A7e\u53D8\u6CE5\u571F\u72B6\u6001" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n"
				+ "\u00A7e\u7834\u574F\u6CE5\u571F\u65F6\u6709\u6982\u7387\u4EA7\u51FA\u6218\u5229\u54C1" + "\n" + "\u00A7c\u4E0D\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}