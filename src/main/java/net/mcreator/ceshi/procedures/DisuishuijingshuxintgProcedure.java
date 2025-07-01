package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class DisuishuijingshuxintgProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		Direction a = Direction.NORTH;
		Direction d1 = Direction.NORTH;
		return (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR;
	}
}