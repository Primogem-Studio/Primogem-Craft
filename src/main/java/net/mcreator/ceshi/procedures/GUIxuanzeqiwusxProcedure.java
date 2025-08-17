package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class GUIxuanzeqiwusxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		if (!world.isClientSide()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if (entity.getPersistentData().getDouble("pgc_qiwuxuanze") == 1) {
					a = Mth.nextInt(RandomSource.create(), 0, 2);
					if (!world.isClientSide() && world.getServer() != null) {
						for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("primogemcraft:entities/heitaqiwu_01")))
								.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
							if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
								ItemStack _setstack = itemstackiterator.copy();
								_setstack.setCount(1);
								_menu.getSlots().get((int) a).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					b = Mth.nextInt(RandomSource.create(), 0, 2);
					if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
						b = Mth.nextInt(RandomSource.create(), 0, 2);
						if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR
								.asItem())) {
							b = Mth.nextInt(RandomSource.create(), 0, 2);
							if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR
									.asItem())) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR
										.asItem()) {
									b = 0;
								} else {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR
											.asItem()) {
										b = 1;
									} else {
										b = 2;
									}
								}
							} else {
								b = b;
							}
						} else {
							b = b;
						}
					} else {
						b = b;
					}
					if (!world.isClientSide() && world.getServer() != null) {
						for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("primogemcraft:entities/heitaqiwu_02")))
								.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
							if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
								ItemStack _setstack = itemstackiterator.copy();
								_setstack.setCount(1);
								_menu.getSlots().get((int) b).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						c = 0;
					} else {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							c = 1;
						} else {
							c = 2;
						}
					}
					if (!world.isClientSide() && world.getServer() != null) {
						for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("primogemcraft:entities/heitaqiwu_03")))
								.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
							if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
								ItemStack _setstack = itemstackiterator.copy();
								_setstack.setCount(1);
								_menu.getSlots().get((int) c).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				} else if (entity.getPersistentData().getDouble("pgc_qiwuxuanze") == 2) {
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
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						b = b;
					} else {
						b = Mth.nextInt(RandomSource.create(), 0, 2);
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu43 ? _menu43.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							b = b;
						} else {
							b = Mth.nextInt(RandomSource.create(), 0, 2);
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR
									.asItem()) {
								b = b;
							} else {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR
										.asItem()) {
									b = 0;
								} else {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR
											.asItem()) {
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
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						c = 0;
					} else {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
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
}