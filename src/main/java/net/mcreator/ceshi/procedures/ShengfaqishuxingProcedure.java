package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class ShengfaqishuxingProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if ((world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV)) <= 1) {
				if ((world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV)) == 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7a\u9B54\u9634\u8EAB\u751F\u6210\u500D\u7387\u5DF2\u964D\u81F30"), false);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7a\u9B54\u9634\u8EAB\u751F\u6210\u500D\u7387\u5DF2\u964D\u81F30"), false);
					world.getLevelData().getGameRules().getRule(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV).set(0, world.getServer());
				}
			} else {
				world.getLevelData().getGameRules().getRule(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV).set((world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV)) - 1, world.getServer());
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A72\u9B54\u9634\u8EAB\u751F\u6210\u500D\u7387\u5DF2\u8C03\u6574\u81F3" + (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV)))),
							false);
			}
		} else {
			world.getLevelData().getGameRules().getRule(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV).set((world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV)) + 1, world.getServer());
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7c\u9B54\u9634\u8EAB\u751F\u6210\u500D\u7387\u5DF2\u63D0\u9AD8\u81F3" + (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV)))),
						false);
		}
		if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
		}
		if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.OFF_HAND, true);
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