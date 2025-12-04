package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class EventEntitytagProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		String s = "";
		double n = 0;
		if (entity.getPersistentData().getDouble("EventKillAll_") > 0) {
			s = "EventKillAll_" + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("EventKillAll_"));
			if (sourceentity.getPersistentData().getDouble(s) > 0) {
				sourceentity.getPersistentData().putDouble(s, (sourceentity.getPersistentData().getDouble(s) + 1));
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7e\u5DF2\u51FB\u6740\u4E00\u4E2A\u6761\u4EF6\u76EE\u6807"), false);
			}
		}
	}
}