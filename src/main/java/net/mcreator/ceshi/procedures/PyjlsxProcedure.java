package net.mcreator.ceshi.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class PyjlsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		a = 0.12 + 0.03 * HSjinglianupProcedure.execute(entity, itemstack);
		XsfHSProcedure.execute(itemstack, false, false, (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (ModList.get().isLoaded("genshincraft") ? a * 0.025 : a), "");
	}
}