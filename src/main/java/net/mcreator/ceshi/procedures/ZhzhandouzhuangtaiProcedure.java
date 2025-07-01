package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ZhzhandouzhuangtaiProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.ZHANDOUZHUANGTAI)) {
			if (Math.random() < 0.5) {
				if (Math.random() < 0.25) {
					if (!(entity == sourceentity)) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0, false, false));
					}
					if (!(entity == immediatesourceentity)) {
						if (immediatesourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0, false, false));
					}
				} else if (Math.random() < 0.25) {
					if (!(entity == sourceentity)) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2, false, false));
					}
					if (!(entity == immediatesourceentity)) {
						if (immediatesourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2, false, false));
					}
				} else if (Math.random() < 0.25) {
					if (!(entity == sourceentity)) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 2, false, false));
					}
					if (!(entity == immediatesourceentity)) {
						if (immediatesourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 2, false, false));
					}
				} else {
					if (!(entity == sourceentity)) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 2, false, false));
					}
					if (!(entity == immediatesourceentity)) {
						if (immediatesourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 2, false, false));
					}
				}
			}
		}
	}
}