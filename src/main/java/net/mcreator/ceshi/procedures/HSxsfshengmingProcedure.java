package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;

import net.hackermdch.pgc.CustomAPI;

public class HSxsfshengmingProcedure {
	public static void execute(ItemStack itemstack, boolean bai_fen, boolean zui_da, double zhi) {
		ItemStack stack = ItemStack.EMPTY;
		double a = 0;
		stack = itemstack.copy();
		a = zhi;
		var attr = CustomAPI.getAttributes(stack);
		if (zui_da) {
			attr.add(Attributes.MAX_HEALTH, "s1", a, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND);
		} else if (bai_fen) {
			attr.add(Attributes.MAX_HEALTH, "s1", a, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
		} else {
			attr.add(Attributes.MAX_HEALTH, "s1", a, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
		}
		attr.apply();
	}
}
