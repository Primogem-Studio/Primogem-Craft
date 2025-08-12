package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class Ysrq_sx_0Procedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		double a = 0;
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String ss1 = "";
		if (!world.isClientSide()) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("qidong")) {
				a = Mth.nextInt(RandomSource.create(), 0, 5);
				ss1 = "\u00A76\u83B7\u5F97\u76F8\u5F53\u4E8E8\u70B9\u5957\u88C5\u503C\u4E14\u53D7\u706B\u6F06\u5F71\u54CD\u7684";
				switch ((int) a) {
					case 0 :
						s1 = "feng";
						s2 = "\u00A72\u5143\u7D20\u7194\u73E0";
						s3 = "\u00A72\u98CE\u5143\u7D20\u7194\u73E0" + "\n" + ss1 + "\n" + "\u00A76\u7F13\u964D\u548C\u8DF3\u8DC3\u63D0\u5347\u6548\u679C\uFF0C\u540C\u65F6\u4E5F\u53EF\u6C38\u4E45\u98DE\u884C" + "\n"
								+ "\u00A75\u836F\u6C34\u6548\u679C\u53EF\u901A\u8FC7\u6309\u952E\u914D\u7F6E\u5F00\u5173";
						break;
					case 1 :
						s1 = "yan";
						s2 = "\u00A76\u5143\u7D20\u7194\u73E0";
						s3 = "\u00A76\u5CA9\u5143\u7D20\u7194\u73E0" + "\n" + ss1 + "\n" + "\u00A76\u6297\u6027\u63D0\u5347\u548C\u4F24\u5BB3\u5438\u6536\u6548\u679C";
						break;
					case 2 :
						s1 = "lei";
						s2 = "\u00A7d\u5143\u7D20\u7194\u73E0";
						s3 = "\u00A7d\u96F7\u5143\u7D20\u7194\u73E0" + "\n" + ss1 + "\n" + "\u00A76\u96E8\u5929\u52A0\u6210\u548C\u96F7\u5143\u7D20\u5251\u52A0\u6210";
						break;
					case 3 :
						s1 = "cao";
						s2 = "\u00A7a\u5143\u7D20\u7194\u73E0";
						s3 = "\u00A7a\u8349\u5143\u7D20\u7194\u73E0" + "\n" + ss1 + "\n" + "\u00A76\u9971\u548C\u548C\u751F\u547D\u63D0\u5347\u6548\u679C";
						break;
					case 4 :
						s1 = "shui";
						s2 = "\u00A79\u5143\u7D20\u7194\u73E0";
						s3 = "\u00A79\u6C34\u5143\u7D20\u7194\u73E0" + "\n" + ss1 + "\n" + "\u00A76\u6F6E\u6D8C\u80FD\u91CF\u548C\u95F4\u6B47\u56DE\u590D\u751F\u547D\u503C\u6548\u679C";
						break;
					case 5 :
						s1 = "huo";
						s2 = "\u00A7c\u5143\u7D20\u7194\u73E0";
						s3 = "\u00A7c\u706B\u5143\u7D20\u7194\u73E0" + "\n" + ss1 + "\n" + "\u00A76\u6297\u706B\u548C\u53CD\u4F24\u6548\u679C";
						break;
				}
				Ysrz_hs_hs(s1, s2, s3, itemstack);
				{
					final String _tagName = "qidong";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			}
			NBTteshu("feng", "feng_teshu", itemstack);
		}
	}

	public static void Ysrz_hs_hs(String s1, String s2, String s3, ItemStack itemstack) {
		final double _tagValue = 1;
		CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(s1, _tagValue));
		itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(String.valueOf(s2)));
		final String ss1 = "ms";
		CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(ss1, s3));
	}

	public static void NBTteshu(String y1, String s1, ItemStack itemstack) {
		var n = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
		if (n.getBoolean(y1)) {
			{
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(s1, !n.getBoolean(s1)));
			}
		}
	}
}