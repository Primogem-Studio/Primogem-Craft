package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Axtsx1Procedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		HuoqihanshuProcedure.execute(entity, new ItemStack(PrimogemcraftModItems.HQBING.get()), itemstack, "aixu_tao_zhi");
		a = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("aixu_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("aixu_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("aixu_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("aixu_tao_zhi");
		if (a >= 2) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem) {
				entity.getPersistentData().putDouble("ax_dj_sx", (entity.getPersistentData().getDouble("ax_dj_sx") + 1));
				if (entity.getPersistentData().getDouble("ax_dj_sx") >= a * 25 * 0.5) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * a * 0.25 * 0.5 * 0.04));
					entity.getPersistentData().putDouble("ax_dj_sx", 0);
				}
				if (!(entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(PrimogemcraftModMobEffects.RYKJXG))) {
					if (a >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.RYKJXG, 1200, (int) Math.round(a - 1), false, false));
					}
				}
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.RYKJXG);
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.RYKJXG);
		}
		if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(PrimogemcraftModMobEffects.RYKJXG)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.RYKJXG) ? _livEnt.getEffect(PrimogemcraftModMobEffects.RYKJXG).getAmplifier() : 0) != Math.round(a - 1)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.RYKJXG);
			}
		}
		AxbykjsxxfProcedure.execute(entity);
	}
}