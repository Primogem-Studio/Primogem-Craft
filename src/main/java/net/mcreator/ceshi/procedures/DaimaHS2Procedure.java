package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class DaimaHS2Procedure {
	public static double execute(LevelAccessor world, double x, double y, double z, Entity sourceentity, double shang_xian) {
		if (sourceentity == null)
			return 0;
		double p = 0;
		for (Entity entityiterator : world.getEntities(sourceentity, new AABB((x + 8), (y + 8), (z + 8), (x - 8), (y - 8), (z - 8)))) {
			if (entityiterator instanceof Player) {
				p = p + 1;
			}
		}
		return shang_xian + shang_xian * (p >= 3 ? 3 : p);
	}
}