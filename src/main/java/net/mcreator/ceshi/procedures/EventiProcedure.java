package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class EventiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double zhi) {
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (Math.random() < ((world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZESUIJISHIJIAN)) * 0.01) / 100
					&& PrimogemcraftModVariables.MapVariables.get(world).shijian_xianzhi < (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZESHIJIANXIANZHI))) {
				a = new ItemStack(PrimogemcraftModItems.SH_JWUPIN.get());
				{
					final String _tagName = "event_zu_i";
					final double _tagValue = zhi;
					CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, a);
					entityToSpawn.setPickUpDelay(40);
					_level.addFreshEntity(entityToSpawn);
				}
				PrimogemcraftModVariables.MapVariables.get(world).shijian_xianzhi = PrimogemcraftModVariables.MapVariables.get(world).shijian_xianzhi + 1;
				PrimogemcraftModVariables.MapVariables.get(world).markSyncDirty();
			}
		}
	}
}