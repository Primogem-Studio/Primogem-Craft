package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class MsnaijiuqywqProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double s = 0;
		s = HSjinglianupProcedure.execute(entity, itemstack);
		return "\u00A76\u00A7n\u666E\u901A\u653B\u51FB" + "\n" + ("\u00A7e\u6BCF\u6B21\u653B\u51FB\u76EE\u6807\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.5 + s * 0.125) + "\u00A7e\u4FEE\u590D1\u70B9\u8010\u4E45\u5EA6") + "\n"
				+ "\u00A76\u00A7n\u88AB\u52A8" + "\n"
				+ ("\u00A7e\u6BCF\u6B21\u6982\u7387\u6062\u590D\u8010\u4E45\u5237\u65B0\u4E00\u6B21\u653B\u901F\u51B7\u5374\u00A7b" + new java.text.DecimalFormat("").format((100 - 100 * s * 0.1) / 20) + "\u00A7e\u79D2");
	}
}