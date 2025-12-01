package net.mcreator.ceshi.event;

import io.netty.buffer.Unpooled;
import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class Event {
    private final int id;
    private final Player player;
    private final LevelAccessor world;
    private final ItemStack stack;

    public Event(int id, Entity player, LevelAccessor world) {
        this.id = id;
        this.player = (Player) player;
        this.world = world;
        this.stack = new ItemStack(PrimogemcraftModItems.EVENTITEM.get());
    }

    public boolean use(boolean logic) {
        if (logic) return true;

        return noUse();
    }

    public boolean comItem(ItemStack item, int value) {
        ItemStack i = item;
        int z = 0;
        if (player.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
            for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
                ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
                if (itemstackiterator.getItem() == i.getItem())
                    z = z + itemstackiterator.getCount();
            }
        }
        if (z >= value) {
            if (player instanceof Player _player) {
                ItemStack _stktoremove = new ItemStack(i.getItem());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) value, _player.inventoryMenu.getCraftSlots());
            }
            return true;
        }
        return false;
    }

    public boolean openEnchantGui(int value) {
        player.getPersistentData().putDouble("pgc_shijian_fumo_pinzhi", value);
        PrimogemcraftMod.queueServerWork(1, () -> {
            if (player instanceof ServerPlayer _ent) {
                BlockPos _bpos = BlockPos.containing(player.getX(), player.getY(), player.getZ());
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
        return true;
    }

    public boolean noUse() {
        Player entity = player;
        if (Timer.isDone(entity, "Event_Tri")) {
            Timer.set(entity, "Event_Tri", 100);
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("§c条件不足"), false);
        }
        return false;
    }
}
