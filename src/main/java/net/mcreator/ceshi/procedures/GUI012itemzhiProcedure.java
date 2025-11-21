package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUI012itemzhiProcedure {
	public static void execute(Entity entity, double zhi) {
		if (entity == null)
			return;
		ItemStack i = ItemStack.EMPTY;
		i = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) zhi).getItem() : ItemStack.EMPTY);
		if (entity instanceof Player _player) {
			ItemStack _setstack = i.copy();
			_setstack.setCount(i.getCount());
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		for (int index0 = 0; index0 < 3; index0++) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				_menu.getSlots().get((int) index0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		entity.getPersistentData().putDouble("pgc_qiwuxuanze", 0);
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}