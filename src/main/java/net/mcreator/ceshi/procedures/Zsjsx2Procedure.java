package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Zsjsx2Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		if (entity.isShiftKeyDown()) {
			if (itemstack.getItem() == PrimogemcraftModItems.ZSTJ.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.GOUYU, 200, 0));
			}
			if (itemstack.getItem() == PrimogemcraftModItems.ZSZSJ.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.GOUYU, 200, 1));
			}
			if (itemstack.getItem() == PrimogemcraftModItems.ZSHJJ.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.GOUYU, 200, 2));
			}
			i1 = new ItemStack(PrimogemcraftModItems.HQLEI.get());
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(PrimogemcraftModItems.ZSTJ.get(), (int) HuoqiHSProcedure.execute(world, entity, i1, false, 300));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(PrimogemcraftModItems.ZSZSJ.get(), (int) HuoqiHSProcedure.execute(world, entity, i1, false, 400));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(PrimogemcraftModItems.ZSHJJ.get(), (int) HuoqiHSProcedure.execute(world, entity, i1, false, 480));
		}
	}
}