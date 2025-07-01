package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;
import net.mcreator.ceshi.PrimogemcraftMod;

public class Szqsx2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("shengzhangqiao_geiguole")) {
			if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQCAO.get())) ? 0.015 : 0.01)) {
				if (Math.random() < 0.5) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PrimogemcraftModBlocks.CAOYUANSUECI.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					PrimogemcraftMod.queueServerWork(2, () -> {
						world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.CAOYUANSUECI.get().defaultBlockState(), 3);
					});
				}
			}
		} else {
			PrimogemcraftMod.queueServerWork(2, () -> {
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.CAOYUANSUECI.get().defaultBlockState(), 3);
			});
			{
				final String _tagName = "shengzhangqiao_geiguole";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}