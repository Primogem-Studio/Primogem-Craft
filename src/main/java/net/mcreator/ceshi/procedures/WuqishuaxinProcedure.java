package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

import net.hackermdch.pgc.CustomAPI;

public class WuqishuaxinProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, ItemStack item) {
		if (entity == null)
			return false;
		ItemStack stack = ItemStack.EMPTY;
		double a1 = 0;
		double a11 = 0;
		double a = 0;
		double a2 = 0;
		double b = 0;
		double a12 = 0;
		double c = 0;
		stack = item.copy();
		a = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + 1;
		var attr = CustomAPI.getAttributes(stack);
		a1 = 30;
		a2 = 60;
		a11 = (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGHAI));
		a12 = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jun_heng / 1000;
		if (a > a2) {
			b = a1 * a11 * (0.01 + a12);
			c = c + b;
			b = a1 * a11 * (0.02 + a12 * 1.5);
			c = c + b;
			c = c + (a - a2) * a11 * (0.03 + a12 * 2);
			attr.add(Attributes.ATTACK_DAMAGE, "djjc", c, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
			return true;
		} else if (a >= a1 && a <= a2) {
			b = a1 * a11 * (0.01 + a12);
			c = c + b;
			c = c + (a - a1) * a11 * (0.02 + a12 * 1.5);
			attr.add(Attributes.ATTACK_DAMAGE, "djjc", c, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
			return true;
		} else if (a < a1) {
			c = c + a * a11 * (0.01 + a12);
			attr.add(Attributes.ATTACK_DAMAGE, "djjc", c, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
			return true;
		}
		return false;
	}
}