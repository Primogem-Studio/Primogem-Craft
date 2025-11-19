package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DuiyoubianjiqiProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.isShiftKeyDown() && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:kebianjiduiyou")))) {
			if (entity.getPersistentData().getBoolean((sourceentity.getDisplayName().getString() + "ceshi_duiyou"))) {
				entity.getPersistentData().putBoolean((sourceentity.getDisplayName().getString() + "ceshi_duiyou"), false);
				if (world instanceof ServerLevel _level) {
					_level.getServer().getPlayerList()
							.broadcastSystemMessage(Component.literal((("\u73A9\u5BB6<" + sourceentity.getDisplayName().getString() + ">") + "\u5BF9" + entity.getDisplayName().getString() + "\u00A7c\u53D6\u6D88\u4E86\u961F\u53CB")), false);
				}
			} else {
				entity.getPersistentData().putBoolean((sourceentity.getDisplayName().getString() + "ceshi_duiyou"), true);
				if (world instanceof ServerLevel _level) {
					_level.getServer().getPlayerList()
							.broadcastSystemMessage(Component.literal((("\u73A9\u5BB6<" + sourceentity.getDisplayName().getString() + ">") + "\u5BF9" + entity.getDisplayName().getString() + "\u00A7a\u6DFB\u52A0\u4E86\u961F\u53CB")), false);
				}
			}
		}
	}
}