package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class Szcsx2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			SzcsxProcedure.execute(world, x, y, z, entity, itemstack);
		} else {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR) {
				SzcsxProcedure.execute(world, x, y - 1, z, entity, itemstack);
			}
		}
	}
}