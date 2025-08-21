package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class TczdgmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u53F3\u952E\u6548\u679C" + "\n" + DaoqixiaoguomsProcedure.execute(entity, itemstack, "") + "\n"
				+ "\u00A7e\u6839\u636E\u6548\u679C\u51FB\u6740\u7684\u751F\u7269\u6570\u91CF\u83B7\u5F97\u53EF\u7A81\u7834\u4E0A\u9650\u7684\u989D\u5916\u9971\u548C\u5EA6\u81F3\u591A\u8D85\u51FA\u4E0A\u9650\u768420\u70B9\uFF0C\u81F3\u591A\u6301\u7EED\u00A7b"
				+ new java.text.DecimalFormat("##.##").format(8 + 2 * a)
				+ "\u00A7e\u79D2\uFF0C\u51B7\u537440\u79D2\uFF0C\u6301\u7EED\u65F6\u95F4\u7ED3\u675F\u540E\u6E05\u7A7A\u9971\u548C\u5EA6\u548C\u5C06\u9971\u98DF\u6D88\u8017\u81F3\u4E00\u534A\uFF0C\u672A\u51FB\u6740\u4EFB\u4F55\u751F\u7269\u65F6\u4EC5\u51B7\u53742\u79D2\uFF0C\u4F46\u4EC5\u53EF\u9020\u6210\u4F24\u5BB3\uFF0C\u65E0\u52A0\u6210"
				+ "\n" + "\u00A76\u00A7l\u00A7n\u6838\u5FC3\u88AB\u52A8" + "\n"
				+ "\u00A7e\u6839\u636E\u5F53\u524D\u9971\u548C\u5EA6\u63D0\u4F9B\u653B\u51FB\u529B\u52A0\u6210\uFF0C\u63D0\u4F9B\u7684\u653B\u51FB\u529B\u52A0\u6210\u76F8\u5F53\u4E8E\u5F53\u524D\u9971\u548C\u5EA6\u7684\u00A7b"
				+ new java.text.DecimalFormat("##.##%").format(0.28 + 0.07 * a) + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u9971\u548C\u5EA6\u63D0\u4F9B\u7684\u653B\u51FB\u529B\u52A0\u6210\u6548\u679C\u63D0\u5347\u00A7b"
				+ new java.text.DecimalFormat("##.##%").format(0.4 + 0.1 * a) + "\n"
				+ "\u00A7e\u5F53\u526F\u624B\u6301\u6709\u96FE\u5207\u4E4B\u56DE\u5149\u65F6\uFF0C\u4E0A\u8FF0\u975E\u653B\u51FB\u578B\u6548\u679C\u989D\u5916\u63D0\u5347\u76F8\u5F53\u4E8E\u96FE\u5207\u4E4B\u56DE\u5149\u7CBE\u70BC\u7B49\u7EA7\uFF0C\u6BCF\u7CBE\u70BC\u7B49\u7EA7\u63D0\u4F9B\u00A7b"
				+ new java.text.DecimalFormat("##.##%").format(0.06 + 0.015 * a) + "\n" + "\u00A7e\u6700\u7EC8\u653B\u51FB\u529B\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.08 + 0.02 * a) + "\n"
				+ "\u00A75\u00A7l\u00A7n\u8D1F\u9762\u88AB\u52A8" + "\n" + "\u00A7e\u5F53\u9971\u98DF\u5EA6\u4F4E\u4E8E18\u70B9\u65F6\uFF0C\u6700\u7EC8\u653B\u51FB\u529B\u51CF\u5C11\u00A7c"
				+ new java.text.DecimalFormat("##.##%").format(0.8 - 0.1 * a));
	}
}