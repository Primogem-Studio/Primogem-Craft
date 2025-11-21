package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUIitemstackProcedure {
	public static ItemStack execute(Entity entity, double zhi) {
		if (entity == null)
			return ItemStack.EMPTY;
		return entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) zhi).getItem() : ItemStack.EMPTY;
	}
}