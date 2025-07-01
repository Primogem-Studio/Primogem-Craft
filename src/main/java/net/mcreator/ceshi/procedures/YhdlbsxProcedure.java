package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class YhdlbsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			FenliejinbisxhsProcedure.execute(world, x, y, z, entity,
					Math.random() < 0.5
							? new ItemStack(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:curio"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())
							: new ItemStack(
									BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:curio/negative"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()),
					itemstack, true, 3, 1, 12, 5);
		}
	}
}