package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Rymn_f_msProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n"
				+ "\u00A7e \u83B7\u5F97\u4E00\u4E2A\u77ED\u6682\u6062\u590D\u6548\u679C\uFF0C\u6548\u679C\u671F\u95F4\uFF0C\u6BCF\u53D7\u5230\u71C3\u70E7\u548C\u7194\u5CA9\u4F24\u5BB3\u6062\u590D\u751F\u547D\u503C\uFF0C\u5904\u4E8E\u9632\u706B\u72B6\u6001\u65F6\uFF0C\u7ACB\u523B\u63D0\u4F9B\u751F\u547D\u6062\u590D"
				+ "\n" + "\u00A7e\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD");
	}
}