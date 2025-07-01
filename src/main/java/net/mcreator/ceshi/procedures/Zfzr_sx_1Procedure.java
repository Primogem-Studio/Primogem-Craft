package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class Zfzr_sx_1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (!world.isClientSide()) {
			a = HSjinglianupProcedure.execute(entity, itemstack);
			if (entity.isShiftKeyDown()) {
				if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.ABSORPTION) && !(entity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown(itemstack.getItem()))) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.ABSORPTION);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (0.4 + a * 0.1)));
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (2400 - a * 300));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.thunder")), SoundSource.PLAYERS, (float) 0.5, 3);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.thunder")), SoundSource.PLAYERS, (float) 0.5, 3, false);
						}
					}
				}
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.ABSORPTION);
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.2));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, (int) ((1 + a * 0.25) * 1200), (int) a));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")), SoundSource.PLAYERS, (float) 0.5, (float) 0.6);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")), SoundSource.PLAYERS, (float) 0.5, (float) 0.6, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 160);
			}
		}
	}
}