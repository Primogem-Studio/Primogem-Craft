package net.mcreator.ceshi.procedures;

import net.minecraft.client.gui.screens.Screen;

public class Diaoyongshift0Procedure {
	public static String execute(String shift, String shift0) {
		if (shift == null || shift0 == null)
			return "";
		if (Screen.hasShiftDown()) {
			return shift + "\n";
		}
		return "\u00A77\u6309\u4F4F\u00A7eShift\u00A77\u67E5\u770B" + ((shift0).equals("") ? "\u8BE6\u60C5" : shift0) + "\n";
	}
}