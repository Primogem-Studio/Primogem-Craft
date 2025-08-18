package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class HSYhdltsxProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item0, ItemStack item_yichu, boolean bao_he_du_xiao_hao, boolean bao_shi_du_xiao_hao, boolean gailv_lei, boolean item,
			boolean jing_yan_zhi_xiao_hao, boolean sheng_ming_zhi_she_zhi, boolean tong_zhi, boolean zeng_yi, boolean zhi_ling, double bao_he_zhi, double bao_shi_du_baifen, double chu_fa, double item_shu_liang, double jing_yan_zhi_baifen,
			double kai_shi, double sheng_ming_zhi, double zeng_yi_item, double zeng_yi_zhi_ling, double zhi_ling_shu_liang, String cheng_gong, String wen_ben_item_yichu, String wen_ben_zhi_ling) {
		if (entity == null || cheng_gong == null || wen_ben_item_yichu == null || wen_ben_zhi_ling == null)
			return false;
		ItemStack it_1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (Math.random() < kai_shi) {
				if (Math.random() < chu_fa) {
					if (tong_zhi) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(cheng_gong), false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					}
					if (!zeng_yi) {
						if (gailv_lei) {
							if (item) {
								it_1 = item0;
								it_1.setCount((int) item_shu_liang);
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), it_1);
									entityToSpawn.setPickUpDelay(0);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						} else {
							if (zhi_ling) {
								for (int index0 = 0; index0 < (int) zhi_ling_shu_liang; index0++) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												wen_ben_zhi_ling);
								}
							}
						}
					} else {
						if (gailv_lei) {
							if (item) {
								if (entity instanceof Player _player) {
									ItemStack _setstack = item0.copy();
									_setstack.setCount((int) (item_shu_liang + zeng_yi_item));
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							}
						} else {
							if (zhi_ling) {
								for (int index1 = 0; index1 < (int) (zhi_ling_shu_liang + zeng_yi_zhi_ling); index1++) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												wen_ben_zhi_ling);
								}
							}
						}
					}
				} else {
					if (tong_zhi) {
						item_yichu.shrink(1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((wen_ben_item_yichu + "\u00A7c\u5DF2\u635F\u574F")), false);
					}
					if (bao_shi_du_xiao_hao) {
						if (entity instanceof Player _player)
							_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) * bao_shi_du_baifen));
					}
					if (bao_he_du_xiao_hao) {
						if (entity instanceof Player _player)
							_player.getFoodData().setSaturation((float) bao_he_zhi);
					}
					if (jing_yan_zhi_xiao_hao) {
						if (entity instanceof Player _player)
							_player.giveExperiencePoints(-((int) jing_yan_zhi_baifen));
					}
					if (sheng_ming_zhi_she_zhi) {
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((float) sheng_ming_zhi);
					}
					return true;
				}
			}
		}
		return false;
	}
}