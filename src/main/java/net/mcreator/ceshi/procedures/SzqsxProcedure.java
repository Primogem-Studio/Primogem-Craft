package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class SzqsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && (blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:dirt"))) || blockstate.getBlock() == Blocks.DIRT_PATH)) {
			if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQCAO.get())) ? 5 : 10));
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qianye_chufa")), SoundSource.NEUTRAL, (float) 0.3, 5);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qianye_chufa")), SoundSource.NEUTRAL, (float) 0.3, 5, false);
				}
			}
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.GRASS_BLOCK.defaultBlockState(), 3);
			} else {
				if (Math.random() < 0.2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.DIRT_PATH.defaultBlockState(), 3);
				} else {
					if (Math.random() < 0.2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.MYCELIUM.defaultBlockState(), 3);
					} else {
						if (Math.random() < 0.2) {
							world.setBlock(BlockPos.containing(x, y, z), Blocks.DIRT.defaultBlockState(), 3);
						} else {
							if (Math.random() < 0.2) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.COARSE_DIRT.defaultBlockState(), 3);
							} else {
								if (Math.random() < 0.2) {
									world.setBlock(BlockPos.containing(x, y, z), Blocks.PODZOL.defaultBlockState(), 3);
								} else {
									if (Math.random() < 0.2) {
										world.setBlock(BlockPos.containing(x, y, z), Blocks.FARMLAND.defaultBlockState(), 3);
									} else {
										if (Math.random() < 0.02) {
											world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.SHENGZHANGKUANGSHI.get().defaultBlockState(), 3);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}