package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QyhxsxProcedure {
	public static String execute(ItemStack itemstack) {
		itemstack.setDamageValue((int) (itemstack.getMaxDamage() - (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("qyhx_cishu") + 1)));
		return Diaoyongshift0Procedure.execute(itemstack.getItem() == PrimogemcraftModItems.QYHX.get()
				? "\u00A77\u5F53\u524D\u7948\u613F\u503C:\u00A7b" + new java.text.DecimalFormat("").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen")) + "\n"
						+ "\u00A78\u51FA\u7D2B\u6982\u7387\u589E\u52A0:\u00A7d" + new java.text.DecimalFormat(".0").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 5) + "%"
						+ "\n" + "\u00A78\u51FA\u91D1\u6982\u7387\u589E\u52A0:\u00A76" + new java.text.DecimalFormat(".0").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 10)
						+ "%"
				: "\u00A77\u5F53\u524D\u7948\u613F\u503C:\u00A7b" + new java.text.DecimalFormat("").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen")) + "\n"
						+ "\u00A78\u51FA\u7D2B\u6982\u7387\u589E\u52A0:\u00A7d" + new java.text.DecimalFormat(".0").format((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 5) / 10)
						+ "%" + "\n" + "\u00A78\u51FA\u91D1\u6982\u7387\u589E\u52A0:\u00A76"
						+ new java.text.DecimalFormat(".0").format((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 10) / 10) + "%",
				"\u8BE6\u60C5") + ""
				+ HSctrlProcedure.execute("\u00A75\u624B\u6301 \u5DE6\u952E\u67E5\u770B\u526F\u624B\u7269\u54C1\u7948\u613F\u503C" + "\n" + "\u00A76\u53F3\u952E \u51CF\u5C11\u00A7b1\u00A76\u526F\u624B\u7269\u54C1\u6362\u53D6\u7948\u613F\u503C" + "\n"
						+ "\u00A76\u6F5C\u884C+\u53F3\u952E \u63D0\u4EA4\u81F3\u6700\u5927\u503C" + "\n", "\u6559\u7A0B");
	}
}