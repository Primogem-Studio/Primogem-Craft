package net.mcreator.ceshi.block;

import net.neoforged.neoforge.common.util.TriState;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ShengzhangbifeidakuaiBlock extends Block {
	public ShengzhangbifeidakuaiBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.GLASS).strength(3f, 15f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public TriState canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, BlockState plant) {
		return TriState.TRUE;
	}
}