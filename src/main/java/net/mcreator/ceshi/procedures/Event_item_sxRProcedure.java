package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

import io.netty.buffer.Unpooled;

public class Event_item_sxRProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double ie = 0;
		Entity en = null;
		ItemStack yzsp = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
		en = entity;
		ie = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");
		boolean o1 = switch ((int) ie) {
			case 1 -> shijian_123(entity, 1, yzsp, 10);
			case 2 -> shijian_123(entity, suijiint(world, 1, 3), yzsp, 20);
			case 3 -> shijian_123(entity, suijiint(world, 2, 4), yzsp, 40);
			default -> false;
		};
		if (o1)
			itemstack.shrink(1);
	}

	public static void fumo(Entity entity, int zhi) {
		// 接收对应等级附魔并为实体打开附魔GUI，最大4
		entity.getPersistentData().putDouble("pgc_shijian_fumo_pinzhi", zhi);
		PrimogemcraftMod.queueServerWork(1, () -> {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("GUISJfumo");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new GUISJfumoMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		});
	}

	public static boolean item_zhi_1_1(ItemStack item, int zhi, Entity entity) {
		//移除特定数量的item
		ItemStack i = item;
		int z = 0;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == i.getItem())
					z = z + itemstackiterator.getCount();
			}
		}
		if (z >= zhi) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(i.getItem());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) zhi, _player.inventoryMenu.getCraftSlots());
			}
			return true;
		}
		return false;
	}

	public static boolean shijian_123(Entity entity, int zhi, ItemStack item, int itzhi) {
		//移除 entity 的 itzhi个 item 后打开 zhi 级别的附魔界面
		if (item_zhi_1_1(item, itzhi, entity)) {
			fumo(entity, zhi);
			return true;
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A7c\u6761\u4EF6\u4E0D\u8DB3\uFF01"), false);
		return false;
	}

	public static int suijiint(LevelAccessor world, int zhi, int zhi0) {
		int a = 0;
		if (!world.isClientSide())
			a = Mth.nextInt(RandomSource.create(), zhi, zhi0);
		return a;
	}
}