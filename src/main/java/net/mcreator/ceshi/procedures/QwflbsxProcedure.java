package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QwflbsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			a = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
			a.setCount((int) (Math.random() < 0.5 ? Mth.nextInt(RandomSource.create(), 1, 10) : 1));
			FenliejinbisxhsProcedure.execute(world, x, y, z, entity, a, itemstack, true, 10, 0.8, 24, 10);
		}
	}
}