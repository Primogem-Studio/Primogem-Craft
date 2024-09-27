package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class ZsgsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ores/coal")))) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y + 1, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			{
				ItemStack _ist = itemstack;
				_ist.hurtAndBreak(10, RandomSource.create(), null, () -> {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				});
			}
			if (Math.random() < 0.5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.break")), SoundSource.BLOCKS, 5, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.break")), SoundSource.BLOCKS, 5, (float) 0.5, false);
					}
				}
				if (Math.random() < 0.05) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ores_in_ground/deepslate")))) {
						world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.ZUISHENGKUANGSHI.get().defaultBlockState(), 3);
					} else {
						world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.ZUISHENGKUANGSHI.get().defaultBlockState(), 3);
					}
				} else {
					if (Math.random() < 0.2) {
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ores_in_ground/deepslate")))) {
							world.setBlock(BlockPos.containing(x, y, z), Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y, z), Blocks.DIAMOND_ORE.defaultBlockState(), 3);
						}
					} else {
						if (Math.random() < 0.3) {
							world.setBlock(BlockPos.containing(x, y, z), Blocks.NETHER_QUARTZ_ORE.defaultBlockState(), 3);
						} else {
							if (Math.random() < 0.3) {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ores_in_ground/deepslate")))) {
									world.setBlock(BlockPos.containing(x, y, z), Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState(), 3);
								} else {
									world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_ORE.defaultBlockState(), 3);
								}
							} else {
								if (Math.random() < 0.3) {
									if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ores_in_ground/deepslate")))) {
										world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.SHENBANYANYUANSHIKUANGSHI.get().defaultBlockState(), 3);
									} else {
										world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.YUANSHIKUANGSHI.get().defaultBlockState(), 3);
									}
								} else {
									if (Math.random() < 0.3) {
										if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ores_in_ground/deepslate")))) {
											world.setBlock(BlockPos.containing(x, y, z), Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState(), 3);
										} else {
											world.setBlock(BlockPos.containing(x, y, z), Blocks.LAPIS_ORE.defaultBlockState(), 3);
										}
									} else {
										if (Math.random() < 0.2) {
											if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ores_in_ground/deepslate")))) {
												world.setBlock(BlockPos.containing(x, y, z), Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 3);
											} else {
												world.setBlock(BlockPos.containing(x, y, z), Blocks.EMERALD_ORE.defaultBlockState(), 3);
											}
										} else {
											if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ores_in_ground/deepslate")))) {
												world.setBlock(BlockPos.containing(x, y, z), Blocks.DEEPSLATE.defaultBlockState(), 3);
											} else {
												world.setBlock(BlockPos.containing(x, y, z), Blocks.STONE.defaultBlockState(), 3);
											}
										}
									}
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQLEI.get())) : false) ? 600 : 1200));
			}
		}
	}
}
