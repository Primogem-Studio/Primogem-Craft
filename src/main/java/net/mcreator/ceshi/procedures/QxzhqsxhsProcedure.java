package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class QxzhqsxhsProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, ItemStack item, ItemStack item0, double shan_bian, double zhi, double zhi_0, double zhi_1) {
		ItemStack i1 = ItemStack.EMPTY;
		ItemStack i2 = ItemStack.EMPTY;
		double n1 = 0;
		double bn1 = 0;
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "shan_bian") >= 1) {
			i1 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) zhi).copy());
			i2 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) (zhi + 1)).copy());
			n1 = i2.getCount() + zhi_1;
			bn1 = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "shan_bian");
			if ((i2.getItem() == Blocks.AIR.asItem() || n1 <= i2.getMaxStackSize()) && bn1 - shan_bian >= 0 && i1.getCount() >= zhi_0 && i1.getItem() == item0.getItem() && (i2.getItem() == item.getItem() || i2.getItem() == Blocks.AIR.asItem())) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = (int) zhi;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink((int) zhi_0);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = item.copy();
					_setstack.setCount((int) n1);
					_itemHandlerModifiable.setStackInSlot((int) (zhi + 1), _setstack);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("shan_bian", (bn1 - shan_bian));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				return true;
			}
			return false;
		}
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}