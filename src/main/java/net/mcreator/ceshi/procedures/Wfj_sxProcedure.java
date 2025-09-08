package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;

import net.hackermdch.pgc.CustomAPI;

public class Wfj_sxProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		double a = 0;
		double aa = 0;
		if (!world.isClientSide()) {
			a = HSjinglianupProcedure.execute(sourceentity, itemstack);
			stack = itemstack;
			var attr = CustomAPI.getAttributes(stack);
			if (Math.random() < 0.5 + aa * 0.125) {
				stack.setDamageValue(stack.getDamageValue() - 1);
				if (net.hackermdch.pgc.Timer.isDone(sourceentity, "wfj_sx")) {
					a = Math.random() - Math.random();
					net.hackermdch.pgc.Timer.set(sourceentity, "wfj_sx", (int) (100 - 100 * aa * 0.1));
				}
			} else {
				a = 0.02;
			}
			attr.add(Attributes.ATTACK_SPEED, "wfj", a, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
	}
}