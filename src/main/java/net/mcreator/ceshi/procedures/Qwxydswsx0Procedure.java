package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Qwxydswsx0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			i1 = new ItemStack(PrimogemcraftModItems.JLLIANG.get());
			i1.setCount(Mth.nextInt(RandomSource.create(), 32, 64));
			HS0wzswProcedure.execute(world, x, y, z, entity, i1, itemstack, false, 0, 0, "");
		}
	}
}