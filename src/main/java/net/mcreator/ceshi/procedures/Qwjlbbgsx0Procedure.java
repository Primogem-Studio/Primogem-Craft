package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.PrimogemcraftMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Qwjlbbgsx0Procedure {
	@SubscribeEvent
	public static void onPickupXP(PlayerXpEvent.PickupXp event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack b = ItemStack.EMPTY;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.QWJLBBGSX_2) && !world.isClientSide()) {
			entity.getPersistentData().putDouble("tcptbg_0", DiaoyongjisuanjingyanzhiProcedure.execute(entity));
			PrimogemcraftMod.queueServerWork(1, () -> {
				entity.getPersistentData().putDouble("tcptbg_1", DiaoyongjisuanjingyanzhiProcedure.execute(entity));
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) (entity.getPersistentData().getDouble("tcptbg_1") - entity.getPersistentData().getDouble("tcptbg_0")));
			});
		}
	}
}