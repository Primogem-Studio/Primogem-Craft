package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class Hpysx0Procedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double n = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		n = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j");
		if (n < 2 + 1 * (a - 3) && net.hackermdch.pgc.Timer.isDone(entity, "hpy_e")) {
			{
				final String _tagName = "hpy_bd_j";
				final double _tagValue = (n + 1);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			net.hackermdch.pgc.Timer.set(entity, "hpy_e", (int) (160 - 20 * a));
		}
	}
}