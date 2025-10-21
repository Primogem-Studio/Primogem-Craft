package net.mcreator.ceshi.procedures;

import net.minecraft.client.gui.screens.Screen;

public class DzmbmshsProcedure {
	public static String execute(String ms, String wen_0, String wen_1, String wen_2, String wen_3) {
		if (ms == null || wen_0 == null || wen_1 == null || wen_2 == null || wen_3 == null)
			return "";
		return Screen.hasShiftDown()
				? ms
				: ms + "" + (("\u00A77" + wen_0) + "\n" + "" + "\n" + "\u00A77\u53EF\u5E94\u7528\u4E8E\uFF1A" + "\n" + ("\u00A79 " + wen_1) + "\n" + "\u00A77\u6240\u9700\u539F\u6750\u6599\uFF1A" + "\n" + ("\u00A79 " + wen_2) + "\n"
						+ "\u00A77\u76D4\u7532\u5957\u88C5\u503C\uFF1A" + "\n" + ("\u00A7d " + wen_3));
	}
}