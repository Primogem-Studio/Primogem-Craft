package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GUIfumopinzhixianshi1Procedure {
	public static boolean execute(LevelAccessor world) {
		return GUIfumofanhuishuzi0Procedure.execute() == 2 && world != null && world.isClientSide();
	}
}