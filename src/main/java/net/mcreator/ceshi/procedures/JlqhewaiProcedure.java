package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import net.hackermdch.pgc.CustomAPI;

public class JlqhewaiProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		String s1 = "";
		double a = 0;
		double b = 0;
		stack = itemstack;
		b = HSjinglianupProcedure.execute(entity, stack);
		var attr = CustomAPI.getAttributes(stack);
		if (stack.getItem() == PrimogemcraftModItems.JSLYZH.get()) {
			a = 0.24 + 0.06 * b;
			attr.add(Attributes.MAX_HEALTH, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.TKZR.get()) {
			a = 0.08 + 0.02 * b;
			attr.add(Attributes.ATTACK_DAMAGE, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.PYJL.get()) {
			a = 0.1 + 0.025 * b;
			attr.add(Attributes.MAX_HEALTH, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
			attr.add(Attributes.ATTACK_DAMAGE, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.HEIJIAN.get()) {
			a = 0.2 + 0.05 * b;
			attr.add(Attributes.ATTACK_DAMAGE, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.HMZZ.get()) {
			a = 0.2 + 0.05 * b;
			attr.add(Attributes.MAX_HEALTH, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.XFCQ.get()) {
			a = 0.1 + 0.025 * b;
			attr.add(Attributes.MAX_HEALTH, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.TCZDG.get()) {
			a = 0.08 + 0.02 * b;
			attr.add(Attributes.ATTACK_DAMAGE, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.HPY.get()) {
			a = 0.1 + 0.025 * b;
			attr.add(Attributes.ATTACK_DAMAGE, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND);
			attr.add(Attributes.ENTITY_INTERACTION_RANGE, "bd", a * 1.5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
	}
}