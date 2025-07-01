package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModBlocks;
import net.mcreator.ceshi.PrimogemcraftMod;

public class GUIyinhanggunkaiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chest.close")), SoundSource.BLOCKS, (float) 0.8, (float) 0.6);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chest.close")), SoundSource.BLOCKS, (float) 0.8, (float) 0.6, false);
			}
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "yinhang_busunhuai")) {
			PrimogemcraftMod.queueServerWork(10, () -> {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(PrimogemcraftModBlocks.XJHPYHFH.get().defaultBlockState()));
			});
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u8BE5\u94F6\u884C\u5DF2\u88AB\u66F4\u9AD8\u7EA7\u7684\u5B58\u5728\u4FDD\u62A4\uFF01"), false);
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}