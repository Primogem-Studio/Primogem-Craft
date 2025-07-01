package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GUIfumopinzhixianshi2Procedure {
	public static boolean execute(LevelAccessor world) {
		return GUIfumofanhuishuzi0Procedure.execute() == 3 && world != null && world.isClientSide();
	}
}