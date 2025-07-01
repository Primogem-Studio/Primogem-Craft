package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Gzsmz_sxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity e1 = null;
		if (!world.isClientSide()) {
			e1 = entity;
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")), SoundSource.PLAYERS, (float) 0.4, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")), SoundSource.PLAYERS, (float) 0.4, 1, false);
				}
			}
			e1.getPersistentData().putBoolean("wxntdmj_sx", false);
			if (e1 instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(PrimogemcraftModMobEffects.LETOUDECHENGFA)) {
				e1.getPersistentData().putBoolean("letou_chengfa", true);
				if (e1 instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.LETOUDECHENGFA);
			} else {
				e1.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FALLING_BLOCK)), 2);
			}
		}
	}
}