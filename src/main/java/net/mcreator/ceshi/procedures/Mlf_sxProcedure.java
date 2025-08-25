package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Mlf_sxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		MlgjsxProcedure.execute(entity, itemstack);
		MlwqProcedure.execute(entity, itemstack);
	}
}