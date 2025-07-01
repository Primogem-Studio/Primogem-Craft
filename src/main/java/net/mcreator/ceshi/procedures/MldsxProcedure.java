package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class MldsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
			if (blockstate.getBlock() == PrimogemcraftModBlocks.MLXDML_03.get()) {
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.MLXDML_02.get().defaultBlockState(), 3);
			}
			if (blockstate.getBlock() == PrimogemcraftModBlocks.MLXDML_02.get()) {
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.MLXDML_01.get().defaultBlockState(), 3);
			}
			if (blockstate.getBlock() == PrimogemcraftModBlocks.MLXDML_01.get()) {
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.MOLADUI_02.get().defaultBlockState(), 3);
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