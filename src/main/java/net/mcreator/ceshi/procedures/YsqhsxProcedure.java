//package net.mcreator.ceshi.procedures;
//
//import net.minecraft.core.component.DataComponents;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.component.CustomData;
//
//public class YsqhsxProcedure {
//    public static void execute(ItemStack i) {
//        var trim = i.get(DataComponents.TRIM);
//        if (trim == null) return;
//        var m = trim.material().getRegisteredName();
//        var p = trim.pattern().getRegisteredName();
//        var y = switch (m) {
//            case "primogemcraft:ys_feng" -> 1;
//            case "primogemcraft:ys_yan" -> 2;
//            case "primogemcraft:ys_lei" -> 3;
//            case "primogemcraft:ys_cao" -> 4;
//            case "primogemcraft:ys_shui" -> 5;
//            case "primogemcraft:ys_huo" -> 6;
//            case "primogemcraft:ys_bing" -> 7;
//            case "primogemcraft:yuanshi" -> 8;
//            default -> 0;
//        };
//        var mb = switch (p) {
//            case "primogemcraft:yuansu_0" -> 1;
//            case "primogemcraft:yuansu_1" -> 2;
//            case "primogemcraft:yuansu_2" -> 3;
//            default -> 0;
//        };
//
//        NBTmb(i, y, "Ys");
//        NBTmb(i, mb, "mb");
//    }
//
//    public static void NBTmb(ItemStack item, int zhi, String wen) {
//        CustomData.update(DataComponents.CUSTOM_DATA, item, tag -> tag.putDouble("pgc_" + wen, zhi));
//    }
//}
// 下边是AI写的！！，我只是提供了思路，我的在上面注释
package net.mcreator.ceshi.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class YsqhsxProcedure {

    // 处理单个栏位的函数
    public static Map<Integer, Double> processSlot(ItemStack item) {
        Map<Integer, Double> result = new HashMap<>();

        var trim = item.get(DataComponents.TRIM);
        if (trim == null) return result;

        var m = trim.material().getRegisteredName();
        var p = trim.pattern().getRegisteredName();

        var y = switch (m) {
            case "primogemcraft:ys_feng" -> 1;
            case "primogemcraft:ys_yan" -> 2;
            case "primogemcraft:ys_lei" -> 3;
            case "primogemcraft:ys_cao" -> 4;
            case "primogemcraft:ys_shui" -> 5;
            case "primogemcraft:ys_huo" -> 6;
            case "primogemcraft:ys_bing" -> 7;
            case "primogemcraft:yuanshi" -> 8;
            case "minecraft:quartz" -> 9;
            default -> 0;
        };

        // 更新 mb 值为小数
        var mb = switch (p) {
            case "primogemcraft:yuansu_0" -> 0.5;
            case "primogemcraft:yuansu_1" -> 1.0;
            case "primogemcraft:yuansu_2" -> 2.0;
            default -> 0.25; // 默认值改为 0.25
        };

        if (y != 0 && mb != 0) {
            result.put(y, mb);
        }

        return result;
    }

    // 处理四个栏位的主函数
    public static void execute(ItemStack slotA, ItemStack slotB, ItemStack slotC, ItemStack slotD) {
        Map<Integer, Double> ysTotals = new HashMap<>();

        // 处理所有栏位
        processSlotData(slotA, ysTotals);
        processSlotData(slotB, ysTotals);
        processSlotData(slotC, ysTotals);
        processSlotData(slotD, ysTotals);

        // 输出结果
        for (Map.Entry<Integer, Double> entry : ysTotals.entrySet()) {
            System.out.println("ys" + entry.getKey() + " 的结果输出: " + entry.getValue());
            // 这里你可以根据需要进行其他操作，比如设置NBT、发送消息等
        }
    }

    // 处理单个栏位数据并累加
    private static void processSlotData(ItemStack item, Map<Integer, Double> totals) {
        if (item == null) return;

        var trim = item.get(DataComponents.TRIM);
        if (trim == null) return;

        var m = trim.material().getRegisteredName();
        var p = trim.pattern().getRegisteredName();

        var y = switch (m) {
            case "primogemcraft:ys_feng" -> 1;
            case "primogemcraft:ys_yan" -> 2;
            case "primogemcraft:ys_lei" -> 3;
            case "primogemcraft:ys_cao" -> 4;
            case "primogemcraft:ys_shui" -> 5;
            case "primogemcraft:ys_huo" -> 6;
            case "primogemcraft:ys_bing" -> 7;
            case "primogemcraft:yuanshi" -> 8;
            case "minecraft:quartz" -> 9;
            default -> 0;
        };

        // 更新 mb 值为小数
        var mb = switch (p) {
            case "primogemcraft:yuansu_0" -> 0.5;
            case "primogemcraft:yuansu_1" -> 1.0;
            case "primogemcraft:yuansu_2" -> 2.0;
            default -> 0.25; // 默认值改为 0.25
        };

        if (y != 0) {
            totals.put(y, totals.getOrDefault(y, 0.0) + mb);
        }
    }
}