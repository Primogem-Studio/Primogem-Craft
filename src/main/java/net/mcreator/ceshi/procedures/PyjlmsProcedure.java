package net.mcreator.ceshi.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class PyjlmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		b = 0.12 + 0.03 * HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n" + "\u00A7e\u5C06\u76EE\u6807\u76841%\u5F53\u524D\u8840\u91CF\u8F6C\u5316\u4E3A\u6CBB\u7597\u81EA\u8EAB\uFF0C\u51B7\u5374\u00A7b"
						+ new java.text.DecimalFormat("##.##\u00A7e\u79D2").format(8 - 1 * a) + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u57FA\u4E8E\u88C5\u5907\u8005\u751F\u547D\u503C\u4E0A\u9650\u7684\u00A7b"
						+ new java.text.DecimalFormat("##.##%").format(ModList.get().isLoaded("genshincraft") ? b * 0.025 : b) + "\u00A7e\u83B7\u5F97\u653B\u51FB\u529B\u52A0\u6210" + "\n" + "\u00A76\u00A7l\u00A7n\u57FA\u7840\u88AB\u52A8" + "\n"
						+ "\u00A7e\u57FA\u7840\u751F\u547D\u503C\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.1 + 0.025 * a) + "\n" + "\u00A7e\u6700\u7EC8\u653B\u51FB\u529B\u63D0\u5347\u00A7b"
						+ new java.text.DecimalFormat("##.##%").format(0.1 + 0.025 * a));
	}
}