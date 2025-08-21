package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;
import static net.mcreator.ceshi.init.PrimogemcraftModItems.*;

@OnlyIn(Dist.CLIENT)
public class ForgeCategory implements DisplayCategory<ForgeDisplay> {
    @Override
    public CategoryIdentifier<? extends ForgeDisplay> getCategoryIdentifier() {
        return PGCPlugin.FORGE;
    }

    @Override
    public List<Widget> setupDisplay(ForgeDisplay display, Rectangle bounds) {
        var widgets = ImmutableList.<Widget>builder();
        var startPoint = new Point(bounds.getCenterX() - 44, bounds.getCenterY());
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createSlot(new Point(startPoint.x - 9, startPoint.y - 20)).entries(EntryIngredients.ofItemTag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", "wuqi")))).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 34, startPoint.y - 38)).entries(EntryIngredients.ofItemTag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", "wuqi")))).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 52, startPoint.y - 38)).entries(EntryIngredients.of(TEZHIDIEYINGQI)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 70, startPoint.y - 38)).entries(EntryIngredients.of(TEZHIDIEYINGQI)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 88, startPoint.y - 38)).entries(EntryIngredients.of(TEZHIDIEYINGQI)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 34, startPoint.y)).entries(EntryIngredients.of(MYZJ)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 52, startPoint.y)).entries(EntryIngredients.of(JLZA)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 70, startPoint.y)).entries(EntryIngredients.of(JLLIANG)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 88, startPoint.y)).entries(EntryIngredients.of(JLMO)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 26, startPoint.y + 34)).entries(EntryIngredients.of(JHSB_0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 44, startPoint.y + 34)).entries(EntryIngredients.of(JHSB_1)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 62, startPoint.y + 34)).entries(EntryIngredients.of(JHSB_2)).markInput());
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x, startPoint.y + 38, 8, 8), Component.translatable("rei.pgc.tooltip.forge.title").withStyle(ChatFormatting.GOLD), Component.translatable("rei.pgc.tooltip.forge.1").withStyle(ChatFormatting.GRAY), Component.translatable("rei.pgc.tooltip.forge.2").withStyle(ChatFormatting.GRAY), Component.translatable("rei.pgc.tooltip.forge.3").withStyle(ChatFormatting.GRAY), Component.translatable("rei.pgc.tooltip.forge.4").withStyle(ChatFormatting.RED, ChatFormatting.BOLD)));
        widgets.add(Widgets.createTexturedWidget(ResourceLocation.fromNamespaceAndPath(MODID, "textures/item/xuzhi.png"), startPoint.x, startPoint.y + 38, 7, 0, 8, 8, 9, 9, 16, 16));
        return widgets.build();
    }

    @Override
    public Component getTitle() {
        return Component.translatable("rei.category.pgc.forge");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(MYZJ);
    }

    @Override
    public int getDisplayHeight() {
        return 120;
    }
}
