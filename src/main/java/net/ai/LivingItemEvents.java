package net.ai;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;

@EventBusSubscriber(modid = "primogemcraft")
public class LivingItemEvents {
	@SubscribeEvent
	public static void onPickup(ItemEntityPickupEvent.Post event) {
		if (event.getItemEntity() instanceof LivingItemDrop drop) {
			drop.setInvulnerable(false);
		}
	}
}
