package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;

public class Shijian_it_sxProcedure {
	public static void execute(ItemStack itemstack) {
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("event_zu_i")) {
			{
				final String _tagName = "event_zu_i";
				final double _tagValue = (Mth.nextInt(RandomSource.create(), 1, (int) EventGroupProcedure.event_limit()));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}