package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class TrzrmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n" + "\u00A7e\u83B7\u5F97\u00A7b" + new java.text.DecimalFormat("##.##\u00A7e\u70B9\u653B\u51FB\u901F\u5EA6\u548C\u00A7b").format(1 + 0.5 * a)
						+ new java.text.DecimalFormat("##.##%\u00A7e\u901F\u5EA6\u52A0\u6210\uFF0C").format(0.1 + 0.1 * a) + "\u5E76\u4E14\u653B\u51FB\u671F\u95F4\u5BF9\u76EE\u6807\u989D\u5916\u9020\u6210\u00A7b"
						+ new java.text.DecimalFormat("##.##%").format(0.14 + 0.035 * a) + "\u00A7e\u653B\u51FB\u529B\u7684\u9B54\u6CD5\u4F24\u5BB3\uFF0C\u653B\u51FB12\u6B21\u540E\u6548\u679C\u7ED3\u675F" + "\n"
						+ DiaoyongfangkuaiProcedure.execute(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("tkzr_sx"), 12, "\u00A7a\u5F53\u524D\u5C42\u6570\uFF1A") + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n"
						+ "\u00A7e\u6700\u7EC8\u653B\u51FB\u529B\u52A0\u6210\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.08 + 0.02 * a));
	}
}