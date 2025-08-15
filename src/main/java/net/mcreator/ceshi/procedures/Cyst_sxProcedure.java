package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Cyst_sxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack i = ItemStack.EMPTY;
		a = cyst_ssx(entity, EquipmentSlot.FEET) + cyst_ssx(entity, EquipmentSlot.LEGS) + cyst_ssx(entity, EquipmentSlot.CHEST) + cyst_ssx(entity, EquipmentSlot.HEAD);
		if (a < 4 && !(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.YSRZXG))) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.CYST);
		}
	}

	public static double cyst_ssx(Entity entity, EquipmentSlot z) {
		if (entity == null)
			return 0;
		return (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(z) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shengzheng_tao_zhi");
	}
}