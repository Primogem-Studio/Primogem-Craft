package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.g;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class Ceshi_3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		Entity e = null;
		boolean o1 = false;
		o1 = world instanceof ServerLevel _level0 && _level0.isVillage(BlockPos.containing(x, y, z));
		e = entity;
		EventGroupProcedure.execute(world, entity, 20);//为实体打开20号事件组
		java.util.List<Integer> g = net.mcreator.ceshi.procedures.EventGroupProcedure.getRegisteredGroupIds();
		System.out.println(g);//这两行不管！！
	}
}