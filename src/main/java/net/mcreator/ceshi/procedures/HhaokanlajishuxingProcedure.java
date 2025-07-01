package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class HhaokanlajishuxingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 1));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 1));
		if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.LETOUDECHENGFA)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.LETOUDECHENGFA);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(Items.MILK_BUCKET, 1);
		}
	}
}