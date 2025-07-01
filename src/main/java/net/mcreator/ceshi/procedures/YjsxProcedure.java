package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModBlocks;
import net.mcreator.ceshi.PrimogemcraftMod;

public class YjsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 127, false, false));
		PrimogemcraftMod.queueServerWork(160, () -> {
			if (entity.isAlive()) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 8, Level.ExplosionInteraction.TNT);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 10, (float) 0.5);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 10, (float) 0.5, false);
					}
				}
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.YUANSHIKUANGSHI.get().defaultBlockState(), 3);
				if (Math.random() < 0.5) {
					world.setBlock(BlockPos.containing(x, y + 1, z), PrimogemcraftModBlocks.YUANSHIKUANGSHI.get().defaultBlockState(), 3);
				}
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 20);
				if (!(entity instanceof Player)) {
					{
						Entity _ent = entity;
						_ent.teleportTo(x, (-63), z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, (-63), z, _ent.getYRot(), _ent.getXRot());
					}
				} else {
					PrimogemcraftMod.queueServerWork(20, () -> {
						if (entity.isAlive()) {
							entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 20);
						}
					});
				}
			}
		});
	}
}