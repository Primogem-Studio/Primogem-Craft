package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class GUI_cunzhe_czProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("GUI_yzsp_sl", 0);
	}
}