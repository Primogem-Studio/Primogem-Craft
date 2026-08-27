package net.ai;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;

@EventBusSubscriber(modid = "primogemcraft")
public class LivingItemEvents {
	@SubscribeEvent
	public static void onPickup(ItemEntityPickupEvent.Post event) {
		if (event.getItemEntity() instanceof LivingItemDrop drop) {
			drop.setInvulnerable(false);
		}
	}

	@SubscribeEvent
	public static void onOwnerAttack(AttackEntityEvent event) {
		Player owner = event.getEntity();
		if (owner == null || owner.level().isClientSide) {
			return;
		}
		List<LivingItemEntity> items = LivingItemAPI.collectAll(owner);
		for (LivingItemEntity entity : items) {
			entity.onOwnerAttack(event.getTarget());
		}
	}

	@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		if (event.getLevel().isClientSide) {
			return;
		}
		if (event.getHand() != InteractionHand.MAIN_HAND) {
			return;
		}
		if (!(event.getTarget() instanceof LivingItemEntity entity)) {
			return;
		}
		Player player = event.getEntity();
		if (!player.isCrouching() || !player.getMainHandItem().isEmpty()) {
			return;
		}
		if (entity.getOwnerUuid() == null || !entity.getOwnerUuid().equals(player.getUUID())) {
			return;
		}
		entity.revertByOwner();
		event.setCanceled(true);
		event.setCancellationResult(InteractionResult.SUCCESS);
	}
}
