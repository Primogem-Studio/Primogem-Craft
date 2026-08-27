package net.AI;

import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = "primogemcraft", value = Dist.CLIENT)
public class LivingItemClient {
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PrimogemcraftModEntities.LIVING_ITEM.get(), LivingItemRenderer::new);
	}
}
