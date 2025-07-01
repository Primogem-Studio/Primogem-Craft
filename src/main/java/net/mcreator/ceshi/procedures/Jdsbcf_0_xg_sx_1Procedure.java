package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Jdsbcf_0_xg_sx_1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plrCldCheck0 && _plrCldCheck0.getCooldowns().isOnCooldown(PrimogemcraftModItems.JDSBCF_0.get()))) {
			Jdsbcf0xgsx0Procedure.execute(world, entity);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(PrimogemcraftModItems.JDSBCF_0.get(), 12000);
		}
	}
}