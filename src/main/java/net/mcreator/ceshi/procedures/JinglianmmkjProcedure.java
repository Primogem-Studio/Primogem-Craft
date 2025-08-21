package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

public class JinglianmmkjProcedure {
	public static boolean execute(ItemStack itemstack, String ss) {
		if (ss == null)
			return false;
		return new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("jing_lian_mmkj"))).toLowerCase(java.util.Locale.ENGLISH))))
				.is(ItemTags.create(ResourceLocation.parse((("pgc:wuqi" + ss)).toLowerCase(java.util.Locale.ENGLISH))));
	}
}