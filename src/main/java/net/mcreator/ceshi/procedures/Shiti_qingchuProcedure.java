package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class Shiti_qingchuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
	}
}