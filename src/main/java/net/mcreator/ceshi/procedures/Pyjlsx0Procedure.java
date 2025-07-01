package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class Pyjlsx0Procedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (!(sourceentity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((float) Math.ceil((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.01));
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (160 - 20 * HSjinglianupProcedure.execute(sourceentity, itemstack)));
			}
		}
	}
}