package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class ZfzrmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack,
				"\u00A76\u00A7n\u666E\u901A\u653B\u51FB" + "\n"
						+ ("\u00A7e\u6BCF\u6B21\u653B\u51FB\u76EE\u6807\u6709\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.2 + a * 0.05) + "\u00A7e\u6982\u7387\u83B7\u5F97\u4E00\u5C42\u88AB\u52A8\uFF0C\u81F3\u591A8\u5C42" + "\n"
								+ "\u00A7e\u5F53\u88AB\u52A8\u6548\u679C\u5DF2\u6EE1\u65F6\u653B\u51FB\u76EE\u6807\uFF0C\u5C06\u5237\u65B0\u4E00\u6B21\u4F24\u5BB3\u5438\u6536\u6548\u679C\uFF0C\u6CA1\u6709\u6548\u679C\u5219\u83B7\u5F97\u6548\u679C"
								+ "\n" + DiaoyongfangkuaiProcedure.execute(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zfzr_ceng_shu"), 8, "\u00A7a\u5F53\u524D\u5C42\u6570:"))
						+ "" + "\u00A76\u00A7n\u53F3\u952E\u6548\u679C" + "\n"
						+ ("\u00A7e\u6D88\u801720%\u5F53\u524D\u751F\u547D\u503C\uFF0C\u7ACB\u5373\u5237\u65B0\u4E00\u6B21\u4F24\u5BB3\u5438\u6536\u6548\u679C\uFF0C\u8D4B\u4E88\u00A7b" + new java.text.DecimalFormat("").format(a + 1)
								+ "\u7EA7\u00A7e\u6301\u7EED\u00A7b" + new java.text.DecimalFormat("").format(1 + a * 0.25) + "\u00A7e\u5206\u949F\u7684\u4F24\u5BB3\u5438\u6536\u6548\u679C\uFF0C\u51B7\u53748\u79D2")
						+ "\n" + "\u00A76\u00A7n\u6F5C\u884C+\u53F3\u952E" + "\n" + ("\u00A7e\u6D88\u8017\u5F53\u524D\u4F24\u5BB3\u5438\u6536\u6548\u679C\uFF0C\u5E76\u6062\u590D\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.4 + a * 0.1)
								+ "\u00A7e\u6700\u5927\u751F\u547D\u503C\uFF0C\u51B7\u5374" + new java.text.DecimalFormat("").format((2400 - a * 300) / 20) + "\u00A7e\u79D2"));
	}
}