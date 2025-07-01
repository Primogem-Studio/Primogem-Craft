package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class HuoqiHSProcedure {
	public static double execute(LevelAccessor world, Entity entity, ItemStack item, boolean zeng, double zhi) {
		if (entity == null)
			return 0;
		boolean o1 = false;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == item.getItem()) {
					o1 = true;
				}
			}
		}
		return o1 ? (zeng ? zhi * 2 : zhi * 0.5) + 0 : zhi;
	}
}