package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class GuigoumaiqiwuwenbenProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A7f\u6D88\u8017" + (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.HTDZ) ? "\u00A7a13" : "16") + "\u00A7f\u5B87\u5B99\u788E\u7247\u3002";
	}
}