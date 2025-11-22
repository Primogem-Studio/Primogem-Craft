package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Event_item_R0Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		Entity e = null;
		boolean o = false;
		ItemStack i = ItemStack.EMPTY;
		e = entity;
		i = itemstack;
		Event_item_sxRProcedure.execute(world, e, i);
		o = world.isClientSide();
	}
}