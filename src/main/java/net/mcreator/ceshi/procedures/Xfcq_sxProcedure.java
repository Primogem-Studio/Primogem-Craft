package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class Xfcq_sxProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		double a = 0;
		a = HSjinglianupProcedure.execute(sourceentity, itemstack);
		if (!world.isClientSide()) {
			if (!(sourceentity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				if (Math.random() < 0.6 + 0.1 * a) {
					if (sourceentity instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 6 + 1 * a));
					if (sourceentity instanceof Player _player)
						_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 0.3 + 0.1 * a));
					if (sourceentity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 6 + 1 * a));
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (240 - 30 * a));
				}
			}
		}
	}
}