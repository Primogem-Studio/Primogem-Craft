package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class Luandaima_shuxingProcedure {
	public static void execute(ItemStack itemstack) {
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("daima_tiaojian")) {
			itemstack.setDamageValue(30);
			NaijiuxianzhiProcedure.execute(itemstack);
			{
				final String _tagName = "daima_tiaojian";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
	}
}