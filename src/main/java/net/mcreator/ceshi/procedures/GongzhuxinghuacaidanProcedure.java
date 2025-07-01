package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.PrimogemcraftMod;

public class GongzhuxinghuacaidanProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.JUKEBOX) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("yanhuaxiaocaidan")) {
				PrimogemcraftMod.queueServerWork(2180, () -> {
					PrimogemcraftMod.queueServerWork(6, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						PrimogemcraftMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
						});
					});
					PrimogemcraftMod.queueServerWork(21, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						PrimogemcraftMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
						});
					});
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					PrimogemcraftMod.queueServerWork(20, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
							}
						}
					});
					PrimogemcraftMod.queueServerWork(10, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						PrimogemcraftMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
						});
					});
					PrimogemcraftMod.queueServerWork(40, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						PrimogemcraftMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
						});
					});
					PrimogemcraftMod.queueServerWork(45, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						PrimogemcraftMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
						});
					});
					PrimogemcraftMod.queueServerWork(60, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						PrimogemcraftMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
						});
					});
					PrimogemcraftMod.queueServerWork(85, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						PrimogemcraftMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
						});
					});
				});
			}
		} else {
		}
	}
}