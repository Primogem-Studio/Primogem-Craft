package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class YskstcqsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		Entity e = null;
		boolean w = false;
		e = entity;
		w = world.isClientSide();
		if (itemstack.getItem() == PrimogemcraftModItems.MLLP.get()) {
			CompasspProcedure.execute(world, (Player) entity, itemstack, "pgc:ketance", 1);
		} else {
			CompasspProcedure.execute(world, (Player) entity, itemstack, "pgc:yuanbankuang", 2);
		}
	}
}