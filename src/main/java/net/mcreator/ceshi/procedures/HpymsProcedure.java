package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.component.DataComponents;

public class HpymsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		String s1 = "";
		a = HSjinglianupProcedure.execute(entity, itemstack);
		s1 = "hpy_e_" + new java.text.DecimalFormat("").format(a);
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u57FA\u7840\u6280\u80FD" + "\n" + "\u00A7e\u5177\u6709\u4E0E\u91CD\u9524\u4E00\u81F4\u7684\u653B\u51FB\u6A21\u7EC4" + "\n"
				+ ("\u00A76\u00A7l\u00A7n\u53F3\u952E" + "\n")
				+ "\u00A7e\u5411\u524D\u65B9\u79FB\u52A8\u4E00\u6BB5\u8DDD\u79BB\uFF0C\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD\uFF0C\u540C\u65F6\u5BF9\u63A5\u89E6\u5230\u7684\u4EFB\u4F55\u751F\u7269\u9020\u6210\u4E00\u6B21\u7B49\u540C\u4E8E\u5F53\u524D\u653B\u51FB\u529B\u00A7b"
				+ new java.text.DecimalFormat("##.##%").format(0.5 + 0.125 * a) + "\u00A7e\u7684\u7279\u6B8A\u4F24\u5BB3\uFF0C\u8BE5\u6548\u679C\u00A7b" + new java.text.DecimalFormat("##.##\u00A7e\u79D2").format(8 - 1 * a)
				+ "\u00A7e\u6062\u590D\u4E00\u6B21\uFF0C\u81F3\u591A\u5B58\u50A8\u00A7b" + new java.text.DecimalFormat("##.##\u00A7e\u6B21").format(2 + (a > 3 ? 1 * (a - 3) : 0))
				+ ("\n" + ("\u00A7e\u53F3\u952E\u79FB\u52A8\u65F6\u6309\u4F4F\u00A7b W \u00A7e\u53EF\u4EE5\u8D8A\u8FC7\u81F3\u591A3\u683C\u65B9\u5757\u7684\u969C\u788D" + "\n" + "\u00A77\u5F53\u524D\u5B58\u50A8\uFF1A\u00A7b"
						+ new java.text.DecimalFormat("").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j"))) + "\n")
				+ "\u00A76\u00A7l\u00A7n\u6F5C\u884C\u53F3\u952E" + "\n" + "\u00A7e\u83B7\u5F97\u8DF3\u8DC3\u63D0\u5347\u6548\u679C\uFF0C\u51B7\u537430\u79D2\uFF0C\u8D4B\u4E88\u00A7b"
				+ new java.text.DecimalFormat("##.##\u00A7e\u7EA7\uFF0C\u6301\u7EED\u00A7b").format(5 + 1 * a) + new java.text.DecimalFormat("##.##\u00A7e\u79D2").format(10 + 2.5 * a)
				+ ("\n" + ("\u00A77\u5F53\u524D\u72B6\u6001\uFF1A"
						+ (net.hackermdch.pgc.Timer.isDone(entity, "hpy_t") && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.JUMP)) ? "\u00A7a\u53EF\u91CA\u653E" : "\u00A7c\u51B7\u5374\u4E2D")) + "\n")
				+ ("\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u6700\u7EC8\u653B\u51FB\u529B\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.1 + 0.025 * a) + "\n" + "\u00A7e\u653B\u51FB\u8DDD\u79BB\u63D0\u5347\u00A7b"
						+ new java.text.DecimalFormat("##.##%").format((0.1 + 0.025 * a) * 1.5)));
	}
}