package net.mcreator.ceshi.procedures;

public class DaimaHS0Procedure {
	public static double execute(boolean xiao_guo, double zhi_0) {
		if (xiao_guo) {
			return zhi_0 == 0 ? 1 : zhi_0 + 1;
		}
		return 0;
	}
}