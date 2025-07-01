package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class Dibiaomolayiji_xinxianzhiProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !(world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:wasteland")))
				&& world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_beach")))
				&& world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:dry")))
				&& world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:hot")))
				&& world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_ocean")))
				&& world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_river")))
				&& world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:water"))) && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("desert"))
				&& !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains")) && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains")));
	}
}