package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class GUItishiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				ItemStack _setstack = new ItemStack(PrimogemcraftModItems.KAIFAQIANGZHI_01.get()).copy();
				_setstack.setCount(1);
				_menu.getSlots().get(4).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}