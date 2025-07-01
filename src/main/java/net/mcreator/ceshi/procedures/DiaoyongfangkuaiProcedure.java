package net.mcreator.ceshi.procedures;

public class DiaoyongfangkuaiProcedure {
	public static String execute(double zhi, double zui_da, String miaoshu) {
		if (miaoshu == null)
			return "";
		double a = 0;
		var sb = new StringBuilder();
		for (int index0 = 0; index0 < (int) zhi; index0++) {
			sb.append('■');
		}
		for (int index1 = 0; index1 < (int) (zui_da - zhi); index1++) {
			sb.append('□');
		}
		return miaoshu + "" + sb.toString() + "\n";
	}
}