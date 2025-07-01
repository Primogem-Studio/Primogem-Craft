package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class AxcsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SNOW) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			} else {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SNOW)) {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.SNOW.defaultBlockState(), 3);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SNOW && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SNOW) {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.snow.fall")), SoundSource.BLOCKS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.snow.fall")), SoundSource.BLOCKS, (float) 0.5, 1, false);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQBING.get())) ? 5 : 10));
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			DiaoyonghuishouProcedure.execute(entity, itemstack);
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}