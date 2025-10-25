package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Axby_g_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n"
				+ "\u00A7e\u6316\u6398\u5143\u7D20\u6676\u4F53\u5757\u6982\u7387\u8F6C\u5316\u4E3A\u901A\u7528\u7248\u672C\u00A7c10%\u56FA\u5B9A\u6982\u7387\u76F4\u63A5\u6467\u6BC1" + "\n" + "\u00A7e\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}