package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Jlhy_ct_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n" + "\u00A7e\u6982\u7387\u83B7\u5F97\u575A\u7262\u9EC4\u7389" + "\n" + "\u00A7e\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}