package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class NaijiuxianzhishuchuProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.setDamageValue((int) (itemstack.getMaxDamage() - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("naijiu_xianzhi")));
	}
}