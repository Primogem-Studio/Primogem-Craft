package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class DaimaHSProcedure {
	public static boolean execute(LevelAccessor world, Entity sourceentity, ItemStack item) {
		if (sourceentity == null)
			return false;
		boolean o1 = false;
		ItemStack i1 = ItemStack.EMPTY;
		i1 = item.copy();
		if (sourceentity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if ((!(sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.JQYYDM)) || i1.getItem() == PrimogemcraftModItems.QWJCDM.get()) && itemstackiterator.getItem() == i1.getItem()) {
					o1 = true;
				}
			}
		}
		return o1;
	}
}