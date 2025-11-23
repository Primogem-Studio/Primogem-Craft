package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class EventitemR1Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		Entity e = null;
		boolean o = false;
		ItemStack i = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("LIji")) {
				e = entity;
				i = itemstack;
				{
					final String _tagName = "LIji";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				Event_item_sxRProcedure.execute(world, e, i);
				o = world.isClientSide();
			}
		}
	}
}