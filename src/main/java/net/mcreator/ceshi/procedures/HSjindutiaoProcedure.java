package net.mcreator.ceshi.procedures;

public class HSjindutiaoProcedure {
	public static String execute(double shu_liang, double yuan_shu_liang, String miao_shu, String yan_se) {
		if (miao_shu == null || yan_se == null)
			return "";
		double a1 = 0;
		String s2b = "";
		String s2a = "";
		String s1 = "";
		a1 = shu_liang;
		s1 = yan_se;
		s2a = "\u25A0";
		s2b = "\u25A1";
		return s1 + "" + miao_shu + new java.text.DecimalFormat("").format(yuan_shu_liang) + "\n" + s1
				+ (((a1 >= 1 ? s2a : s2b) + "" + (a1 >= 2 ? s2a : s2b) + (a1 >= 3 ? s2a : s2b) + (a1 >= 4 ? s2a : s2b)) + "" + ((a1 >= 5 ? s2a : s2b) + "" + (a1 >= 6 ? s2a : s2b) + (a1 >= 7 ? s2a : s2b) + (a1 >= 8 ? s2a : s2b))
						+ ((a1 >= 9 ? s2a : s2b) + "" + (a1 >= 10 ? s2a : s2b) + (a1 >= 11 ? s2a : s2b) + (a1 >= 12 ? s2a : s2b)) + ((a1 >= 13 ? s2a : s2b) + "" + (a1 >= 14 ? s2a : s2b) + (a1 >= 15 ? s2a : s2b) + (a1 >= 16 ? s2a : s2b)));
	}
}