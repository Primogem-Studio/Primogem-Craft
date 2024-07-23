
package net.mcreator.ceshi.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.ceshi.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.ceshi.procedures.Dibiaomolayiji_xinxianzhiProcedure;

public class Dibiaomola01FeatureFeature extends StructureFeature {
	public Dibiaomola01FeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!Dibiaomolayiji_xinxianzhiProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
