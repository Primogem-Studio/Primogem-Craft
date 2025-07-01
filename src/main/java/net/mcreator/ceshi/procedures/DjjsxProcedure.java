package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class DjjsxProcedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (!(sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.DJPP))) {
			if (itemstack.getItem() == PrimogemcraftModItems.DJTJ.get()) {
				if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQSHUI.get())) ? 0.75 : 0.5)) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJPP, 120, 0));
				}
			}
			if (itemstack.getItem() == PrimogemcraftModItems.DDJZSJ.get()) {
				if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQSHUI.get())) ? 0.15 : 0.1)) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJPP, 200, 1));
				}
			}
			if (itemstack.getItem() == PrimogemcraftModItems.DJHJJ.get()) {
				if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQSHUI.get())) ? 0.15 : 0.1)) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJPP, 320, 2));
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