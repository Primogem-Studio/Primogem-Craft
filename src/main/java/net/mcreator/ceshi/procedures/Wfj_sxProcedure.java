package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import net.hackermdch.pgc.CustomAPI;

public class Wfj_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		double a = 0;
		if (!world.isClientSide()) {
			stack = itemstack.copy();
			var attr = CustomAPI.getAttributes(stack);
			if (Math.random() < HSjinglianProcedure.execute(entity, itemstack) * 0.2) {
				stack.setDamageValue(stack.getDamageValue() - 1);
				if (!(sourceentity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown(stack.getItem()))) {
					a = Math.random() - Math.random();
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(PrimogemcraftModItems.WUFENGJIAN.get(), (int) (100 - 100 * HSjinglianProcedure.execute(entity, itemstack) * 0.1));
				}
			} else {
				a = 0.02;
			}
			attr.add(Attributes.ATTACK_SPEED, "wfj", a, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
	}
}