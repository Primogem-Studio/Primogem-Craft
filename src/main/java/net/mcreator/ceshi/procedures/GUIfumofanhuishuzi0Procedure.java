package net.mcreator.ceshi.procedures;

import net.minecraft.client.Minecraft;

public class GUIfumofanhuishuzi0Procedure {
	public static double execute() {
		return Minecraft.getInstance().player.getPersistentData().getDouble("pgc_shijian_fumo_pinzhi");
	}
}