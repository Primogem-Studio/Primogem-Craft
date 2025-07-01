package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class Shiti_cao_beileipiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
		world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.CAOYUANHEKUAI.get().defaultBlockState(), 3);
	}
}