package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Cyst_sxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack i = ItemStack.EMPTY;
		a = entity.getPersistentData().getDouble("qysx_a");
		if (hasEntityInInventory(entity, YsrzxgcsxProcedure.execute())) {
			a = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQCAO.get())) ? 10 : 8;
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}