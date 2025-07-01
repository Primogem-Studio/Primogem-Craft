package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class Jingyanshushuxing0Procedure {
	public static boolean execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return false;
		return !itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean((entity.getDisplayName().getString()));
	}
}