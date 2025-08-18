package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class WqzhgmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7n\u666E\u901A\u653B\u51FB" + "\n"
						+ ("\u00A7e\u6BCF\u6B21\u653B\u51FB\u76EE\u6807\u90FD\u5C06\u4FEE\u590D\u00A7b" + new java.text.DecimalFormat("##.##").format(0.5 * HSjinglianProcedure.execute(entity, itemstack)) + "\u00A7e\u70B9\u8010\u4E45\u5EA6") + "\n"
						+ "\u00A76\u00A7n\u53F3\u952E\u653B\u51FB" + "\n" + DaoqixiaoguomsProcedure.execute(entity, itemstack, "\uFF0C\u51B7\u53742\u79D2") + "\n" + "\u00A76\u00A7n\u6F5C\u884C+\u53F3\u952E" + "\n"
						+ ("\u00A7e\u6D88\u801720%\u6700\u5927\u751F\u547D\u503C\u83B7\u5F97\u00A7b" + new java.text.DecimalFormat("").format(1 + HSjinglianupProcedure.execute(entity, itemstack))
								+ "\u00A7e\u7EA7\u6301\u7EED0.25\u79D2\u9971\u548C\u6548\u679C"));
	}
}