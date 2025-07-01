package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

public class HS2wzswmsProcedure {
	public static String execute(ItemStack itemstack, double zhi, String wem_ben) {
		if (wem_ben == null)
			return "";
		return HS1wzswmsProcedure.execute(itemstack, zhi) + "" + HSctrlProcedure.execute(wem_ben, "\u878D\u5408\u63CF\u8FF0");
	}
}