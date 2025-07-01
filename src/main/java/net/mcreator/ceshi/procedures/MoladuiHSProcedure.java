package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class MoladuiHSProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState block1, BlockState block2, BlockState blockstate, double zhi) {
		if (blockstate.getBlock() == block1.getBlock()) {
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() > zhi) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
					_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
				world.setBlock(BlockPos.containing(x, y, z), block2, 3);
			}
			return true;
		}
		return false;
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