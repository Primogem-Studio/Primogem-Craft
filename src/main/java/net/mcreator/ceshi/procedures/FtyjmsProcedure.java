package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class FtyjmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double b = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n" + "\u00A7e\u7ACB\u5373\u83B7\u5F97\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.12 + 0.03 * a)
				+ ("\u00A7e\u653B\u51FB\u529B\u548C\u00A7b" + new java.text.DecimalFormat("##.##%\u00A7e\u79FB\u52A8\u901F\u5EA6\u52A0\u6210").format((0.12 + 0.03 * a) * 10) + "\n"
						+ "\u00A7e\u51B7\u537420\u79D2\uFF0C\u547D\u4E2D10\u6B21\u540E\u6548\u679C\u89E3\u9664")
				+ "\n" + DiaoyongfangkuaiProcedure.execute(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ftyj_sx"), 10, "\u00A7a\u5F53\u524D\u5C42\u6570\uFF1A")
				+ "\u00A76\u00A7l\u00A7n\u6F5C\u884C+\u53F3\u952E" + "\n" + "\u00A7e\u83B7\u5F97\u00A7b" + new java.text.DecimalFormat("").format(3 + 1 * a) + "\u79D2\u00A7e\u4E0D\u7A33\u5B9A\u7684\u98DE\u884C\u6548\u679C\uFF0C\u51B7\u537430\u79D2");
	}
}