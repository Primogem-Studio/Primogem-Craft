package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class DaoqixiaoguomsProcedure {
	public static String execute(Entity entity, ItemStack itemstack, String zhi) {
		if (entity == null || zhi == null)
			return "";
		return "\u00A7e\u6D88\u8017\u9971\u98DF\u5EA6\u5BF9\u9644\u8FD1\u4EC7\u6068\u4F60\u7684\u751F\u7269\u9020\u6210\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.3 * HSjinglianProcedure.execute(entity, itemstack))
				+ "\u00A7e\u653B\u51FB\u529B\u7684\u95EA\u7535\u4F24\u5BB3" + zhi;
	}
}