package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class GuoqukaishiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("zuobiao_x", (entity.getX()));
		entity.getPersistentData().putDouble("zuobiao_y", (entity.getY()));
		entity.getPersistentData().putDouble("zuobiao_z", (entity.getZ()));
		entity.getPersistentData().putDouble("shengmingzhi_1", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
		if (entity instanceof Player) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.PLAYERS, (float) 0.5, (float) 0.2);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.PLAYERS, (float) 0.5, (float) 0.2, false);
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.NEUTRAL, (float) 0.1, (float) 0.2);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.NEUTRAL, (float) 0.1, (float) 0.2, false);
				}
			}
		}
	}
}