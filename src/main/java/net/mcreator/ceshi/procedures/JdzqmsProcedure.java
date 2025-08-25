package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class JdzqmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n"
						+ ("\u00A7e\u5F53\u76EE\u68075x5x5\u8303\u56F4\u5185\u4EC7\u6068\u4F60\u7684\u751F\u7269\u8D85\u8FC7\u4E00\u4E2A" + "\n" + "\u00A7e\u65F6\uFF0C\u653B\u51FB\u529B\u548C\u62A4\u7532\u503C\u63D0\u5347\u00A7b")
						+ new java.text.DecimalFormat("##.##%").format(0.16 + 0.04 * a) + "\n" + "\u00A7e\u4EC5\u4E3A\u4E00\u4E2A\u65F6\uFF0C\u653B\u51FB\u529B\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.28 + 0.07 * a) + "\n"
						+ "\u00A7e\u672A\u6709\u4EC7\u6068\u751F\u7269\u65F6\uFF0C\u6548\u679C\u5931\u6548" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8\u6548\u679C" + "\n" + "\u00A7e\u63D0\u5347\u00A7b"
						+ new java.text.DecimalFormat("##.##\u00A7e\u70B9\u62A4\u7532\u503C").format(4 + 1 * a));
	}
}