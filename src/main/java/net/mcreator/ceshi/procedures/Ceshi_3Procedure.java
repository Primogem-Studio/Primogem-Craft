package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.ceshi.init.PrimogemcraftModAttributes;

import net.hackermdch.pgc.CustomAPI;

public class Ceshi_3Procedure {
	public static void execute(ItemStack itemstack) {
		double ceshi_01 = 0;
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		stack = itemstack;
		var attr = CustomAPI.getAttributes(stack);
		attr.add(PrimogemcraftModAttributes.EWAI_SHANGHAI_WL, "ss1", 20, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.ANY);
		String PIid = BuiltInRegistries.ITEM.getKey(stack.getItem()).toString();
		net.hackermdch.pgc.CustomUtils.enableForInventory(PIid);
		attr.apply();
	}
}