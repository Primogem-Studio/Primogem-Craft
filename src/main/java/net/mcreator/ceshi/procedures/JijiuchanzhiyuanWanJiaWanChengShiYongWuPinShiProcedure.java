package net.mcreator.ceshi.procedures;

import net.per.wish.SpawnWishiEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class JijiuchanzhiyuanWanJiaWanChengShiYongWuPinShiProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean o = false;
		double a = 0;
		double in = 0;
		double iw = 0;
		if (!world.isClientSide()) {
			o = entity.isShiftKeyDown();
			in = o ? itemstack.getCount() : 1;
			iw = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen");
			a = o ? iw * in : iw;
			new SpawnWishiEntity.Spawn(world, entity, (int) in, a, true).Spawn();
			itemstack.shrink((int) in);
		}
	}
}