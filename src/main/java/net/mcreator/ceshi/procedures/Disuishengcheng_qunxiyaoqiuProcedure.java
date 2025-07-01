package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class Disuishengcheng_qunxiyaoqiuProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		return world.getBiome(BlockPos.containing(x, 100, z)).value().getBaseTemperature() * 100f < 0 || world.getBiome(BlockPos.containing(x, 80, z)).value().getBaseTemperature() * 100f < 0
				|| world.getBiome(BlockPos.containing(x, 64, z)).value().getBaseTemperature() * 100f < 0;
	}
}