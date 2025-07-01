package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class QwxyddmsProcedure {
	public static String execute(ItemStack itemstack) {
		return Diaoyongshift0Procedure.execute("\u00A77\u5DE6\u952E\u540E\u6D88\u8017\u4E00\u5C42\u70B9\u6570\uFF0C\u4F7F\u526F\u624B\u00A7c0\u7EA7" + "\n" + "\u00A77\u4EE5\u4E0B\u7948\u613F\u6B66\u5668\u6062\u590D\u5230\u521D\u59CB\u7B49\u7EA7"
				+ "\n" + "\u00A77\u6BCF\u6B21\u4FEE\u590D\u7948\u613F\u6B66\u5668\u65F630%\u635F\u574F" + "\n" + "\u00A7c\u4E0D\u6E05\u9664\u6548\u679C\u4F46\u56DE\u590D\u4EC5\u6709\u6C34\u4E0A\u4E66\u768450%" + "\n" + "\n"
				+ "\u00A7b\u5F53\u524D\u53EF\u7528\u70B9\u6570:\u00A7f" + new java.text.DecimalFormat("").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zhi")) + "\n"
				+ "\u00A77\u51B7\u537420\u5206\u949F", "");
	}
}