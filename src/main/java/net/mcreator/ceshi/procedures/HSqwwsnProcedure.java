package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class HSqwwsnProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, ItemStack itemstack, boolean e_wai, boolean tong_zhi, double gai_lv, double shu, String da, String items, String xiao) {
		if (entity == null || da == null || items == null || xiao == null)
			return false;
		String a = "";
		ItemStack item1 = ItemStack.EMPTY;
		if (itemstack.isEnchanted()) {
			item1 = itemstack;
			EnchantmentHelper.setEnchantments(item1, ItemEnchantments.EMPTY);
		}
		if (!world.isClientSide()) {
			if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
				if (entity.getPersistentData().getBoolean("xiao_guan_zi")) {
					a = xiao;
				} else {
					a = da;
				}
				for (int index0 = 0; index0 < (int) shu; index0++) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
										new Vec3((entity.getPersistentData().getDouble("guan_zi_x")), (entity.getPersistentData().getDouble("guan_zi_y")), (entity.getPersistentData().getDouble("guan_zi_z"))), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(), a);
					if (e_wai) {
						if (Math.random() < gai_lv) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getPersistentData().getDouble("guan_zi_x")), (entity.getPersistentData().getDouble("guan_zi_y")), (entity.getPersistentData().getDouble("guan_zi_z")), item);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if (tong_zhi) {
					if (itemstack.getDamageValue() == itemstack.getMaxDamage()) {
						Diaoyongqiwu66Procedure.execute(world, x, y, z);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((items + "\u00A7c\u5DF2\u635F\u574F\uFF01")), false);
					}
				}
				return true;
			}
		}
		return false;
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