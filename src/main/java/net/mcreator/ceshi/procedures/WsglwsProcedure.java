package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

public class WsglwsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getPersistentData().getBoolean("guan_zi_po_huai")) {
				entity.getPersistentData().putBoolean("guan_zi_po_huai", false);
				if (HSqwwsnProcedure.execute(world, x, y, z, entity, ItemStack.EMPTY, itemstack, false, true, 0, 1, "loot spawn ~ ~ ~ loot primogemcraft:blocks/daguanzi", itemstack.getDisplayName().getString(),
						"loot spawn ~ ~ ~ loot primogemcraft:blocks/xiaoguanzi")) {
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, (entity.getPersistentData().getDouble("guan_zi_x")), (entity.getPersistentData().getDouble("guan_zi_y")), (entity.getPersistentData().getDouble("guan_zi_z")),
									(int) (Mth.nextDouble(RandomSource.create(), 2, (entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0) * 0.05))));
					}
				}
			}
		}
	}
}