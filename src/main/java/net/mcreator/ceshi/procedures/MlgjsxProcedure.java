package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;

import net.hackermdch.pgc.CustomAPI;

public class MlgjsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		var attr = CustomAPI.getAttributes(itemstack);
		attr.add(Attributes.BLOCK_BREAK_SPEED, "mlgj", 1 + (0.25 * a), AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
		attr.apply();
	}
}