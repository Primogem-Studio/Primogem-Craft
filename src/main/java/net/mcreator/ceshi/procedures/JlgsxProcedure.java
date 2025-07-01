package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class JlgsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.isShiftKeyDown()) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:stones"))) || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:cobblestones")))
						|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:ancient_city_replaceable")))) {
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak((int) Mth.nextDouble(RandomSource.create(), 1, 5), _level, null, _stkprov -> {
						});
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQYAN.get())) ? 200 : 400));
					if (Math.random() < 0.6) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.thunder")), SoundSource.BLOCKS, (float) 0.5, 2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.thunder")), SoundSource.BLOCKS, (float) 0.5, 2, false);
							}
						}
						if (Math.random() < 0.03) {
							world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.LIANJIAXIAJIEHEJINKUAI.get().defaultBlockState(), 3);
						} else {
							if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POLISHED_DEEPSLATE
									|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:ancient_city_replaceable")))) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), 3);
							} else {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.GOLD_ORE.defaultBlockState(), 3);
							}
						}
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.BLOCKS, (float) 0.5, 2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.BLOCKS, (float) 0.5, 2, false);
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