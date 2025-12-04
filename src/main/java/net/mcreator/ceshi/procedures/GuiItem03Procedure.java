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
import org.w3c.dom.Entity;

import java.util.Map;

public class GuiItem03Procedure {
    private final Player player;
    private final ItemStack item1;
    private final ItemStack item2;
    private final ItemStack item3;
    private final int i1;
    private final int i2;
    private final int i3;

    public GuiItem03Procedure(Entity entity, ItemStack item1, int i1, ItemStack item2, int i2, ItemStack item3, int i3) {
        this.player = (Player) entity;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
    }

    public void setGuiItem() {

        ItemStack item01 = item1;
        ItemStack item02 = item2;
        ItemStack item03 = item3;

        Map<Integer, Integer> intitemmap = Map.of(0, i1, 1, i2, 2, i3);

        if (item2 == null || item3 == null) {
            if (item1 == null) return;
            else item02 = item1;
            item03 = item1;
        }
        Map<Integer, ItemStack> itemmap = Map.of(0, item01, 1, item02, 2, item3);

        for (int f = 0; f < 3; f++) {
            itemmap.get(f).setCount(intitemmap.get(f));
            GUIitemProcedure.execute(player, itemmap.get(f), f);
        }
    }

    public void openUI(LevelAccessor world) {
        if (player instanceof ServerPlayer _ent) {
            BlockPos _bpos = BlockPos.containing((player).getX(), player.getY(), player.getZ());
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
    }

    public static void giveItemGui(Entity entity, LevelAccessor world, ItemStack item1, int i1, int i2, int i3) {
        new GuiItem03Procedure(entity, item1, i1, null, i2, null, i3);
    }
}
