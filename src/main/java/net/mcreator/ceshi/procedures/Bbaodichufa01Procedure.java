package net.mcreator.ceshi.procedures;

import net.per.wish.SpawnWishiEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class Bbaodichufa01Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double in = 0;
		if (!world.isClientSide() && !(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			in = entity.isShiftKeyDown() ? itemstack.getCount() : 1;
			new SpawnWishiEntity.Spawn(world, entity, (int) in, in * 10000, false).Spawn();
			itemstack.shrink((int) in);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
		}
	}
}