package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUIbhmgsxhs0Procedure {
	public static boolean execute(Entity entity, double zhi) {
		if (entity == null)
			return false;
		return (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get((int) zhi).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem();
	}
}