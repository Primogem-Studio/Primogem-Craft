package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class QyNBTProcedure {
	public static void execute(Entity entitiss, Entity entity, boolean baodi, String zhi) {
		if (entitiss == null || entity == null || zhi == null)
			return;
		entity.getPersistentData().putString("qiyuan_guishu", (entitiss.getDisplayName().getString()));
		if (!baodi) {
			entitiss.getPersistentData().putDouble("chouka", (entitiss.getPersistentData().getDouble("chouka") - 1));
			entitiss.getPersistentData().putDouble("chouka_jiacheng", (entitiss.getPersistentData().getDouble("chouka_jiacheng") - 1));
		}
		entity.getPersistentData().putBoolean(("chouka_jiance_" + zhi), true);
	}
}