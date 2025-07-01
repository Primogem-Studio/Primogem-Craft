package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class DjqsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIRT || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIRT_PATH) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.CLAY.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.hoe.till")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.hoe.till")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (Math.random() < 0.25) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CLAY) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.SAND.defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.hoe.till")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.hoe.till")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
					});
				}
				if (Math.random() < 0.25) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			}
			DiaoyonghuishouProcedure.execute(entity, itemstack);
		}
	}
}