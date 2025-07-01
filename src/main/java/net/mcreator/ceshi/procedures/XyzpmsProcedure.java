package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class XyzpmsProcedure {
	public static String execute(ItemStack itemstack) {
		double n1 = 0;
		n1 = (24000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("k1")) / 20;
		return Diaoyongshift0Procedure.execute(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("dai_kai_jiang")
				? "" + (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("kai_jiang")
						? "\u00A7a\u5DF2\u5F00\u5956\uFF01\u00A77\u624B\u6301\u53F3\u952E\u63ED\u6653\uFF01"
						: "\u00A79\u8DDD\u79BB\u5F00\u5956\u8FD8\u5269\uFF1A" + "\n" + ("\u00A7e" + (n1 <= 60 ? new java.text.DecimalFormat("").format(n1) + "\u79D2" : new java.text.DecimalFormat("").format(Math.floor(n1 / 60)) + "\u5206\u949F"))
								+ "")
				: "\u00A76\u00A7l\u5F53\u4F60\u6709\u80FD\u529B\u505A\u51FA\u9009\u62E9\u65F6\uFF0C\u4E0D\u8981\u8BA9\u81EA\u5DF1\u540E\u6094" + "\n"
						+ "\u00A76\u9009\u62E9\u5DE6\u952E\uFF1A\u00A7e\u83B7\u5F9710\u661F\u743C\uFF0C\u65E0\u9700\u7B49\u5F85" + "\n" + "\u00A76\u9009\u62E9\u53F3\u952E\uFF1A\u00A7e\u7B49\u5F85\u6E38\u620F\u65F6\u95F41\u5929\u540E\u5F00\u5956"
						+ "\n" + "\u00A76\u00A7l \u6982\u7387\uFF1A" + "\n" + "\u00A7e \u7279\u7B49\u5956\uFF1A\u00A7c5000\u661F\u743C\u00A77" + new java.text.DecimalFormat("(##.#####%)").format(0.0001) + "\n"
						+ "\u00A7e \u4E00\u7B49\u5956\uFF1A\u00A7660\u661F\u743C\u00A77" + new java.text.DecimalFormat("(.%)").format(0.1) + "\n" + "\u00A7e \u4E8C\u7B49\u5956\uFF1A\u00A7b5\u661F\u743C\u00A77"
						+ new java.text.DecimalFormat("(.%)").format(0.9) + "\n" + "\u00A7c\u5F00\u5956\u7B49\u5F85\u7ED3\u675F\u540E\uFF0C\u518D\u6B21\u53F3\u952E\u5373\u53EF\u67E5\u770B\u5185\u5BB9",
				"\u72B6\u6001");
	}
}