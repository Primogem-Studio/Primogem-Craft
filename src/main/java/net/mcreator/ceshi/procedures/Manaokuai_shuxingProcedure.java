package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class Manaokuai_shuxingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(15);
	}
}