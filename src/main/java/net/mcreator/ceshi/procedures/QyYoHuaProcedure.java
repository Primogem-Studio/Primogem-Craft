package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class QyYoHuaProcedure {
	public static double execute(Entity entity, double zhia, double zhib, double zhic) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getBoolean("xiangyu") ? zhia : zhib + (entity.getPersistentData().getDouble("chouka_jiacheng") > 0 ? (entity.getPersistentData().getDouble("Prayers_strengthen") / zhic) * 0.01 : 0);
	}
}