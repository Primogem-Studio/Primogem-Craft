package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUIxuanzeqiwuguanbiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
					&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
					&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
				if (Math.random() < 0.35) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY));
						entityToSpawn.setPickUpDelay(0);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					if (Math.random() < 0.3) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY));
							entityToSpawn.setPickUpDelay(0);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
					} else {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(2).getItem() : ItemStack.EMPTY));
							entityToSpawn.setPickUpDelay(0);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
				entity.getPersistentData().putDouble("pgc_qiwuxuanze", 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
	}
}