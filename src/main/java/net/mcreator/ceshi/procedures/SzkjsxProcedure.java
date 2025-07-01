package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
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

public class SzkjsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (!world.isClientSide()) {
			HuoqihanshuProcedure.execute(entity, new ItemStack(PrimogemcraftModItems.HQCAO.get()), itemstack, "shengzheng_tao_zhi");
			a = a + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shengzheng_tao_zhi")
					+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shengzheng_tao_zhi")
					+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shengzheng_tao_zhi")
					+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("shengzheng_tao_zhi");
			if (a >= 2) {
				if (Math.random() < 0.0005) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0, true, false));
				}
			}
			if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.HEALTH_BOOST)) && !(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(PrimogemcraftModMobEffects.SZTSXCWDP))) {
				entity.getPersistentData().putDouble("yuanbenshengminzhi", (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
				if (a >= 4) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200000, (int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4) * Math.round(a) * 0.1), true, false));
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0) != Math
						.floor((entity.getPersistentData().getDouble("yuanbenshengminzhi") / 4) * Math.floor(a) * 0.1) || a < 4) {
					entity.getPersistentData().putBoolean("yuanbenshengminzhi", false);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.HEALTH_BOOST);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SZTSXCWDP, 20, 0, false, false));
				}
			}
		}
	}
}