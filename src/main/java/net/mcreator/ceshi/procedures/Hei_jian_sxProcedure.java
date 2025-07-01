package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class Hei_jian_sxProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (!(sourceentity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem())) && !(Math.random() < 0.5)) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
							+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (0.3 + HSjinglianupProcedure.execute(sourceentity, itemstack) * 0.075)));
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
			}
		}
	}
}