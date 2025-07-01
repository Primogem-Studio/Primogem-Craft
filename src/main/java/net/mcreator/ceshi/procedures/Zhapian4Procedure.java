package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Zhapian4Procedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("zhapianshufu")) {
			entity.getPersistentData().putBoolean("zhapianshufu", false);
		}
		if (entity.getPersistentData().getBoolean("letouchaxun_lengque")) {
			entity.getPersistentData().putBoolean("letouchaxun_lengque", false);
		}
	}
}