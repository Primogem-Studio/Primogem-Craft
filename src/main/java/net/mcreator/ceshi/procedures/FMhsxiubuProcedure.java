package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class FMhsxiubuProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack item) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			a = item.copy();
			if (a.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:fmyuzhousuipian")))) != 0
					&& !a.is(ItemTags.create(ResourceLocation.parse("pgc:token_mending")))) {
				if (a.getDamageValue() > a.getMaxDamage() * 0.01
						* a.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:fmyuzhousuipian")))) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a.setDamageValue((int) (a.getDamageValue() - a.getMaxDamage() * 0.01
							* a.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:fmyuzhousuipian")))) * 2));
				}
			}
		}
	}
}