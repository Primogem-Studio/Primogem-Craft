package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class PpohuaifangkuaisuijimolaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
			MoladlhsProcedure.execute(world, x, y, z, entity, itemstack);
		}
	}
}