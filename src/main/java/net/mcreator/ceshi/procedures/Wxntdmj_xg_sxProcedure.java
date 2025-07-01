package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class Wxntdmj_xg_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			entity.getPersistentData().putDouble("wxnt_jishi", (entity.getPersistentData().getDouble("wxnt_jishi") + 1));
			if (entity.getPersistentData().getBoolean("wxntdmj_cf") && entity.getPersistentData().getDouble("wxnt_jishi") >= 400) {
				entity.getPersistentData().putBoolean("wxntdmj_cf", false);
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) * 0.5));
				entity.getPersistentData().putDouble("wxnt_jishi", 0);
			}
		}
	}
}