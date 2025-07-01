package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GUIfumopinzhixianshi0Procedure {
	public static boolean execute(LevelAccessor world) {
		return GUIfumofanhuishuzi0Procedure.execute() == 1 && world != null && world.isClientSide();
	}
}