package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.world.inventory.GUIqiwuxuanzeMenu;
import net.mcreator.ceshi.init.PrimogemcraftModMenus;

import io.netty.buffer.Unpooled;

public class GUIqwxz03Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String _tag) {
		if (entity == null || _tag == null)
			return;
		String tag1 = "";
		ItemStack i1 = ItemStack.EMPTY;
		ItemStack item0 = ItemStack.EMPTY;
		ItemStack item2 = ItemStack.EMPTY;
		ItemStack item1 = ItemStack.EMPTY;
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
		if (!world.isClientSide()) {
			tag1 = "c:curio/" + _tag;
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
				ItemStack _setstack = TagItemProcedure.execute(tag1).copy();
				_setstack.setCount(1);
				_menu.getSlots().get(0).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			i1 = TagItemProcedure.execute(tag1).copy();
			item0 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
			item1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).copy();
			while (i1.getItem() == item0.getItem() || item1.getItem() == Blocks.AIR.asItem()) {
				i1 = TagItemProcedure.execute(tag1).copy();
				if (!(i1.getItem() == item0.getItem())) {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = i1.copy();
						_setstack.setCount(1);
						_menu.getSlots().get(1).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
			item1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(1).getItem() : ItemStack.EMPTY).copy();
			item2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(2).getItem() : ItemStack.EMPTY).copy();
			while (i1.getItem() == item1.getItem() || i1.getItem() == item0.getItem() || item2.getItem() == Blocks.AIR.asItem()) {
				i1 = TagItemProcedure.execute(tag1).copy();
				if (!(i1.getItem() == item1.getItem()) && !(i1.getItem() == item0.getItem())) {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = i1.copy();
						_setstack.setCount(1);
						_menu.getSlots().get(2).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
	}
}