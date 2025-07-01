package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class YuanshishengchengProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(PrimogemcraftModGameRules.GUIZEYUANSHISHENGCHENG);
	}
}