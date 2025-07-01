package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Jdsbcf0sxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (Jdsbcfhs0Procedure.execute(world, x, y, z, entity, itemstack)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.JDSBCF_0XG);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.JDSBCF_0XG, -1, 0, false, false));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
		}
	}
}