package net.mcreator.ceshi.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class LianjiaxiajiehejinkuaiBlock extends Block {
	public LianjiaxiajiehejinkuaiBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).sound(SoundType.NETHERITE_BLOCK).strength(3f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}