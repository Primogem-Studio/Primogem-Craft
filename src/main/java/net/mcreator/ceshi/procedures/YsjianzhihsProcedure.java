package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.PrimogemcraftMod;

public class YsjianzhihsProcedure {
	public static double execute(Entity entity, ItemStack item, ItemStack itemstack, boolean zeng, double zhi) {
		if (entity == null)
			return 0;
		double a = 0;
		double jing = 0;
		jing = HSjinglianupProcedure.execute(entity, itemstack);
		a = hasEntityInInventory(entity, item) ? zhi * (zeng ? 2 : 0.5) : zhi;
		a = zeng ? a + jing * (a / 4) : a - jing * (a / 4);
		PrimogemcraftMod.LOGGER.info(a);
		return a;
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}