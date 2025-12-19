package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.CustomAPI;
import net.hackermdch.pgc.CustomComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.per.wish.SpawnWishiEntity;
import net.per.wish.WishVale;

public class Ceshi_3Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		Entity e = null;
		boolean o1 = false;
		boolean w = false;
		double ceshi_01 = 0;
		double a = 0;
		double n = 0;
		stack = itemstack;
		e = entity;
		o1 = world.isClientSide();
		n = Math.random();
//		new SpawnWishiEntity.Spawn(world,(Player) entity,1000,10000,false).Spawn();
	}
}