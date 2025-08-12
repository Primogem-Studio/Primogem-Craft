package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class FtkxsxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean o1 = false;
		String s1 = "";
		if (entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
			s1 = "\u00A7a\u542F\u7528";
			o1 = false;
		} else {
			s1 = "\u00A7c\u7981\u7528";
			o1 = true;
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A77\u81EA\u5728\u677E\u77F3\u5957\u7F13\u964D\u6548\u679C " + s1)), false);
		entity.getPersistentData().putBoolean("zzss_kj_hjxz", o1);
	}
}