package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class CunqupingzhengshiyongProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		ItemStack a0 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("pgc_cunchu")
					&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PrimogemcraftModBlocks.XJHPYHFH.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PrimogemcraftModBlocks.BWDXJHPYHFH.get())) {
				if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("bwd_yinhang")) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PrimogemcraftModBlocks.XJHPYHFH.get()) {
						a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("pgc_cunchu");
						a0 = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						a0.setCount((int) a);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, a0);
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						itemstack.shrink(1);
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
						if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "yinhang_busunhuai")) {
							world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId((world.getBlockState(BlockPos.containing(x, y, z)))));
							world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chest.close")), SoundSource.NEUTRAL, (float) 0.7, (float) 0.4);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chest.close")), SoundSource.NEUTRAL, (float) 0.7, (float) 0.4, false);
							}
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u8BE5\u8BBE\u65BD\u5DF2\u65E0\u6388\u6743\uFF0C\u8BF7\u5728\u6B63\u89C4\u8BBE\u65BD\u8FDB\u884C\u53D6\u51FA\uFF01"), false);
					}
				} else {
					b = Mth.nextDouble(RandomSource.create(), 0.5, 2.4);
					a = Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("pgc_cunchu") * b);
					if (Math.random() < 0.5) {
						a0 = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						a0.setCount((int) a);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, a0);
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("\u00A78\u4F60\u5F97\u5230\u4E86\u00A77<" + new java.text.DecimalFormat("##.##").format(a)
									+ ">\u00A78\u5B87\u5B99\u788E\u7247\uFF01\u00A77\uFF08\u7EA6\u4E3A\u539F\u5148\u7684\u00A7d<" + new java.text.DecimalFormat("##.##").format(b) + ">\u00A77\u500D!)")), false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chest.close")), SoundSource.NEUTRAL, (float) 0.7, (float) 0.4);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chest.close")), SoundSource.NEUTRAL, (float) 0.7, (float) 0.4, false);
							}
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7c\u4F60\u4E00\u65E0\u6240\u83B7\uFF01"), false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, (float) 0.7, (float) 0.8);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, (float) 0.7, (float) 0.8, false);
							}
						}
					}
					itemstack.shrink(1);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
					if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "yinhang_busunhuai")) {
						world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId((world.getBlockState(BlockPos.containing(x, y, z)))));
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					}
				}
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}