package net.mcreator.ceshi.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.armortrim.ArmorTrim;

import java.util.ArrayList;
import java.util.List;

public class TrimTooltip {
    public static List<Component> addToTooltip(Player player, ArmorTrim component) {
        var tooltip = new ArrayList<Component>();
        switch (component.material().getRegisteredName()) {
            case "primogemcraft:ys_feng" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("套装效果：").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.literal("2x 获得风效果"));
                tooltip.add(Component.literal("4x 获得效果"));
            }
            case "primogemcraft:ys_yan" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("套装效果：").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.literal("2x 获得岩效果"));
                tooltip.add(Component.literal("4x 获得效果"));
            }
            case "primogemcraft:ys_lei" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("套装效果：").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.literal("2x 获得雷效果"));
                tooltip.add(Component.literal("4x 获得效果"));
            }
            case "primogemcraft:ys_cao" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("套装效果：").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.literal("2x 获得草效果"));
                tooltip.add(Component.literal("4x 获得细雪反噬效果"));
            }
            case "primogemcraft:ys_shui" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("套装效果：").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.literal("2x 获得水效果"));
                tooltip.add(Component.literal("4x 获得效果"));
            }
            case "primogemcraft:ys_huo" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("套装效果：").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.literal("2x 获得火效果"));
                tooltip.add(Component.literal("4x 获得效果"));
            }
            case "primogemcraft:ys_bing" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("套装效果：").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.literal("2x 获得保暖细雪效果").withColor(0xffca18));
                tooltip.add(Component.literal("4x 获得细雪反噬效果").withColor(0xffca18));
                tooltip.add(Component.literal("按住").withStyle(ChatFormatting.GREEN).append(Component.literal("[Shift]").withColor(0xffca18)).append(Component.literal("查看详细")));
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.literal("效果描述").withColor(0xff0000));
                }
            }
        }
        return tooltip;
    }
}
