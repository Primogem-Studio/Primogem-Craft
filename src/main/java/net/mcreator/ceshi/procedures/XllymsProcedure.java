package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class XllymsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n" + "\u00A7e\u5BF9\u7740\u706B\u72B6\u6001\u7684\u654C\u4EBA\u989D\u5916\u9020\u6210\u4E00\u6B21\u5F53\u524D\u653B\u51FB\u529B\u00A7b"
				+ new java.text.DecimalFormat("##.##%").format(0.18 + 0.045 * a) + "\u00A7e\u7684\u771F\u5B9E\u4F24\u5BB3\uFF0C\u8BE5\u6548\u679C\u6BCF\u79D2\u81F3\u591A\u89E6\u53D1\u4E00\u6B21" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n"
				+ "\u00A7e\u653B\u51FB\u76EE\u6807\u6709\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.3 + 0.1 * a + 0.05 * itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fu_mo"))
				+ "\u00A7e\u6982\u7387\u4F7F\u76EE\u6807\u7740\u706B\u00A7b" + new java.text.DecimalFormat("#.#\u79D2\u00A7e").format(8 + 2 * a) + "\n" + "\u00A76\u00A7l\u00A7n\u7279\u6B8A\u88AB\u52A8" + "\n"
				+ "\u00A7e\u5F53\u6B66\u5668\u62E5\u6709\u706B\u7130\u9644\u52A0\u9644\u9B54\u65F6\uFF0C\u5C06\u6BCF\u7EA7\u8F6C\u5316\u4E3A\u00A7c5%\u00A7e\u989D\u5916\u7740\u706B\u6982\u7387\u548C\u00A7c8%\u00A7e\u989D\u5916\u653B\u51FB\u529B\uFF0C\u81F3\u591A6\u5C42"
				+ "\n" + DiaoyongfangkuaiProcedure.execute(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fu_mo"), 6, "\u00A7c\u00A7l\u5F53\u524D\u5C42\u6570\uFF1A"));
	}
}