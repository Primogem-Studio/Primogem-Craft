package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class Ceshi_3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		GUIqwxz03Procedure.execute(world, x, y, z, entity, "other");
	}
}
