package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.item.ItemStack;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import net.hackermdch.pgc.CustomComponents;

public class QyhxsxProcedure {
	public static String execute(ItemStack itemstack) {
		double s = 0;
		int a = itemstack.getOrDefault(CustomComponents.WISH_VALE, 0);
		return Diaoyongshift0Procedure
				.execute("\u00A77\u5F53\u524D\u7948\u613F\u503C:\u00A7b" + new java.text.DecimalFormat("").format(a)
						+ (a == 0
								? ""
								: "\n" + (itemstack.getItem() == PrimogemcraftModItems.QYHX.get()
										? "\u00A78\u51FA\u7D2B\u6982\u7387\u589E\u52A0:\u00A7d" + new java.text.DecimalFormat(".0").format(a / 5) + "%" + "\n" + "\u00A78\u51FA\u91D1\u6982\u7387\u589E\u52A0:\u00A76"
												+ new java.text.DecimalFormat(".0").format(a / 10) + "%"
										: "\u00A78\u5355\u53D1\u51FA\u7D2B\u6982\u7387\u589E\u52A0:\u00A7d" + new java.text.DecimalFormat(".0").format((a / 5) / 10) + "%" + "\n" + "\u00A78\u5355\u53D1\u51FA\u91D1\u6982\u7387\u589E\u52A0:\u00A76"
												+ new java.text.DecimalFormat(".0").format((a / 10) / 10) + "%")),
						"\u8BE6\u60C5")
				+ "" + HSctrlProcedure.execute("\u00A75\u5DE6\u952E \u00A76\u67E5\u770B\u526F\u624B\u7269\u54C1\u7948\u613F\u503C" + "\n" + "\u00A75\u53F3\u952E \u00A76\u51CF\u5C11\u00A7b1\u00A76\u526F\u624B\u7269\u54C1\u6362\u53D6\u7948\u613F\u503C"
						+ "\n" + "\u00A75\u6F5C\u884C\u53F3\u952E \u00A76\u63D0\u4EA4\u81F3\u6700\u5927\u503C" + "\n", "\u6559\u7A0B");
	}
}