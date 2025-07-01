package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

public class Xllysx0Procedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		double a = 0;
		double b = 0;
		boolean c = false;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fu_mo");
		if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) != 0 && a < 6) {
			if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) + a >= 6) {
				b = 6;
				c = true;
			} else {
				b = a + itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT));
				c = true;
			}
			if (c) {
				{
					final String _tagName = "fu_mo";
					final double _tagValue = b;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT))));
				XsfHSProcedure.execute(itemstack, true, false, itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fu_mo") * 0.08);
			}
		}
	}
}