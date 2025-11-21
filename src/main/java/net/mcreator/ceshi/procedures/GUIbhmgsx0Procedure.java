package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUIbhmgsx0Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack i = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (GUIbhmgsxhs1Procedure.execute(entity)) {
				a = 0;
				for (int index0 = 0; index0 < 3; index0++) {
					if (!world.isClientSide() && world.getServer() != null) {
						for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("primogemcraft:qqyjin")))
								.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
							i = itemstackiterator;
							if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
								ItemStack _setstack3 = i.copy();
								_setstack3.setCount(i.getCount());
								_menu.getSlots().get((int) a).set(_setstack3);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					a = a + 1;
				}
			}
		}
	}
}