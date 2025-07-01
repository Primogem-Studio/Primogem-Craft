package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class MlsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, ItemStack itemstack) {
		if (blockstate.is(BlockTags.create(ResourceLocation.parse("c:moladui"))) && !(blockstate.getBlock() == PrimogemcraftModBlocks.DBMLK.get())) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chain.place")), SoundSource.BLOCKS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 1, 1.1));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chain.place")), SoundSource.BLOCKS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 1, 1.1), false);
					}
				}
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(PrimogemcraftModItems.MMOLA_01.get()).copy();
				_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() + 1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
			itemstack.shrink(1);
			MoladuiHSProcedure.execute(world, x, y, z, PrimogemcraftModBlocks.MOLADUI_02.get().defaultBlockState(), PrimogemcraftModBlocks.MLXDML_01.get().defaultBlockState(), blockstate, 4);
			MoladuiHSProcedure.execute(world, x, y, z, PrimogemcraftModBlocks.MLXDML_01.get().defaultBlockState(), PrimogemcraftModBlocks.MLXDML_02.get().defaultBlockState(), blockstate, 7);
			MoladuiHSProcedure.execute(world, x, y, z, PrimogemcraftModBlocks.MLXDML_02.get().defaultBlockState(), PrimogemcraftModBlocks.MLXDML_03.get().defaultBlockState(), blockstate, 20);
			MoladuiHSProcedure.execute(world, x, y, z, PrimogemcraftModBlocks.MLXDML_03.get().defaultBlockState(), PrimogemcraftModBlocks.DBMLK.get().defaultBlockState(), blockstate, 25);
		}
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