package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class QwxzsabProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String s1 = "";
		if (!world.isClientSide()) {
			if (Math.random() < 0.1) {
				s1 = "s";
			} else if (Math.random() < 0.3) {
				s1 = "a";
			} else {
				s1 = "b";
			}
			GUIqwxz03Procedure.execute(world, x, y, z, entity, "normal/" + s1);
		}
	}
}