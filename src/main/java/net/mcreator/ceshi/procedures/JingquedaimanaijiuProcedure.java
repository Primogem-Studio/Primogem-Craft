package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class JingquedaimanaijiuProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == PrimogemcraftModItems.JINGQUEYOUYADAIMA.get()) {
					if (!(sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.JINGQUEDAIMA))) {
						sourceentity.getPersistentData().putBoolean("daima4_naijiu", true);
					} else {
						if (Math.random() < 0.75) {
							if (sourceentity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.MOVEMENT_SPEED)) {
								if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getDuration() : 0) > 200) {
									sourceentity.getPersistentData().putDouble("jingquedaima_dengji",
											(sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0));
									sourceentity.getPersistentData().putDouble("jingquedaima_shijian",
											(sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getDuration() : 0));
									if (sourceentity instanceof LivingEntity _entity)
										_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) (sourceentity.getPersistentData().getDouble("jingquedaima_shijian") * 0.1),
												(int) (sourceentity.getPersistentData().getDouble("jingquedaima_dengji") + 1)));
									sourceentity.getPersistentData().putBoolean("jingquedaima_dengji", false);
									sourceentity.getPersistentData().putBoolean("jingquedaima_shijian", false);
								} else {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,
												sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getDuration() : 0,
												(int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) + 1)));
								}
							} else {
								if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0));
							}
						}
					}
				}
			}
		}
	}
}
