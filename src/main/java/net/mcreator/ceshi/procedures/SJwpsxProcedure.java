package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.ceshi.world.inventory.SJGUIfumo01Menu;
import net.mcreator.ceshi.world.inventory.SJGUIfumo00Menu;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

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
		if (!world.isClientSide()) {
			a = (itemstack.copy());
			if (a.getItem() == BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:sh_jwupin"))) {
				if (event instanceof ItemEntityPickupEvent.Pre _event)
					_event.setCanPickup(TriState.FALSE);
				if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(PrimogemcraftModMobEffects.SHIJIANBUCHUFA))) {
					if (entity.isShiftKeyDown()) {
						if (a.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("PGC_fumo_shijian_00")) {
							if (entity instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(x, y, z);
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("SJGUIfumo00");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new SJGUIfumo00Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
						if (a.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("PGC_fumo_shijian_01")) {
							if (entity instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(x, y, z);
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("SJGUIfumo01");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new SJGUIfumo01Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
					} else if (!(entity instanceof ServerPlayer _plr11 && _plr11.level() instanceof ServerLevel
							&& _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:jdshijian_0"))).isDone())) {
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
				}
			}
		}
	}
}