package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.ceshi.PrimogemcraftMod;

public class SbmjbsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (FenliejinbisxhsProcedure.execute(world, x, y, z, entity,
					new ItemStack(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:curio/negative"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()),
					itemstack, true, 3, 1, 12, 3)) {
				if (Math.random() < 0.35) {
					PrimogemcraftMod.queueServerWork(1, () -> {
						HSsbmtsxProcedure.execute(world, x, y, z, entity, itemstack, ItemStack.EMPTY, ItemStack.EMPTY, false, true, false, true, 0, 0, 0, "loot spawn ~ ~ ~ loot primogemcraft:entities/qqiwuzhanlipinshiti");
					});
				}
			}
		}
	}
}