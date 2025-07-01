package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.entity.QQyuanchuzi01Entity;
import net.mcreator.ceshi.entity.QQQyuanchulan01Entity;

import java.util.Comparator;

public class TtiaoguozhizhangshuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		YouhuayoujianfangfangzhiProcedure.execute();
		if (!world.isClientSide()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof QQyuanchuzi01Entity || entityiterator instanceof QQQyuanchulan01Entity || entityiterator instanceof QqiyuanJinGuangEntity) {
						if (!(entityiterator instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI))) {
							if (getEntityGameType(entity) == GameType.CREATIVE) {
								if (entityiterator instanceof QqiyuanJinGuangEntity) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												"loot spawn ~ ~ ~ loot primogemcraft:qqyjin");
								}
								if (entityiterator instanceof QQyuanchuzi01Entity) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												"loot spawn ~ ~ ~ loot primogemcraft:q_qqyzi");
								}
								if (entityiterator instanceof QQQyuanchulan01Entity) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												"loot spawn ~ ~ ~ loot primogemcraft:qq_qqylan");
								}
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(
											"\u60A8\u662F\u521B\u9020\u6A21\u5F0F\uFF0C\u5DF2\u5C06\u6240\u6709\u7ED3\u679C\u6B63\u5E38\u8F93\u51FA\u5956\u52B1\uFF01\u00A78\u5305\u62EC\u522B\u4EBA\u7684\u4EE5\u53CA\u4E0D\u5E94\u5F53\u5B58\u5728\u7684\uFF09"),
											false);
							} else {
								if (!(entityiterator.getPersistentData().getString("qiyuan_guishu")).equals(entity.getDisplayName().getString())) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A76\u5305\u542B\u4E00\u4E9B\u4E0D\u5C5E\u4E8E\u4F60\u7684\u7948\u613F\u7ED3\u679C\uFF0C\u5B83\u5C5E\u4E8E\u5176\u4ED6\u4EBA"), false);
								} else {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:dashengchulan01")), SoundSource.PLAYERS, (float) 0.2, (float) 0.9);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:dashengchulan01")), SoundSource.PLAYERS, (float) 0.2, (float) 0.9, false);
										}
									}
									if (entityiterator instanceof QqiyuanJinGuangEntity && entityiterator.getPersistentData().getBoolean("chouka_jiance_2")) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4,
													"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "loot spawn ~ ~ ~ loot primogemcraft:qqyjin");
									}
									if (entityiterator instanceof QQyuanchuzi01Entity && entityiterator.getPersistentData().getBoolean("chouka_jiance_1")) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4,
													"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "loot spawn ~ ~ ~ loot primogemcraft:q_qqyzi");
									}
									if (entityiterator instanceof QQQyuanchulan01Entity && entityiterator.getPersistentData().getBoolean("chouka_jiance_0")) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4,
													"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "loot spawn ~ ~ ~ loot primogemcraft:qq_qqylan");
									}
									if (!(entityiterator.getPersistentData().getBoolean("chouka_jiance_2") || entityiterator.getPersistentData().getBoolean("chouka_jiance_1") || entityiterator.getPersistentData().getBoolean("chouka_jiance_0"))) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), new ItemStack(PrimogemcraftModItems.YSJFR.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7c\u68C0\u6D4B\u5230\u4E0D\u5E94\u8BE5\u5B58\u5728\u7684\u62BD\u5361\u5B9E\u4F53\uFF0C\u5DF2\u5C06\u5176\u9500\u6BC1"), false);
									}
									if (!entityiterator.level().isClientSide())
										entityiterator.discard();
									if (world instanceof ServerLevel _level) {
										itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
										});
									}
								}
							}
						}
					}
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