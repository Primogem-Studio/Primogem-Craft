package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class QlzxmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		return ZhexuemshsProcedure.execute(entity, itemstack, "\u00A7e\u6316\u6398");
	}
}