package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class DiaoyongwuqijinglianHSProcedure {
	public static void execute(ItemStack item, double xian_zhi, double zhi) {
		ItemStack a = ItemStack.EMPTY;
		a = item.copy();
		{
			final String _tagName = "jing_lian";
			final double _tagValue = (a.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") + zhi);
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
		}
		{
			final String _tagName = "jing_lian_shua_xin";
			final boolean _tagValue = false;
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putBoolean(_tagName, _tagValue));
		}
		if (a.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") >= xian_zhi) {
			{
				final String _tagName = "jing_lian";
				final double _tagValue = xian_zhi;
				CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}