package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class GUIbhmgsxhs1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return GUIbhmgsxhs0Procedure.execute(entity, 0) && GUIbhmgsxhs0Procedure.execute(entity, 1) && GUIbhmgsxhs0Procedure.execute(entity, 2);
	}
}