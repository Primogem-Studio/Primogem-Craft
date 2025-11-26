package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.PrimogemcraftMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EventEntityLootProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity e = null;
		if (!(entity.getPersistentData().getString("Event_Entity_Loot")).equals("")) {
			PrimogemcraftMod.queueServerWork(1, () -> {
				if (!entity.isAlive()) {
					GUIqwxz03Procedure.execute(world, sourceentity, entity.getPersistentData().getBoolean("Event_Entity_Loot_tag"), entity.getPersistentData().getString("Event_Entity_Loot"));
				}
			});
		}
	}
}