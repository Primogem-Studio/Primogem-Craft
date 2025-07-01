package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class Guoqu_jieshuProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo((entity.getPersistentData().getDouble("zuobiao_x")), (entity.getPersistentData().getDouble("zuobiao_y")), (entity.getPersistentData().getDouble("zuobiao_z")));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("zuobiao_x")), (entity.getPersistentData().getDouble("zuobiao_y")), (entity.getPersistentData().getDouble("zuobiao_z")), _ent.getYRot(), _ent.getXRot());
		}
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth((float) entity.getPersistentData().getDouble("shengmingzhi_1"));
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof Player) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("zuobiao_x"), entity.getPersistentData().getDouble("zuobiao_y"), entity.getPersistentData().getDouble("zuobiao_z")),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.PLAYERS, 4, (float) 0.5);
				} else {
					_level.playLocalSound((entity.getPersistentData().getDouble("zuobiao_x")), (entity.getPersistentData().getDouble("zuobiao_y")), (entity.getPersistentData().getDouble("zuobiao_z")),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.PLAYERS, 4, (float) 0.5, false);
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("zuobiao_x"), entity.getPersistentData().getDouble("zuobiao_y"), entity.getPersistentData().getDouble("zuobiao_z")),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.NEUTRAL, (float) 0.1, (float) 0.5);
				} else {
					_level.playLocalSound((entity.getPersistentData().getDouble("zuobiao_x")), (entity.getPersistentData().getDouble("zuobiao_y")), (entity.getPersistentData().getDouble("zuobiao_z")),
							BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.NEUTRAL, (float) 0.1, (float) 0.5, false);
				}
			}
		}
	}
}