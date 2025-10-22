package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.hackermdch.pgc.CustomComponents;

public class FazxmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		String s1 = "";
		double a = 0;
		switch (itemstack.getOrDefault(CustomComponents.YSZUJIAN_JIAN, 0)) {
			case 1 -> s1 = MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB\u00A7a\u98CE" + "\n" + "\u00A7e\u653B\u51FB\u76EE\u6807\u4F7F\u76EE\u6807\u8D77\u98DE");
			case 2 -> s1 = MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB\u00A76\u5CA9" + "\n" + "\u00A7e\u653B\u51FB\u76EE\u6807\u4F7F\u76EE\u6807\u865A\u5F31");
			case 3 -> s1 = MSHSwuqi00Procedure.execute(entity, itemstack,
					"\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB\u00A7d\u96F7" + "\n" + "\u00A7e\u653B\u51FB\u76EE\u6807\u6982\u7387\u91CA\u653E\u96F7\u51FB" + "\n" + "\u00A7e\u6F5C\u884C\u53F3\u952E\u83B7\u5F97\u52FE\u7389\u6548\u679C");
			case 4 -> s1 = MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB\u00A7a\u8349" + "\n" + "\u00A7e\u653B\u51FB\u76EE\u6807\u4F7F\u76EE\u6807\u4E2D\u6BD2");
			case 5 -> s1 = MSHSwuqi00Procedure.execute(entity, itemstack,
					"\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB\u00A79\u6C34" + "\n" + "\u00A7e\u653B\u51FB\u76EE\u6807\u540E\u83B7\u5F97\u6CBB\u7597\uFF0C\u6548\u679C\u7ED3\u675F\u540E\u9020\u6210\u4F24\u5BB3");
			case 6 -> s1 = MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB\u00A7c\u706B" + "\n" + "\u00A7e\u653B\u51FB\u76EE\u6807\u4F7F\u76EE\u6807\u6301\u7EED\u7279\u6B8A\u71C3\u70E7");
			case 7 -> s1 = MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB\u00A7b\u51B0" + "\n" + "\u00A7e\u653B\u51FB\u76EE\u6807\u4F7F\u76EE\u6807\u7F13\u6162");
			default -> s1 = ZhexuemshsProcedure.execute(entity, itemstack, "\u00A7e\u6218\u6597");
		}
		return s1;
	}
}