package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class JczygmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A77\u62BD\u5361\u54EA\u6709\u6316\u77FF\u6709\u610F\u601D" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u6316\u6398\u65F6\uFF0C\u6709\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.3 + 0.075 * a)
						+ "\u00A7e\u6982\u7387\u6389\u843D\u539F\u77F3\u6216\u6469\u62C9" + "\n" + "\u00A7e\u51B7\u5374\u00A7b" + new java.text.DecimalFormat("##.##").format(1 - 0.125 * a) + "\u00A7e\u79D2");
	}
}