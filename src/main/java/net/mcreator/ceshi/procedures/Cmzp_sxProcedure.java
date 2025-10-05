package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.h;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModAttributes;

import net.hackermdch.pgc.CustomAPI;

public class Cmzp_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		double a = 0;
		double h = 0;
		double z = 0;
		if (!world.isClientSide()) {
			if (net.hackermdch.pgc.Timer.isDone(entity, "cmzp")) {
				net.hackermdch.pgc.Timer.set(entity, "cmzp", 40);
				z = (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.016 * (ItemshulProcedure.execute(world, entity, new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get())) / 64);
				stack = itemstack;
				var attr = CustomAPI.getAttributes(stack);
				attr.add(PrimogemcraftModAttributes.EWAI_SHANGHAI_MF, "cmzp", z, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.ANY);
				attr.add(PrimogemcraftModAttributes.LQSJP, "cmzp", -20, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.ANY);
				attr.apply();
			}
		}
	}
}