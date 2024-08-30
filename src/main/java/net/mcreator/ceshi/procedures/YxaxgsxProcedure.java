package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class YxaxgsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (blockstate.getBlock() == PrimogemcraftModBlocks.YUANSUJINGSHIKUAI.get()) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQBING.get())) : false) ? 10 : 20));
			if (Math.random() < ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQBING.get())) : false) ? 1 : 0.95)) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.power_select")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.power_select")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (Math.random() < 0.18) {
					world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.ZIYOUSONGSHIKUAI.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.18) {
					world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.JIANLAOHUANGYUKUAI.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.18) {
					world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.ZUISNEGZIJINGKUAI.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.18) {
					world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.SHENGZHANGBIFEIDAKUAI.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.18) {
					world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.DIJINGQINGJINKUAI.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.18) {
					world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.RANYUANKUAI_2.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.AIXUBINGYUFANGKU_I.get().defaultBlockState(), 3);
				}
			} else {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(PrimogemcraftModBlocks.YUANSUJINGSHIKUAI.get().defaultBlockState()));
			}
		}
	}
}
