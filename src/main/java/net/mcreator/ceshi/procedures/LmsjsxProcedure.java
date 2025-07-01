package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class LmsjsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.9) {
			a = HSjinglianupProcedure.execute(entity, itemstack);
			XsfHSProcedure.execute(itemstack, true, false, 0.14 + 0.035 * a);
		} else {
			XsfHSProcedure.execute(itemstack, false, false, 0);
		}
	}
}