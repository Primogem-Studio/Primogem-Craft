package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GUIfumopinzhixianshi3Procedure {
	public static boolean execute(LevelAccessor world) {
		return GUIfumofanhuishuzi0Procedure.execute() == 4 && world != null && world.isClientSide();
	}
}