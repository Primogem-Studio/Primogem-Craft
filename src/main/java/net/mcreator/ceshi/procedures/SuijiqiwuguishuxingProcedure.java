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

public class SuijiqiwuguishuxingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
				&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
				&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			ShijianguanbiProcedure.execute(entity);
		} else {
			if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
					&& getAmountInGUISlot(entity, 3) >= 16) {
				if (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.QWXYZQ.get()))) {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(3).remove(13);
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(3).remove(16);
						_player.containerMenu.broadcastChanges();
					}
				}
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
				if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
					b = Mth.nextInt(RandomSource.create(), 0, 2);
					if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
						b = Mth.nextInt(RandomSource.create(), 0, 2);
						if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get((int) b).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
								b = 0;
							} else {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
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
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					c = 0;
				} else {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
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
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
			ItemStack stack = _menu.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}