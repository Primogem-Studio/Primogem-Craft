package net.mcreator.ceshi.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.ceshi.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.ceshi.procedures.Molayiji1shengchengtiaojianProcedure;

public class Molayiji01FeatureFeature extends StructureFeature {
	public Molayiji01FeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!Molayiji1shengchengtiaojianProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}