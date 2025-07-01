package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

public class DiaoyongbukefumoProcedure {
	public static void execute(ItemStack itemstack) {
		ItemStack item1 = ItemStack.EMPTY;
		if (itemstack.isEnchanted()) {
			item1 = itemstack.copy();
			EnchantmentHelper.setEnchantments(item1, ItemEnchantments.EMPTY);
		}
	}
}