/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.world.features.*;
import net.mcreator.ceshi.PrimogemcraftMod;

public class PrimogemcraftModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, PrimogemcraftMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> YUANSHIKUANGSHI_FEATURE = REGISTRY.register("yuanshikuangshi_feature", YuanshikuangshiFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> MOLAYIJI_01_FEATURE = REGISTRY.register("molayiji_01_feature", Molayiji01FeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> XXIAOGUANZI_01_FEATURE = REGISTRY.register("xxiaoguanzi_01_feature", Xxiaoguanzi01FeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> XXIAOGUANZI_02_FEATURE = REGISTRY.register("xxiaoguanzi_02_feature", Xxiaoguanzi02FeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ZHZHONGGUANZI_01_FEATURE = REGISTRY.register("zhzhongguanzi_01_feature", Zhzhongguanzi01FeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> DDAGUANZI_01_FEATURE = REGISTRY.register("ddaguanzi_01_feature", Ddaguanzi01FeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> DISUIKUAI_1_FEATURE = REGISTRY.register("disuikuai_1_feature", Disuikuai1FeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SHENBANYANYUANSHIKUANGSHI_FEATURE = REGISTRY.register("shenbanyanyuanshikuangshi_feature", ShenbanyanyuanshikuangshiFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> MOLAYIJI_2 = REGISTRY.register("molayiji_2", Molayiji2Feature::new);
}