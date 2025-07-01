package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class DjppguochengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.DJPPXIANZHI)) && entity.isAlive()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJPPXIANZHI, 40, 0, false, false));
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.DJPP) ? _livEnt.getEffect(PrimogemcraftModMobEffects.DJPP).getAmplifier() : 0) == 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 4);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.DJPP) ? _livEnt.getEffect(PrimogemcraftModMobEffects.DJPP).getAmplifier() : 0) == 1) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 2 + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.05));
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.DJPP) ? _livEnt.getEffect(PrimogemcraftModMobEffects.DJPP).getAmplifier() : 0) == 2) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1 + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.1));
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.DJPP) ? _livEnt.getEffect(PrimogemcraftModMobEffects.DJPP).getAmplifier() : 0) > 2) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.25));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:djpp1")), SoundSource.PLAYERS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:djpp1")), SoundSource.PLAYERS, (float) 0.5, 1, false);
				}
			}
		}
	}
}