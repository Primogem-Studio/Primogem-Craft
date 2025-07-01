package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Suijidaima_shijianProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu
						? _menu.getSlots().get(Mth.nextInt(RandomSource.create(), 0, 2)).getItem()
						: ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(1).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(2).remove(1);
				_player.containerMenu.broadcastChanges();
			}
		} else {
			if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
				if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				a = Mth.nextInt(RandomSource.create(), 0, 2);
				if (Math.random() < 0.5) {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.JINGQUEYOUYADAIMA.get()).copy();
						_setstack.setCount(1);
						_menu.getSlots().get((int) a).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.LUANQIBAZAODEDAIMA.get()).copy();
						_setstack.setCount(1);
						_menu.getSlots().get((int) a).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
				b = Mth.nextInt(RandomSource.create(), 0, 2);
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					b = b;
				} else {
					b = Mth.nextInt(RandomSource.create(), 0, 2);
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						b = b;
					} else {
						b = Mth.nextInt(RandomSource.create(), 0, 2);
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							b = b;
						} else {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
								b = 0;
							} else {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
									b = 1;
								} else {
									b = 2;
								}
							}
						}
					}
				}
				if (Math.random() < 0.5) {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.YOUDIANQIQIAODEDAIMA.get()).copy();
						_setstack.setCount(1);
						_menu.getSlots().get((int) b).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.WUXIANDIGUIDEDAIMA.get()).copy();
						_setstack.setCount(1);
						_menu.getSlots().get((int) b).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					c = 0;
				} else {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						c = 1;
					} else {
						c = 2;
					}
				}
				if (Math.random() < 0.5) {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.MEIYOUZHUSHIDAIMA.get()).copy();
						_setstack.setCount(1);
						_menu.getSlots().get((int) c).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.ZHONGGUIZHONGJUDEDAIMA.get()).copy();
						_setstack.setCount(1);
						_menu.getSlots().get((int) c).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}
}