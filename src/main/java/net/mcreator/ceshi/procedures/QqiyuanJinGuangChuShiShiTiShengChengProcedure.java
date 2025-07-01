package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.world.inventory.GUIbhmgMenu;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;

import io.netty.buffer.Unpooled;

public class QqiyuanJinGuangChuShiShiTiShengChengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		boolean o1 = false;
		if (entity.onGround()) {
			o1 = entity instanceof QqiyuanJinGuangEntity _datEntL1 && _datEntL1.getEntityData().get(QqiyuanJinGuangEntity.DATA_bhmg);
			if (getEntityGameType(sourceentity) == GameType.CREATIVE) {
				if (o1) {
					if (sourceentity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("GUIbhmg");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new GUIbhmgMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else {
					QycjzlpProcedure.execute(world, x, y, z);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				if ((entity.getPersistentData().getString("qiyuan_guishu")).equals(sourceentity.getDisplayName().getString())) {
					if (entity.getPersistentData().getBoolean("chouka_jiance_2")) {
						if (o1) {
							if (sourceentity instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(x, y, z);
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("GUIbhmg");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new GUIbhmgMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						} else {
							QycjzlpProcedure.execute(world, x, y, z);
						}
						if (!entity.level().isClientSide())
							entity.discard();
					} else {
						if (!entity.level().isClientSide())
							entity.discard();
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PrimogemcraftModItems.YSJFR.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				} else if (!entity.getPersistentData().getBoolean("chouka_jiance_2")) {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PrimogemcraftModItems.YSJFR.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(
								Component.literal(("\u00A7c\u8FD9\u4E2A\u7948\u613F\u7ED3\u679C\u4E0D\u5C5E\u4E8E\u4F60\uFF0C\u5B83\u5F52\u5C5E\u00A7f<" + entity.getPersistentData().getString("qiyuan_guishu") + ">\u00A7c\uFF01")), false);
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