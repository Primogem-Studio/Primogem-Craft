package net.mcreator.ceshi.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class CshixiutiezhalanBlock extends IronBarsBlock {
	public CshixiutiezhalanBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.LANTERN).strength(2f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).ignitedByLava());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}