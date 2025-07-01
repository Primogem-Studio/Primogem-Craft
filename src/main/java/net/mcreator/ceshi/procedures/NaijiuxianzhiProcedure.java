package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class NaijiuxianzhiProcedure {
	public static void execute(ItemStack itemstack) {
		{
			final String _tagName = "naijiu_xianzhi";
			final double _tagValue = (itemstack.getMaxDamage() - itemstack.getDamageValue());
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
	}
}