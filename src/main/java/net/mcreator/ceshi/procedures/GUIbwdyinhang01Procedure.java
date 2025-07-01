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

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class GUIbwdyinhang01Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack b = ItemStack.EMPTY;
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			a = getAmountInGUISlot(entity, 0) + getAmountInGUISlot(entity, 1) + getAmountInGUISlot(entity, 2);
			b = new ItemStack(PrimogemcraftModItems.CUNQUPINGZHENG.get());
			{
				final String _tagName = "pgc_cunchu";
				final double _tagValue = a;
				CustomData.update(DataComponents.CUSTOM_DATA, b, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "bwd_yinhang";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, b, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			b.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7e\u00A7kbw\u00A7e\u5B58\u53D6\u51ED...\u8BC1\uFF1F\u00A7kwd"));
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(1).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(2).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chest.close")), SoundSource.BLOCKS, 1, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chest.close")), SoundSource.BLOCKS, 1, (float) 0.5, false);
				}
			}
			if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "yinhang_busunhuai")) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(PrimogemcraftModBlocks.XJHPYHFH.get().defaultBlockState()));
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, b);
				entityToSpawn.setPickUpDelay(Mth.nextInt(RandomSource.create(), 1, 10));
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
			ItemStack stack = _menu.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}