package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class ZizaitaoshuxingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		HuoqihanshuProcedure.execute(entity, new ItemStack(PrimogemcraftModItems.HQFENG.get()), itemstack, "zizai_tao_zhi");
		b = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zizai_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zizai_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zizai_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zizai_tao_zhi");
		if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.SLOW_FALLING)) && !entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
			if (b >= 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, (int) (b * 0.5 - 1), true, false));
			}
		}
		if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.JUMP))) {
			if (b >= 4) {
				if (!entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b + 2), true, false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b - 1), true, false));
				}
			}
		}
	}
}