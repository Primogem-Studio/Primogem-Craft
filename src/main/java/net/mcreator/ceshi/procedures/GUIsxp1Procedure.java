package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUIsxp1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("GUI_yzsp_sl", (entity.getPersistentData().getDouble("GUI_yzsp_sl") + 1));
		if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "cunzhe_shuliang", (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("GUI_yzsp_sl"))), true);
	}
}