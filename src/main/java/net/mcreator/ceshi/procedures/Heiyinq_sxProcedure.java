package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.EntityTypeTags;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Heiyinq_sxProcedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		Entity e1 = null;
		double a = 0;
		a = HSjinglianupProcedure.execute(sourceentity, itemstack);
		if (entity.getType().is(EntityTypeTags.UNDEAD)) {
			e1 = entity;
			XsfHSProcedure.execute(itemstack, true, false, 0.4 + 0.2 * a, "");
			if (!(sourceentity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				if (e1 instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.JINGU, (int) (40 + 20 * a), 1, false, false));
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			}
		} else {
			XsfHSProcedure.execute(itemstack, false, false, -1, "");
		}
	}
}