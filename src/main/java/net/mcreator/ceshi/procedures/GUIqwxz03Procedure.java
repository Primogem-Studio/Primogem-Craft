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

import io.netty.buffer.Unpooled;

public class GUIqwxz03Procedure {
	public static void execute(LevelAccessor world, Entity entity, boolean qd, String _tag) {
		if (entity == null || _tag == null)
			return;
		String tag1 = "";
		ItemStack i1 = ItemStack.EMPTY;
		ItemStack item0 = ItemStack.EMPTY;
		ItemStack item2 = ItemStack.EMPTY;
		ItemStack item1 = ItemStack.EMPTY;
		double b = 0;
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
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
			i1 = GUIxuanitemProcedure.execute(world, qd, _tag);
			GUIitemProcedure.execute(entity, i1, 0);
			i1 = GUIxuanitemProcedure.execute(world, qd, _tag);
			item0 = GUIitemstackProcedure.execute(entity, 0);
			item1 = GUIitemstackProcedure.execute(entity, 1);
			while (i1.getItem() == item0.getItem() || item1.getItem() == Blocks.AIR.asItem()) {
				i1 = GUIxuanitemProcedure.execute(world, qd, _tag);
				b = b + 1;
				if (b > 10 || !(i1.getItem() == item0.getItem())) {
					b = 0;
					GUIitemProcedure.execute(entity, i1, 1);
					break;
				}
			}
			item1 = GUIitemstackProcedure.execute(entity, 1);
			item2 = GUIitemstackProcedure.execute(entity, 2);
			while (i1.getItem() == item1.getItem() || i1.getItem() == item0.getItem() || item2.getItem() == Blocks.AIR.asItem()) {
				i1 = GUIxuanitemProcedure.execute(world, qd, _tag);
				b = b + 1;
				if (b > 10 || !(i1.getItem() == item1.getItem()) && !(i1.getItem() == item0.getItem())) {
					GUIitemProcedure.execute(entity, i1, 2);
					break;
				}
			}
		}
	}
}