package net.mcreator.ceshi.procedures;

import net.per.wish.SpawnWishiEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class XixiangyuzhiyuanchoukaProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double in = 0;
		if (!world.isClientSide()) {
			in = entity.isShiftKeyDown() ? itemstack.getCount() : 1;
			new SpawnWishiEntity.Spawn(world, entity, (int) in, 0, false).Spawn();
			itemstack.shrink((int) in);
		}
	}
}