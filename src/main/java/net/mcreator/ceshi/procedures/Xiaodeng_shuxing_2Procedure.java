package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class Xiaodeng_shuxing_2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getY() >= 256) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}