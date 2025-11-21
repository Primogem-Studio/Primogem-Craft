package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class GUIxuanzeqiwuguanbiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double n1 = 0;
		if (!world.isClientSide()) {
			for (int index0 = 0; index0 < 3; index0++) {
				n1 = n1 + (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get((int) index0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR
						.asItem()) ? 1 : 0);
			}
			if (n1 == 3) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(Mth.nextInt(RandomSource.create(), 0, 2)).getItem() : ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
				entity.getPersistentData().putDouble("pgc_qiwuxuanze", 0);
				for (int index1 = 0; index1 < 3; index1++) {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						_menu.getSlots().get((int) index1).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}
}