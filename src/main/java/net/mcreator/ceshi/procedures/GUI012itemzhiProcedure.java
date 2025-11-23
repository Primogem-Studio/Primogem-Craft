package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUI012itemzhiProcedure {
	public static void execute(LevelAccessor world, Entity entity, double zhi) {
		if (entity == null)
			return;
		ItemStack i = ItemStack.EMPTY;
		i = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) zhi).getItem() : ItemStack.EMPTY);
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), i);
			entityToSpawn.setPickUpDelay(0);
			_level.addFreshEntity(entityToSpawn);
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