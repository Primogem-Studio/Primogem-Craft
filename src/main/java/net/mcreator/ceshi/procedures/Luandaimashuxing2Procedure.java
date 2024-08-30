package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Luandaimashuxing2Procedure {
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
				if (itemstackiterator.getItem() == PrimogemcraftModItems.LUANQIBAZAODEDAIMA.get()) {
					if (!(sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.ZHENGCHANGDAIMA))) {
						sourceentity.getPersistentData().putBoolean("daima1_naijiu", true);
					}
					if (sourceentity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(PrimogemcraftModMobEffects.ZHENGCHANGDAIMA)) {
						if ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 1) {
							if (sourceentity instanceof Player _player)
								_player.getFoodData().setFoodLevel(2);
						} else {
							if (Math.random() < 0.5) {
								if (sourceentity instanceof Player _player)
									_player.getFoodData().setFoodLevel((int) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 1));
							}
						}
					} else {
						if (Math.random() < 0.5) {
							if ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 1) {
								sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.STARVE)), 2);
							} else {
								if (sourceentity instanceof Player _player)
									_player.getFoodData().setFoodLevel((int) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 2));
							}
						}
					}
				}
				if (itemstackiterator.getItem() == PrimogemcraftModItems.YOUDIANQIQIAODEDAIMA.get()) {
					if (!(sourceentity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU))) {
						sourceentity.getPersistentData().putBoolean("daima2_naijiu", true);
					}
				}
			}
		}
	}
}
