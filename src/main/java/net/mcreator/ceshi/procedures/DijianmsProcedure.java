package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class DijianmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n"
						+ "\u00A7e\u83B7\u5F97\u4E00\u5C42\u97F3\u7B26\uFF0C\u5F53\u97F3\u7B26\u4E3A5\u65F6\uFF0C\u4E0B\u6B21\u653B\u51FB\u5BF9\u9644\u8FD15\u4E2A\u751F\u7269\u9020\u6210\u5F53\u524D\u653B\u51FB\u529B\u00A7b"
						+ new java.text.DecimalFormat("##.##%").format(1 + a * 0.25) + "\u00A7e\u7684\u9B54\u6CD5\u4F24\u5BB3\u540E\u6E05\u96F6\uFF0C\u6BCF2.0\u79D2\u81F3\u591A\u83B7\u5F971\u5C42\u97F3\u7B26" + "\n"
						+ DiaoyongfangkuaiProcedure.execute(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("yin_fu"), 5, "\u00A7a\u5F53\u524D\u5C42\u6570:") + "\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n"
						+ "\u00A7e\u6D88\u8017\u5F53\u524D\u6240\u6709\u97F3\u7B26\uFF0C\u6BCF\u5C42\u6062\u590D\u00A7b" + new java.text.DecimalFormat("##.##%").format((1 + a * 0.25) * 0.05) + "\u00A7e\u5DF2\u635F\u5931\u7684\u751F\u547D\u503C");
	}
}