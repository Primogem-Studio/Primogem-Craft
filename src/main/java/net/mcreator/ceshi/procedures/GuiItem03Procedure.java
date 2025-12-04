package net.mcreator.ceshi.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.ceshi.world.inventory.GUIqiwuxuanzeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.Map;

public class GuiItem03Procedure {
    private final Player player;
    private final ItemStack[] items;
    private final int[] counts;

    private GuiItem03Procedure(Player player, ItemStack[] items, int[] counts) {
        this.player = player;
        this.items = items;
        this.counts = counts;
    }

    /**
     * 设置GUI物品
     */
    public void setGuiItems() {
        if (items[0] == null) return;
        if (items[1] == null) items[1] = items[0];
        if (items[2] == null) items[2] = items[0];

        for (int i = 0; i < 3; i++) {
            ItemStack itemCopy = items[i].copy();
            itemCopy.setCount(counts[i]);
            GUIitemProcedure.execute(player, itemCopy, i);
        }
    }

    /**
     * 打开GUI界面
     */
    public void openUI(LevelAccessor world) {
        if (player instanceof ServerPlayer serverPlayer) {
            BlockPos pos = BlockPos.containing(player.getX(), player.getY(), player.getZ());
            serverPlayer.openMenu(new SimpleMenuProvider("GUIqiwuxuanze", pos), pos);
        }
    }

    /**
     * 设置物品并打开GUI（一步完成）
     */
    public void setAndOpen(LevelAccessor world) {
        openUI(world);
        setGuiItems();
    }

    /**
     * 使用单个物品和三个数量创建
     */
    public static GuiItem03Procedure withSingleItem(Entity entity, ItemStack item, int count1, int count2, int count3) {
        Player player = (Player) entity;
        ItemStack[] items = new ItemStack[]{item, item.copy(), item.copy()};
        int[] counts = new int[]{count1, count2, count3};
        return new GuiItem03Procedure(player, items, counts);
    }

    /**
     * 使用三个物品和对应的数量创建
     */
    public static GuiItem03Procedure withThreeItems(Entity entity,
                                                    ItemStack item1, int count1,
                                                    ItemStack item2, int count2,
                                                    ItemStack item3, int count3) {
        Player player = (Player) entity;
        ItemStack[] items = new ItemStack[]{item1, item2, item3};
        int[] counts = new int[]{count1, count2, count3};
        return new GuiItem03Procedure(player, items, counts);
    }

    /**
     * 快速设置并打开GUI（单个物品）
     */
    public static void quickOpen(Entity entity, LevelAccessor world, ItemStack item, int count1, int count2, int count3) {
        withSingleItem(entity, item, count1, count2, count3).setAndOpen(world);
    }

    /**
     * 快速设置并打开GUI（三个物品）
     */
    public static void quickOpen(Entity entity, LevelAccessor world,
                                 ItemStack item1, int count1,
                                 ItemStack item2, int count2,
                                 ItemStack item3, int count3) {
        withThreeItems(entity, item1, count1, item2, count2, item3, count3).setAndOpen(world);
    }

    /**
     * MenuProvider实现
     */
    private static class SimpleMenuProvider implements MenuProvider {
        private final String title;
        private final BlockPos pos;

        public SimpleMenuProvider(String title, BlockPos pos) {
            this.title = title;
            this.pos = pos;
        }

        @Override
        public Component getDisplayName() {
            return Component.literal(title);
        }

        @Override
        public boolean shouldTriggerClientSideContainerClosingOnOpen() {
            return false;
        }

        @Override
        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
            return new GUIqiwuxuanzeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
        }
    }
}