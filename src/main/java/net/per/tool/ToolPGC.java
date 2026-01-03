package net.per.tool;

import io.netty.buffer.Unpooled;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.procedures.EventGroupProcedure;
import net.mcreator.ceshi.procedures.GUIqwxz03Procedure;
import net.mcreator.ceshi.procedures.SetItemGui;
import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.per.event.EventEntityScopeSpawn;

import java.util.function.Consumer;

public class ToolPGC {
    public static class set {
        private final LevelAccessor world;
        private final Player player;
        private final double x;
        private final double y;
        private final double z;

        public set(Player player, LevelAccessor world) {
            this.world = world;
            this.player = player;
            this.x = player.getX();
            this.y = player.getY();
            this.z = player.getZ();
        }
        /**
         * 发送消息
         */
        public boolean prompt(String message, boolean bottom) {
            if (!player.level().isClientSide())
                player.displayClientMessage(Component.literal(message), bottom);
            return true;
        }
        /**
         * 嵌套事件
         */
        public boolean createSimpleGroup(int event1, int event2, int event3, String neme) {
            GUIqwxz03Procedure.execute(world, player, false, "primogemcraft:event");
            return EventGroupProcedure.createSimpleGroup(player, world, event1, event2, event3, neme);
        }
        //移除指定数量的item
        public boolean costItem(ItemStack item, int value) {
            int total = 0;
            if (player.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable itemHandler) {
                for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
                    ItemStack slotStack = itemHandler.getStackInSlot(slot).copy();
                    if (slotStack.getItem() == item.getItem()) {
                        total += slotStack.getCount();
                    }
                }
            }
            if (total >= value && player != null) {
                ItemStack toRemove = new ItemStack(item.getItem());
                player.getInventory().clearOrCountMatchingItems(p -> toRemove.getItem() == p.getItem(), value, player.inventoryMenu.getCraftSlots());
                return true;
            }
            return false;
        }

        //立即生成物品三选一界面
        public boolean giveTagLootItem(boolean qd, String tag) {
            GUIqwxz03Procedure.execute(world, player, qd, tag);
            return true;
        }

        public boolean giveTagLootItem(String loottable) {
            GUIqwxz03Procedure.execute(world, player, false, loottable);
            return true;
        }

        //打开自定义附魔GUI
        public boolean openEnchGui(int value) {
            int lv = Math.min(value, 4);
            player.getPersistentData().putDouble("pgc_shijian_fumo_pinzhi", lv);
            PrimogemcraftMod.queueServerWork(1, () -> {
                if (player instanceof ServerPlayer serverPlayer) {
                    BlockPos pos = BlockPos.containing(x, y, z);
                    serverPlayer.openMenu(new MenuProvider() {
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
                            return new GUISJfumoMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
                        }
                    }, pos);
                }
            });
            return true;
        }

        //给物品
        public boolean giveItem(ItemStack baseItem, int value, Consumer<ItemStack> itemModifier) {
            ItemStack _setstack = baseItem.copy();
            if (itemModifier != null) {
                itemModifier.accept(_setstack);
            }
            _setstack.setCount(value);
            ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            return true;
        }

        public boolean giveItem(ItemStack baseItem, int value) {
            return giveItem(baseItem, value, null);
        }

        //三物品三值
        public boolean setGuiItem(ItemStack item1, ItemStack item2, ItemStack item3, int count1, int count2, int count3) {
            SetItemGui.quickOpen(player, world, item1, count1, item2, count2, item3, count3);
            return true;
        }

        //单物品三值
        public boolean setGuiItem(ItemStack item1, int count1, int count2, int count3) {
            SetItemGui.quickOpen(player, world, item1, count1, count2, count3);
            return true;
        }

        //单数量Tag或LotTab选择
        public boolean setGuiItem(String tagloot, boolean tag) {
            GUIqwxz03Procedure.execute(world, player, tag, tagloot);
            return true;
        }
        //音频
        public void playAudio(String s) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse(s)), SoundSource.PLAYERS, 1, 1);
                }
            }
        }
    }
}
