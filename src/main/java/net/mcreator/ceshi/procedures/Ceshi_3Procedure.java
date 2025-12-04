package net.mcreator.ceshi.procedures;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Ceshi_3Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		Entity e = null;
		boolean o1 = false;
		boolean w = false;
		stack = itemstack;
		e = (Player) entity;
		o1 = world.isClientSide();

		GuiItem03Procedure.quickOpen(entity, world, new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()),1,2,3);
//		EventGroupProcedure.execute(world, entity, (int) 15);
	}
}