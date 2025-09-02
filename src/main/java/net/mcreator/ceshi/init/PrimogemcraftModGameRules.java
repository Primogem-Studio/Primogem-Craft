/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PrimogemcraftModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> GUIZEMOYINSHENSHENGCHENGBEILV;
	public static GameRules.Key<GameRules.IntegerValue> GUIZEMOYINSHENSHENGMINGZHI;
	public static GameRules.Key<GameRules.BooleanValue> GUIZEYUANSHISHENGCHENG;
	public static GameRules.Key<GameRules.BooleanValue> JINYONGNANG;
	public static GameRules.Key<GameRules.IntegerValue> GUIZESUIJISHIJIAN;
	public static GameRules.Key<GameRules.IntegerValue> GUIZESHIJIANXIANZHI;
	public static GameRules.Key<GameRules.IntegerValue> GUIZEWUQISHANGXIAN;
	public static GameRules.Key<GameRules.IntegerValue> GUIZEWUQISHANGHAI;
	public static GameRules.Key<GameRules.IntegerValue> GUIZEBUHUOMINGGUANGZHI;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		GUIZEMOYINSHENSHENGCHENGBEILV = GameRules.register("guizemoyinshenshengchengbeilv", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(1));
		GUIZEMOYINSHENSHENGMINGZHI = GameRules.register("guizemoyinshenshengmingzhi", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(256));
		GUIZEYUANSHISHENGCHENG = GameRules.register("guizeyuanshishengcheng", GameRules.Category.UPDATES, GameRules.BooleanValue.create(true));
		JINYONGNANG = GameRules.register("jinyongnang", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		GUIZESUIJISHIJIAN = GameRules.register("guizesuijishijian", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
		GUIZESHIJIANXIANZHI = GameRules.register("guizeshijianxianzhi", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(5));
		GUIZEWUQISHANGXIAN = GameRules.register("guizewuqishangxian", GameRules.Category.PLAYER, GameRules.IntegerValue.create(89));
		GUIZEWUQISHANGHAI = GameRules.register("guizewuqishanghai", GameRules.Category.PLAYER, GameRules.IntegerValue.create(9));
		GUIZEBUHUOMINGGUANGZHI = GameRules.register("guizebuhuomingguangzhi", GameRules.Category.MOBS, GameRules.IntegerValue.create(20));
	}
}