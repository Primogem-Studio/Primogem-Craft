package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUIitemProcedure {
	public static void execute(Entity entity, ItemStack itemstack, double zhi) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
			ItemStack _setstack3 = itemstack.copy();
			_setstack3.setCount(itemstack.getCount());
			_menu.getSlots().get((int) zhi).set(_setstack3);
			_player.containerMenu.broadcastChanges();
		}
	}
}