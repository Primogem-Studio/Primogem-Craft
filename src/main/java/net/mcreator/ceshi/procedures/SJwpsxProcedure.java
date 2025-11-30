package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SJwpsxProcedure {
	@SubscribeEvent
	public static void onPickup(ItemEntityPickupEvent.Pre event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getItemEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		Entity e = null;
		double aa = 0;
		String s1 = "";
		if (!world.isClientSide()) {
			a = (itemstack.copy());
			s1 = BuiltInRegistries.ITEM.getKey(a.getItem()).toString();
			switch (s1) {
				case "primogemcraft:sh_jwupin" -> {
					Shijian_it_sxProcedure.execute(itemstack);
					if (net.hackermdch.pgc.Timer.isDone(entity, "shijian")) {
						net.hackermdch.pgc.Timer.set(entity, "shijian", 60);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7c\u6F5C\u884C\u6765\u62FE\u53D6\u4E8B\u4EF6\uFF01\uFF01"), false);
					}
					if (event instanceof ItemEntityPickupEvent.Pre _event)
						_event.setCanPickup(TriState.FALSE);
					if (entity.isShiftKeyDown()) {
						e = entity;
						aa = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_zu_i");
						EventGroupProcedure.execute(world, entity, (int) aa);
						itemstack.shrink(1);
					} else if (!(entity instanceof ServerPlayer _plr10 && _plr10.level() instanceof ServerLevel
							&& _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:jdshijian_0"))).isDone())) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u6F5C\u884C\u4EE5\u62FE\u53D6\u4E8B\u4EF6\uFF01"), false);
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:jdshijian_0"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
					break;
				}
				case "primogemcraft:eventitem" -> {
					if (event instanceof ItemEntityPickupEvent.Pre _event)
						_event.setCanPickup(TriState.FALSE);
					aa = a.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");
					if (aa > 0 && Event_item_sxRProcedure.execute(world, entity, a)) {
						itemstack.shrink(1);
					}
					if (event instanceof ItemEntityPickupEvent.Pre _event)
						_event.setCanPickup(TriState.TRUE);
					break;
				}
				case "primogemcraft:jdsbcf_0" -> {
					Jdsbcf0sxProcedure.execute(world, x, y, z, entity, itemstack);
					break;
				}
				case "primogemcraft:jdsbcf_1" -> {
					Jdsbcf1sxProcedure.execute(world, x, y, z, entity, itemstack);
					break;
				}
				case "primogemcraft:jdsbcf_2" -> {
					Jdsbcf2sxProcedure.execute(world, x, y, z, entity, itemstack);
					break;
				}
			}
		}
	}
}