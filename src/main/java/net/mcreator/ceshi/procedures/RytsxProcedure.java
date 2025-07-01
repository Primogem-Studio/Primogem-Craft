package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class RytsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		HuoqihanshuProcedure.execute(entity, new ItemStack(PrimogemcraftModItems.HQHUO.get()), itemstack, "ranyuan_tao_zhi");
		a = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ranyuan_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ranyuan_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ranyuan_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ranyuan_tao_zhi");
		if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.FIRE_RESISTANCE))) {
			if (a >= 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 80, 0, true, false));
			}
		}
		if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(PrimogemcraftModMobEffects.RYKJXG))) {
			if (a >= 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.RYKJXG, 1200, (int) Math.round(a - 1), false, false));
			}
		}
		if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(PrimogemcraftModMobEffects.RYKJXG)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.RYKJXG) ? _livEnt.getEffect(PrimogemcraftModMobEffects.RYKJXG).getAmplifier() : 0) != Math.round(a - 1)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.RYKJXG);
			}
		}
	}
}