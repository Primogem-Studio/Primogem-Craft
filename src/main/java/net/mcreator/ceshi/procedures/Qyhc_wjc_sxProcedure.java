package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Qyhc_wjc_sxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack i = ItemStack.EMPTY;
		if (entity.isShiftKeyDown()) {
			a = itemstack.getCount();
			itemstack.shrink((int) a);
			i = new ItemStack(PrimogemcraftModItems.QYHX.get()).copy();
			i.setCount((int) a);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, i);
				entityToSpawn.setPickUpDelay(1);
				_level.addFreshEntity(entityToSpawn);
			}
		} else {
			itemstack.shrink(1);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PrimogemcraftModItems.QYHX.get()));
				entityToSpawn.setPickUpDelay(1);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}