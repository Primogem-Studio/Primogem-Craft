package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class MsSHwuqiProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		boolean o1 = false;
		double a = 0;
		double b = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") + 1;
		b = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + 1;
		var sb = new StringBuilder();
		for (int index0 = 0; index0 < (int) a; index0++) {
			sb.append('■');
		}
		for (int index1 = 0; index1 < (int) (5 - a); index1++) {
			sb.append('□');
		}
		o1 = entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(PrimogemcraftModMobEffects.SKLJXG);
		return ((b <= 0 ? "\u00A7c\u00A7l" : "") + "Lv:" + new java.text.DecimalFormat("").format(Math.floor(b))) + "\n" + "\u00A76\u7CBE\u70BC:"
				+ (a <= 0 ? "\u00A7c\u00A7l" + new java.text.DecimalFormat("").format(a - (o1 ? 0 : 1)) : sb.toString() + "" + (o1 ? "\u00A7b\u25A0" : "")) + "\n" + QywuqimsleiProcedure.execute(itemstack);
	}
}