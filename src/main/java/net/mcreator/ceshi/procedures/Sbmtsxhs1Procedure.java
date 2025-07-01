package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class Sbmtsxhs1Procedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.is(ItemTags.create(ResourceLocation.parse("c:curio"))) && (itemstack.is(ItemTags.create(ResourceLocation.parse("c:curio/normal/fusion/s"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:curio/normal/fusion/a")))
				|| itemstack.is(ItemTags.create(ResourceLocation.parse("c:curio/normal/fusion/b"))));
	}
}