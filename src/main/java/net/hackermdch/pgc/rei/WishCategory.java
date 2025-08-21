package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class WishCategory implements DisplayCategory<WishDisplay> {
    @Override
    public CategoryIdentifier<? extends WishDisplay> getCategoryIdentifier() {
        return PGCPlugin.WISH;
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    public List<Widget> setupDisplay(WishDisplay display, Rectangle bounds) {
        var widgets = ImmutableList.<Widget>builder();
        var startPoint = new Point(bounds.getCenterX(), bounds.getCenterY());
        var entity = display.entityType.create(Minecraft.getInstance().level);
        entity.setCustomName(null);
        entity.setCustomNameVisible(false);
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createDrawableWidget(((graphics, mouseX, mouseY, delta) -> InventoryScreen.renderEntityInInventory(graphics, startPoint.x - 30, startPoint.y - 8, 30, new Vector3f(), new Quaternionf().rotateXYZ(0.3f, Mth.DEG_TO_RAD * ((float) GLFW.glfwGetTime() * 50), 0), new Quaternionf(), entity))));
        widgets.add(Widgets.createArrow(new Point(startPoint.x - 12, startPoint.y - 9)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 20, startPoint.y - 8)).entries(display.getOutputEntries().getFirst()).markOutput());
        return widgets.build();
    }

    @Override
    public Component getTitle() {
        return Component.translatable("rei.category.pgc.wish");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(PrimogemcraftModItems.JIJIUCHANZHIYUAN);
    }

    @Override
    public int getDisplayHeight() {
        return 33;
    }

    @Override
    public int getDisplayWidth(WishDisplay display) {
        return 120;
    }
}
