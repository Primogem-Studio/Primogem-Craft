package net.mcreator.ceshi.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class LlianjiamolakuaiqiangBlock extends WallBlock {
	public LlianjiamolakuaiqiangBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).strength(3f, 30f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASEDRUM).forceSolidOn());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}