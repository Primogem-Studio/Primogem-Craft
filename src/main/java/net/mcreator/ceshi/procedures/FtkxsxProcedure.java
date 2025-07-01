package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class FtkxsxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
			entity.getPersistentData().putBoolean("zzss_kj_hjxz", false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A77\u81EA\u5728\u677E\u77F3\u5957\u7F13\u964D\u6548\u679C \u00A7a\u5F00\u542F"), false);
		} else {
			entity.getPersistentData().putBoolean("zzss_kj_hjxz", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A77\u81EA\u5728\u677E\u77F3\u5957\u7F13\u964D\u6548\u679C \u00A7c\u5173\u95ED"), false);
		}
	}
}