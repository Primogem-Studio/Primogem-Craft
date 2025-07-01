package net.mcreator.ceshi.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class AixubingyufangkuIBlock extends Block {
	public AixubingyufangkuIBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.ICE).sound(SoundType.GLASS).strength(3f, 20f).requiresCorrectToolForDrops().friction(1.2f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}