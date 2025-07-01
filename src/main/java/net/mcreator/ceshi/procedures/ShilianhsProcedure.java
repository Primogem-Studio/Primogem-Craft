package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;

public class ShilianhsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double R_radius = 0;
		double D_delta_theta = 0;
		double T_theta = 0;
		double N_number = 0;
		N_number = 8;
		R_radius = 3;
		D_delta_theta = (2 * Math.PI) / N_number;
		for (int index0 = 0; index0 < (int) N_number; index0++) {
			T_theta = index0 * D_delta_theta;
			Qqqystx10Procedure.execute(world, x + R_radius * Math.sin(T_theta), y + 6, z + R_radius * Math.cos(T_theta));
		}
		Qqqystx10Procedure.execute(world, x, y + 6, z);
		Qqqystx10Procedure.execute(world, x, y + 7, z);
	}
}