package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class YsrzxgcsxProcedure {
	public static ItemStack execute() {
		ItemStack a = ItemStack.EMPTY;
		a = new ItemStack(PrimogemcraftModItems.YSRZ_0.get());
		{
			final String _tagName = "cao";
			final double _tagValue = 1;
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
		}
		a.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7a\u5143\u7D20\u7194\u73E0"));
		{
			final String _tagName = "qidong";
			final boolean _tagValue = true;
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putBoolean(_tagName, _tagValue));
		}
		{
			final String _tagName = "ms";
			final String _tagValue = ("\u00A7a\u8349\u5143\u7D20\u7194\u73E0" + "\n" + "\u00A76\u83B7\u5F97\u76F8\u5F53\u4E8E8\u70B9\u5957\u88C5\u503C\u4E14\u53D7\u706B\u6F06\u5F71\u54CD\u7684" + "\n"
					+ "\u00A76\u9971\u548C\u548C\u751F\u547D\u63D0\u5347\u6548\u679C");
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putString(_tagName, _tagValue));
		}
		return a;
	}
}