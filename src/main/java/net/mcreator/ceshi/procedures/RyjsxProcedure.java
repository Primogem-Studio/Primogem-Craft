package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class RyjsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.ZHUOSHAO))) {
			if (itemstack.getItem() == PrimogemcraftModItems.RYTJ.get()) {
				if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQHUO.get())) ? 0.375 : 0.25)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.ZHUOSHAO, 120, 0));
				}
			}
			if (itemstack.getItem() == PrimogemcraftModItems.RYZSJ.get()) {
				if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQHUO.get())) ? 0.75 : 0.5)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.ZHUOSHAO, 120, 1));
				}
			}
			if (itemstack.getItem() == PrimogemcraftModItems.RYHJJ.get()) {
				if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQHUO.get())) ? 1 : 0.75)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.ZHUOSHAO, 120, 2));
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}