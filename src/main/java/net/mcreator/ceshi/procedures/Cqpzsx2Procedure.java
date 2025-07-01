package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Cqpzsx2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("pgc_cunchu")) {
			itemstack.shrink(1);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PrimogemcraftModItems.CUNQUPINGZHENG.get()));
				entityToSpawn.setPickUpDelay(Mth.nextInt(RandomSource.create(), 1, 10));
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}