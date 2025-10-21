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
                tooltip.add(Component.literal("按住").withStyle(ChatFormatting.GRAY).append(Component.literal("Shift").withStyle(ChatFormatting.GRAY)).append(Component.literal("查看套装值效果")));
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.literal("2x 获得永久羽坠效果").withColor(0x42E7B5));
                    tooltip.add(Component.literal("4x 获得永久跳跃提升效果").withColor(0x42E7B5));
                }
            }
            case "primogemcraft:ys_yan" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("按住").withStyle(ChatFormatting.GRAY).append(Component.literal("Shift").withStyle(ChatFormatting.GRAY)).append(Component.literal("查看套装值效果")));
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.literal("2x 获得永久抗性提升效果").withColor(0xFFB705));
                    tooltip.add(Component.literal("4x 间歇获得伤害吸收效果").withColor(0xFFB705));
                }
            }
            case "primogemcraft:ys_lei" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("按住").withStyle(ChatFormatting.GRAY).append(Component.literal("Shift").withStyle(ChatFormatting.GRAY)).append(Component.literal("查看套装值效果")));
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.literal("2x 勾玉状态下获得高额抗性提升").withColor(0xCA80FD));
                    tooltip.add(Component.literal("4x 雨或雷雨天获得 力量 速度").withColor(0xCA80FD));
                }
            }
            case "primogemcraft:ys_cao" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("按住").withStyle(ChatFormatting.GRAY).append(Component.literal("Shift").withStyle(ChatFormatting.GRAY)).append(Component.literal("查看套装值效果")));
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.literal("2x 间歇性提供饱和效果").withColor(0x9FFF35));
                    tooltip.add(Component.literal("4x 生命值上限大幅提升").withColor(0x9FFF35));
                }
            }
            case "primogemcraft:ys_shui" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("按住").withStyle(ChatFormatting.GRAY).append(Component.literal("Shift").withStyle(ChatFormatting.GRAY)).append(Component.literal("查看套装值效果")));
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.literal("2x 提供永久潮涌核心效果").withColor(0x3431FF));
                    tooltip.add(Component.literal("4x 间歇性恢复生命值").withColor(0x3431FF));
                }
            }
            case "primogemcraft:ys_huo" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("按住").withStyle(ChatFormatting.GRAY).append(Component.literal("Shift").withStyle(ChatFormatting.GRAY)).append(Component.literal("查看套装值效果")));
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.literal("2x 提供永久抗火效果").withColor(0xF4634E));
                    tooltip.add(Component.literal("4x 对攻击你的目标施加熔岩伤害和燃烧").withColor(0xF4634E));
                }
            }
            case "primogemcraft:ys_bing" -> {
                tooltip.add(Component.empty());
                tooltip.add(Component.literal("按住").withStyle(ChatFormatting.GRAY).append(Component.literal("Shift").withStyle(ChatFormatting.GRAY)).append(Component.literal("查看套装值效果")));
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.literal("2x 获得保暖细雪效果").withColor(0x35FEFC));
                    tooltip.add(Component.literal("4x 获得细雪反噬效果").withColor(0x35FEFC));
                    tooltip.add(Component.literal("按住").withColor(0xFECCFF).append(Component.literal("[Ctrl]").withColor(0xFECCFF)).append(Component.literal("查看详细")));
                    if (Screen.hasControlDown()) {
                        tooltip.add(Component.literal("保暖细雪").withColor(0x35FEFC));
                        tooltip.add(Component.literal("§7免疫细雪，且存在细雪中时恢复生命值，受套装值影响，当走出细雪时会对低于3级效果的玩家造成伤害，否则恢复生命值").withColor(0x7F7F7F));
                        tooltip.add(Component.literal("细雪反噬").withColor(0x35FEFC));
                        tooltip.add(Component.literal("§7攻击处于这个效果影响下的玩家时，攻击者会受到高额持续冰冻伤害").withColor(0x7F7F7F));
                    }
                }
            }
        }
        return tooltip;
    }
}
