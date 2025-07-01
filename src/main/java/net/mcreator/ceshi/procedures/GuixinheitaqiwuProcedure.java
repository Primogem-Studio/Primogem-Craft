package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.world.inventory.GUIqiwuxuanzeMenu;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

import io.netty.buffer.Unpooled;

public class GuixinheitaqiwuProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		if (!world.isClientSide()) {
			if (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()))) {
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
					for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
						if (itemstackiterator.getItem() == PrimogemcraftModItems.YUZHOUSUIPIAN.get()) {
							a = a + itemstackiterator.getCount();
						}
					}
				}
				if (a >= (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(PrimogemcraftModMobEffects.HTDZ) ? 13 : 16)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(PrimogemcraftModMobEffects.HTDZ) ? 13 : 16),
								_player.inventoryMenu.getCraftSlots());
					}
					entity.getPersistentData().putDouble("pgc_qiwuxuanze", 1);
					if (entity instanceof Player _player)
						_player.closeContainer();
					PrimogemcraftMod.queueServerWork(1, () -> {
						if (entity instanceof ServerPlayer _ent) {
							BlockPos _bpos = BlockPos.containing(x, y, z);
							_ent.openMenu(new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("GUIqiwuxuanze");
								}

								@Override
								public boolean shouldTriggerClientSideContainerClosingOnOpen() {
									return false;
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new GUIqiwuxuanzeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					});
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}