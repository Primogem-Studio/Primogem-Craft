package net.mcreator.ceshi.procedures;

import it.unimi.dsi.fastutil.ints.Int2BooleanMap;
import it.unimi.dsi.fastutil.ints.Int2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleOpenHashMap;
import net.hackermdch.pgc.CustomComponents;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

import java.util.List;

public class YsqhsxProcedure {
    public static void process(List<ItemStack> items, Player player) {
        var result = new Int2DoubleOpenHashMap();
        var map = new Int2BooleanOpenHashMap();
        process(player.getInventory().items, map);
        process(player.getInventory().offhand, map);
        for (var item : items) process(item, result);
        for (var entry : result.int2DoubleEntrySet()) {
            PrimogemcraftMod.LOGGER.info("ys{} 的结果输出: {}", entry.getIntKey(), entry.getDoubleValue());
            var zhi = entry.getDoubleValue();
            var key = entry.getIntKey();
            if (map.get(key)) continue;
            switch (key) {
                case 1 -> YstzsxOProcedure.feng(player, zhi);
                case 2 -> YstzsxOProcedure.yan(player, zhi);
                case 3 -> YstzsxOProcedure.lei(player, zhi);
                case 4 -> YstzsxOProcedure.cao(player, zhi);
                case 5 -> YstzsxOProcedure.shui(player, zhi);
                case 6 -> YstzsxOProcedure.huo(player, zhi);
            }
        }
        for (var entry : map.int2BooleanEntrySet()) {
            switch (entry.getIntKey()) {
                case 1 -> YstzsxOProcedure.feng(player, 8);
                case 2 -> YstzsxOProcedure.yan(player, 8);
                case 3 -> YstzsxOProcedure.lei(player, 8);
                case 4 -> YstzsxOProcedure.cao(player, 8);
                case 5 -> YstzsxOProcedure.shui(player, 8);
                case 6 -> YstzsxOProcedure.huo(player, 8);
            }
        }
        if (!map.get(4)) player.removeEffect(PrimogemcraftModMobEffects.CYST);
    }

    private static void process(List<ItemStack> items, Int2BooleanMap map) {
        for (var item : items) {
            if (!item.is(PrimogemcraftModItems.YSRZ_0)) continue;
            switch (item.getOrDefault(CustomComponents.ELEMENT_TYPE, 0)) {
                case 1 -> {
                    if (!item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("feng_teshu"))
                        map.put(1, true);
                }
                case 2 -> map.put(2, true);
                case 3 -> map.put(3, true);
                case 4 -> map.put(4, true);
                case 5 -> map.put(5, true);
                case 6 -> map.put(6, true);
            }
        }
    }

    private static void process(ItemStack item, Int2DoubleMap totals) {
        var trim = item.get(DataComponents.TRIM);
        if (trim == null) return;
        var y = switch (trim.material().getRegisteredName()) {
            case "primogemcraft:ys_feng" -> 1;
            case "primogemcraft:ys_yan" -> 2;
            case "primogemcraft:ys_lei" -> 3;
            case "primogemcraft:ys_cao" -> 4;
            case "primogemcraft:ys_shui" -> 5;
            case "primogemcraft:ys_huo" -> 6;
            case "primogemcraft:ys_bing" -> 7;
            default -> 0;
        };
        var mb = switch (trim.pattern().getRegisteredName()) {
            case "primogemcraft:yuansu_0" -> 1;
            case "primogemcraft:yuansu_1" -> 1.5;
            case "primogemcraft:yuansu_2", "minecraft:silence" -> 2.0;
            default -> 0.5;
        };
        if (y != 0) totals.put(y, totals.getOrDefault(y, 0.0) + mb);
    }
}