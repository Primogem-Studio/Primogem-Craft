package net.mcreator.ceshi.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.ceshi.procedures.YuanshishengchengProcedure;

public class ShenbanyanyuanshikuangshiFeatureFeature extends OreFeature {
	public ShenbanyanyuanshikuangshiFeatureFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!YuanshishengchengProcedure.execute(world))
			return false;
		return super.place(context);
	}
}