package net.mcreator.ceshi.procedures;

import it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleOpenHashMap;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class YsqhsxProcedure {
    public static void process(List<ItemStack> items, Entity entity) {
        var result = new Int2DoubleOpenHashMap();
        for (var item : items) process(item, result);
        for (var entry : result.int2DoubleEntrySet()) {
            PrimogemcraftMod.LOGGER.info("ys{} 的结果输出: {}", entry.getIntKey(), entry.getDoubleValue());
            var zhi = entry.getDoubleValue();
            switch (entry.getIntKey()) {
                case 1 -> YstzsxOProcedure.feng(entity, zhi);
                case 2 -> YstzsxOProcedure.yan(entity, zhi);
                case 3 -> YstzsxOProcedure.lei(entity, zhi);
                case 4 -> YstzsxOProcedure.cao(entity, zhi);
                case 5 -> YstzsxOProcedure.shui(entity, zhi);
                case 6 -> YstzsxOProcedure.huo(entity, zhi);
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