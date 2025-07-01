package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class SkjinbisxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		double n1 = 0;
		if (!world.isClientSide()) {
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (itemstackiterator.getItem() == PrimogemcraftModItems.ZHAIQUAN.get()) {
						n1 = n1 + itemstackiterator.getCount();
					}
				}
			}
			if (Math.random() < n1 * 0.01) {
				a = new ItemStack(PrimogemcraftModItems.ZHAIQUAN.get());
			} else {
				a = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
				a.setCount((int) Mth.nextDouble(RandomSource.create(), 1, 10));
			}
			FenliejinbisxhsProcedure.execute(world, x, y, z, entity, a, itemstack, true, 3, 1, 12, 10);
		}
	}
}