package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class Qwsczzsx1Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String s1 = "";
		double n1 = 0;
		if (!world.isClientSide()) {
			n1 = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("qw");
			switch ((int) n1) {
				case 1 : {
					s1 = "b";
				}
					break;
				case 2 : {
					s1 = "a";
				}
					break;
				case 3 : {
					s1 = "s";
				}
					break;
			}
			GUIqwxz03Procedure.execute(world, entity, true, "c:curio/normal/" + s1);
			itemstack.shrink(1);
		}
	}
}