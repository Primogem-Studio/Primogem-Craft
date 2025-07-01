package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class XckfsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, (x + Mth.nextInt(RandomSource.create(), -10, 10)), y, (z + Mth.nextInt(RandomSource.create(), -10, 10)), 4, Level.ExplosionInteraction.MOB);
	}
}