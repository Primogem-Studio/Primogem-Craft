package net.mcreator.ceshi.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class HmzzmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		b = 0.12 + 0.06 * a;
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n" + "\u00A7e\u7ACB\u5373\u635F\u5931\u81EA\u8EAB\u5F53\u524D\u751F\u547D\u503C\u768430%\u6362\u53D6\u6301\u7EED18\u79D2\u6297\u6027\u63D0\u5347\u6548\u679C\uFF0C\u51B7\u537420\u79D2" + "\n"
						+ "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u83B7\u5F97\u57FA\u4E8E\u88C5\u5907\u8005\u6700\u5927\u751F\u547D\u503C\u00A7b"
						+ new java.text.DecimalFormat("##.##%").format(ModList.get().isLoaded("genshincraft") ? b * 0.025 : b) + "\u00A7e\u7684\u653B\u51FB\u529B\u52A0\u6210\uFF0C" + ""
						+ "\u00A7e\u751F\u547D\u503C\u4F4E\u4E8E50%\u65F6\uFF0C\u8F6C\u53D8\u4E3A\u57FA\u4E8E\u88C5\u5907\u8005\u6700\u5927\u751F\u547D\u503C\u00A7b"
						+ new java.text.DecimalFormat("##.##%").format(ModList.get().isLoaded("genshincraft") ? b * 2 * 0.025 : b * 2) + "\u00A7e\u7684\u653B\u51FB\u529B\u52A0\u6210" + "\n" + "\u00A76\u00A7l\u00A7n\u57FA\u7840\u88AB\u52A8" + "\n"
						+ "\u00A7e\u57FA\u7840\u751F\u547D\u503C\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.2 + 0.05 * a));
	}
}