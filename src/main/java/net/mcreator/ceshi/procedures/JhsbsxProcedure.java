package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class JhsbsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		boolean a1 = false;
		if (!world.isClientSide()) {
			if (entity.isShiftKeyDown() && getEntityGameType(entity) == GameType.CREATIVE) {
				{
					PrimogemcraftModVariables.PlayerVariables _vars = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
					_vars.jun_heng = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7a\u00A7l\u4F60\u662F\u521B\u9020\u6A21\u5F0F\uFF0C\u5DF2\u6F5C\u884C\u53F3\u952E\u5C06\u5747\u8861\u7B49\u7EA7\u8BBE\u7F6E\u4E3A 0"), false);
			} else {
				a = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jun_heng / 1000;
				b = (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGHAI));
				if (Jhsbsx0Procedure.execute(entity, new ItemStack(PrimogemcraftModItems.JHSB_0.get()), itemstack, a, 0.005 + b * 0.0005)
						|| Jhsbsx0Procedure.execute(entity, new ItemStack(PrimogemcraftModItems.JHSB_1.get()), itemstack, a, 0.015 + b * 0.0005)
						|| Jhsbsx0Procedure.execute(entity, new ItemStack(PrimogemcraftModItems.JHSB_2.get()), itemstack, a, 0.035 + b * 0.0005)) {
					itemstack.shrink(1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.PLAYERS, 1, (float) 0.9);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.PLAYERS, 1, (float) 0.9, false);
						}
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}