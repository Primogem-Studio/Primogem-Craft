package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Ysrq_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		double e = 0;
		double a1 = 0;
		double b1 = 0;
		double f = 0;
		if (!world.isClientSide() && entity instanceof Player player) {
			if (net.hackermdch.pgc.Timer.isDone(entity, "ysrz") && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("qidong")) {
				net.hackermdch.pgc.Timer.set(entity, "ysrz", 40);
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("feng")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FEIXING, 20, 0, false, false));
					if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("feng_teshu")) {
						YstzsxOProcedure.feng(player, 8);
					}
				}
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("yan")) {
					YstzsxOProcedure.yan(player, 8);
				}
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("lei")) {
					YstzsxOProcedure.lei(player, 8);
				}
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("cao")) {
					YstzsxOProcedure.cao(player, 8);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.YSRZXG, 60, 0, false, false));
				}
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("shui")) {
					YstzsxOProcedure.shui(player, 8);
				}
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("huo")) {
					YstzsxOProcedure.huo(player, 8);
				}
			}
		} //先这样，布几把改了
	}

	public boolean NBTe(ItemStack itemStack, String wen) {
		return itemStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean(wen);
	}
}