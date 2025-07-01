package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class DiaoyongjisuanjingyanzhiProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double jingyan = 0;
		double jingyan_0 = 0;
		double jingyan_1 = 0;
		double jingyan_2 = 0;
		jingyan_0 = entity instanceof Player _plr ? _plr.experienceLevel : 0;
		if (jingyan_0 > 0 && jingyan_0 < 17) {
			jingyan_1 = jingyan_0 * jingyan_0 + 6 * jingyan_0;
		}
		if (jingyan_0 >= 16 && jingyan_0 <= 31) {
			jingyan_1 = 2.5 * jingyan_0 * jingyan_0 - 40.5 * jingyan_0 + 360;
		}
		if (jingyan_0 >= 32) {
			jingyan_1 = 4.5 * jingyan_0 * jingyan_0 - 162.5 * jingyan_0 + 2220;
		}
		jingyan = jingyan_1 + (entity instanceof Player p ? Math.floor(p.experienceProgress * (entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0)) : 0);
		return jingyan;
	}
}