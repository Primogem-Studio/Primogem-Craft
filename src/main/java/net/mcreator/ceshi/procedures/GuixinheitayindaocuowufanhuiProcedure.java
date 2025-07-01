package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class GuixinheitayindaocuowufanhuiProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.SUIJI_1SHIJIAN.get()));
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}