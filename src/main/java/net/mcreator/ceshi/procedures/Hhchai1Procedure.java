package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.PrimogemcraftMod;

public class Hhchai1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PrimogemcraftMod.queueServerWork(5, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:hh_chai_1")), SoundSource.PLAYERS, (float) 0.5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:hh_chai_1")), SoundSource.PLAYERS, (float) 0.5, 1, false);
					}
				}
			}
		});
	}
}