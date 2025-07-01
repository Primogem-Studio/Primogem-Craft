package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class Ydggzxgsx0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			entity.getPersistentData().putDouble("yongdongguguzhong", (entity.getPersistentData().getDouble("yongdongguguzhong") + 1));
			if (entity.getPersistentData().getDouble("yongdongguguzhong") >= 3600) {
				entity.getPersistentData().putDouble("yongdongguguzhong", 0);
				if (DiaoyongjisuanjingyanzhiProcedure.execute(entity) != 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A75\u6C38\u52A8\u5495\u5495\u949F\u518D\u6B21\u89E6\u53D1\uFF08-5%\u5F53\u524D\u7ECF\u9A8C\u503C\uFF09"), false);
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(-((int) (DiaoyongjisuanjingyanzhiProcedure.execute(entity) * 0.05)));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.PLAYERS, (float) 0.5, (float) 0.5);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.PLAYERS, (float) 0.5, (float) 0.5, false);
						}
					}
				}
			}
		}
	}
}