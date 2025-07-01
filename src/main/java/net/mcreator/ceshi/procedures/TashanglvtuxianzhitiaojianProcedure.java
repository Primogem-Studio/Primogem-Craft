package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

public class TashanglvtuxianzhitiaojianProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		PrimogemcraftMod.queueServerWork(20, () -> {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(PrimogemcraftModItems.TASHANGLVTUCHANGPIAN.get(), 1280);
		});
	}
}