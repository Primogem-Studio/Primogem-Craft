package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.Minecraft;

public class YuanshikuangshiZaiFangKuaiShangYouJianProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		if (world.isClientSide())
			Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
	}
}