package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class JinyongnangmorenProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		boolean a = false;
		if (world.isClientSide() && world.getLevelData().getGameRules().getBoolean(PrimogemcraftModGameRules.JINYONGNANG)) {
			a = true;
		}
		world.getLevelData().getGameRules().getRule(PrimogemcraftModGameRules.JINYONGNANG).set(a, world.getServer());
	}
}