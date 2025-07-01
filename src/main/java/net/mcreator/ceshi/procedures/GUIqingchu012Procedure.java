package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUIqingchu012Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double n1 = 0;
		for (int index0 = 0; index0 < 3; index0++) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				_menu.getSlots().get((int) n1).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			n1 = n1 + 1;
		}
	}
}