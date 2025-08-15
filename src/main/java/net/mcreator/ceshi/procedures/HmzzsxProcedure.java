package net.mcreator.ceshi.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HmzzsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean o1 = false;
		double a = 0;
		double a1 = 0;
		a = 0.12 + 0.06 * HSjinglianupProcedure.execute(entity, itemstack);
		o1 = ModList.get().isLoaded("genshincraft");
		a1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.5 ? 2 : 1;
		XsfHSProcedure.execute(itemstack, false, false, (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (o1 ? (a - a1) * 0.025 : a - a1), "humoa");
	}
}