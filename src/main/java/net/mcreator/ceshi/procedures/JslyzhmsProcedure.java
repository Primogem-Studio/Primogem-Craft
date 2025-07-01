package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class JslyzhmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n"
				+ "\u00A7e\u83B7\u5F97\u518D\u751F\u6548\u679C\uFF0C\u5982\u82E5\u751F\u547D\u503C\u5DF2\u6EE1\uFF0C\u5219\u8F6C\u53D8\u4E3A\u5BF9\u9644\u8FD1\u4EC7\u6068\u4F60\u7684\u5B9E\u4F53\u6216\u73A9\u5BB6\u65BD\u52A0\u51CB\u96F6\u6548\u679C\uFF0C\u8D4B\u4E88\u00A7b"
				+ new java.text.DecimalFormat("##.##\u7EA7").format(1 + 1 * a) + "\u00A7e\u6301\u7EED10\u79D2\uFF0C\u51B7\u537420\u79D2" + "\n" + "\u00A76\u00A7l\u00A7n\u6F5C\u884C+\u5DE6\u952E" + "\n"
				+ "\u00A7e\u51CF\u5C1120%\u6700\u5927\u751F\u547D\u4E0A\u9650\uFF0C\u6362\u53D6\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.22 + 0.055 * a)
				+ "\u00A7e\u6700\u7EC8\u653B\u51FB\u529B\u52A0\u6210\uFF0C\u91CA\u653E\u540E\u91CD\u7F6E\u4E0B\u5217\u6548\u679C" + "\n" + "\u00A76\u00A7l\u00A7n\u6F5C\u884C+\u53F3\u952E" + "\n"
				+ "\u00A7e\u51CF\u5C1120%\u6700\u5927\u653B\u51FB\u529B\uFF0C\u6362\u53D6\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.22 + 0.055 * a)
				+ "\u00A7e\u6700\u7EC8\u6700\u5927\u751F\u547D\u503C\u52A0\u6210\uFF0C\u91CA\u653E\u540E\u91CD\u7F6E\u4E0A\u5217\u6548\u679C" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n"
				+ "\u00A7e\u6700\u5927\u751F\u547D\u503C\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.24 + 0.06 * a));
	}
}