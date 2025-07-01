package net.mcreator.ceshi.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class ShenbanyanyuanshikuangshiBlock extends Block {
	public ShenbanyanyuanshikuangshiBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).sound(SoundType.POLISHED_DEEPSLATE).strength(5f).lightLevel(s -> 1).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}