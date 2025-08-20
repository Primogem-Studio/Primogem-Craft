package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class TcllkmsProcedure {
	public static String execute(ItemStack itemstack) {
		double a = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
		return "\u00A77\u56DE\u6536\u5F3A\u5316\u6B66\u5668\u4E3A\u5F3A\u5316\u6750\u6599" + "\n" + "\u00A76\u8FD4\u8FD8\u00A7b"
				+ new java.text.DecimalFormat("").format(DiaoyongNBTshuziProcedure.execute(itemstack, "jing_lian_zhen") + (DiaoyongNBTluojiProcedure.execute(itemstack, "jing_lian_zhen") && JinglianmmkjProcedure.execute(itemstack) ? 1 : 0))
				+ "\u4E2A\u00A76\u53E0\u5F71\u5668" + "\n" + "\u00A76\u8FD4\u8FD8\u00A7b"
				+ new java.text.DecimalFormat("").format((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian_jia") + (DiaoyongNBTluojiProcedure.execute(itemstack, "jing_lian_jia") ? 1 : 0)) * 4)
				+ "\u4E2A\u00A76\u661F\u8F89" + "\n" + "\u00A76\u8FD4\u8FD8\u00A7b" + new java.text.DecimalFormat("").format(a <= 0 ? 0 : a + 1) + "\u7EA7\u00A76\u5F3A\u5316\u6750\u6599"
				+ (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("fu_mo")
						? "\n" + "\u00A7c\u8FD4\u8FD8\u00A7e"
								+ new java.text.DecimalFormat("##.##\u672C\u00A7c\u706B\u7130\u9644\u52A0 II").format(Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fu_mo") / 2))
						: "")
				+ (itemstack.getItem() == PrimogemcraftModItems.TCLLK.get() ? "\n" + "\u00A7a\u8FD4\u8FD8\u00A7e1\u4E2A\u00A7d\u6D41\u5149\u4F59\u6656" : "");
	}
}