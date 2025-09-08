package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class WfjmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		return MSHSwuqi00Procedure.execute(entity, itemstack, MsnaijiuqywqProcedure.execute(entity, itemstack));
	}
}