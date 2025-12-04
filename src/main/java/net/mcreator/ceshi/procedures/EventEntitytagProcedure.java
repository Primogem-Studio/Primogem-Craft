package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.PrimogemcraftMod;

public class EventEntitytagProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		String s = "";
		double n = 0;
		if (entity.getPersistentData().getDouble("EventKillAll_") > 0) {
			s = "EventKillAll_" + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("EventKillAll_"));
			if (sourceentity.getPersistentData().getDouble(s) > 0) {
				sourceentity.getPersistentData().putDouble(s, (sourceentity.getPersistentData().getDouble(s) + 1));
			}
		}
		PrimogemcraftMod.LOGGER.info(n);
		PrimogemcraftMod.LOGGER.info(n > 0 && sourceentity.getPersistentData().getDouble(s) > 0);
		PrimogemcraftMod.LOGGER.info(sourceentity.getPersistentData().getDouble(s));
	}
}