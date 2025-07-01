package net.mcreator.ceshi.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class CangsangshizhuantaijieBlock extends SlabBlock {
	public CangsangshizhuantaijieBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2f, 15f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}