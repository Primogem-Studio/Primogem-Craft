package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class YsrzmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		String s1 = "";
		String s2 = "";
		String s3 = "";
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("qidong")) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("feng")) {
				if (entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
					s1 = "\u00A7c\u7981\u7528";
				} else {
					s1 = "\u00A7a\u542F\u7528";
				}
				s2 = "\u00A75\u98CE\u5143\u7D20\u62A4\u7532\u7981\u7528\u540E\u4FDD\u7559\u8DF3\u8DC3\u63D0\u5347\u6548\u679C" + "\n" + "\u00A77\u836F\u6C34\u72B6\u6001\uFF1A" + s1;
			} else {
				s2 = "";
			}
			s3 = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("ms") + "\n" + s2 + "\n" + Diaoyongshift0Procedure.execute(
					"\u00A76\u5143\u7D20\u7194\u73E0\u6548\u679C\u4E0E\u5143\u7D20\u62A4\u7532\u6548\u679C\u7C7B\u4F3C\uFF0C\u4F46\u90E8\u5206\u76D4\u7532\u4E0E\u7194\u73E0\u62E5\u6709\u533A\u522B\u3002\u5927\u90E8\u5206\u6548\u679C\u4E0D\u53EF\u53E0\u52A0\u3002\u67E5\u770B\u8BE6\u7EC6\u63CF\u8FF0\u8BF7\u67E5\u770B\u201C\u5143\u7D20\u76D4\u7532\u201D\u63CF\u8FF0",
					"\u5176\u4ED6\u4FE1\u606F");
		} else {
			s3 = "\u00A77\u53F3\u952E\u540E\u8F6C\u53D8\u5F62\u6001" + "\n" + "\u00A76\u4F7F\u5176\u80FD\u591F\u63D0\u4F9B\u968F\u673A\u5143\u7D20\u5957\u88C5\u6548\u679C" + "\n"
					+ "\u00A76\u5B58\u5728\u7269\u54C1\u680F\u65F6\u5C06\u4E3A\u73A9\u5BB6\u63D0\u4F9B\u589E\u76CA" + "\n" + "\u00A78\u63D0\u4F9B8\u70B9\u5957\u88C5\u503C\u589E\u76CA \u53D7\u706B\u6F06\u5F71\u54CD";
		}
		return s3;
	}
}