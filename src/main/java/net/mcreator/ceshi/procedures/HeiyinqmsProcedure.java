package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class HeiyinqmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n" + "\u00A7e\u5BF9\u4EA1\u7075\u751F\u7269\u65BD\u52A0\u7981\u9522\uFF0C\u6301\u7EED\u00A7b" + new java.text.DecimalFormat("##.##\u79D2").format(2 + 0.5 * a)
						+ "\u00A7e\u51B7\u53744\u79D2" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u653B\u51FB\u4EA1\u7075\u751F\u7269\u540E\uFF0C\u83B7\u5F97\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.4 + 0.1 * a)
						+ "\u00A7e\u653B\u51FB\u529B\u52A0\u6210" + "\n" + "\u00A7e\u653B\u51FB\u975E\u4EA1\u7075\u751F\u7269\u65F6\uFF0C\u52A0\u6210\u5931\u6548\u5E76-1\u5F53\u524D\u653B\u51FB\u529B");
	}
}