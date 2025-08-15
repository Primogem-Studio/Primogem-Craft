package net.mcreator.ceshi.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HmzzsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		boolean o1 = false;
		a = 0.16 + 0.08 * HSjinglianupProcedure.execute(entity, itemstack);
		o1 = ModList.get().isLoaded("genshincraft");
		XsfHSProcedure.execute(itemstack, false, false, (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (o1 ? a * 0.025 : a), "humoa");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.5) {
			XsfHSProcedure.execute(itemstack, false, false, (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (o1 ? a * 2 * 0.025 : a * 2), "humob");
		} else {
			XsfHSProcedure.execute(itemstack, false, false, 0, "humob");
		}
	}
}