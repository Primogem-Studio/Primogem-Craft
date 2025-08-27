package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class Hpysx0Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double n = 0;
		String s1 = "";
		if (!world.isClientSide()) {
			a = HSjinglianupProcedure.execute(entity, itemstack);
			n = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j");
			s1 = "hpy_e_" + new java.text.DecimalFormat("").format(a);
			if (n < 1 + (a > 3 ? 1 * (a - 3) : 0) && net.hackermdch.pgc.Timer.isDone(entity, s1)) {
				{
					final String _tagName = "hpy_bd_j";
					final double _tagValue = (n + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				net.hackermdch.pgc.Timer.set(entity, s1, (int) (160 - 20 * a));
			}
		}
	}
}