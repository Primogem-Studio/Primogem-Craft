package net.mcreator.ceshi.client.overlayer;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
class HpyOverlayer implements LayeredDraw.Layer {
    private static final Component[] com = {Component.literal("◆"), Component.literal("◆◆"), Component.literal("◆◆◆"), Component.literal("◆◆◆◆"), Component.literal("◆◆◆◆◆")};

    @Override
    public void render(GuiGraphics graphics, DeltaTracker deltaTracker) {
        var player = Minecraft.getInstance().player;
        assert player != null;
        var stack = player.getMainHandItem();
        if (stack.getItem() != PrimogemcraftModItems.HPY.get()) return;
        var font = Minecraft.getInstance().font;
        var count = (int) stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j");
        if (count < 1 || count > 5) return;
        var text = com[count - 1];
        var spx = graphics.guiWidth() / 2f - font.width(text) / 2f;
        var spy = graphics.guiHeight() - 39;
        graphics.drawString(font, text, (int) spx, spy, 0x67bef8);
    }
}
