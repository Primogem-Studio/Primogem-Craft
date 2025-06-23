package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class TagItemProcedure {
	public static ItemStack execute(String _tag) {
		if (_tag == null)
			return ItemStack.EMPTY;
		return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse((_tag).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create())
				.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
	}
}
