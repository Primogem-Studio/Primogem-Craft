package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class ZizaijianshuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == PrimogemcraftModItems.ZIZAITIEJIAN.get()) {
			if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQFENG.get())) ? 0.375 : 0.25)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 2, 20, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_2")), SoundSource.PLAYERS, (float) 0.5,
								(float) Mth.nextDouble(RandomSource.create(), 1.5, 3));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_2")), SoundSource.PLAYERS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 1.5, 3), false);
					}
				}
			}
		}
		if (itemstack.getItem() == PrimogemcraftModItems.ZIZAIZUANSHIJIAN.get()) {
			if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQFENG.get())) ? 0.75 : 0.5)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 2, 45, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_2")), SoundSource.PLAYERS, (float) 0.5,
								(float) Mth.nextDouble(RandomSource.create(), 1.5, 3));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_2")), SoundSource.PLAYERS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 1.5, 3), false);
					}
				}
			}
		}
		if (itemstack.getItem() == PrimogemcraftModItems.ZIZAIHEJINJIAN.get()) {
			if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQFENG.get())) ? 1 : 0.75)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 2, 60, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_2")), SoundSource.PLAYERS, (float) 0.5,
								(float) Mth.nextDouble(RandomSource.create(), 1.5, 3));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_2")), SoundSource.PLAYERS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 1.5, 3), false);
					}
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