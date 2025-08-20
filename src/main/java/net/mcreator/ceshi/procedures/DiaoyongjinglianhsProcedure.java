package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

public class DiaoyongjinglianhsProcedure {
	public static void execute(ItemStack itemstack, boolean zhen, double zhi) {
		ItemStack i = ItemStack.EMPTY;
		double n = 0;
		boolean o = false;
		i = itemstack;
		n = zhi;
		o = zhen;
		GUIhldztjlhsProcedure.JLnbt(i, (int) n, o);
	}
}