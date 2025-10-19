package net.mcreator.ceshi.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public class YsqhsxProcedure {
    public static void execute(ItemStack i) {
        var trim = i.get(DataComponents.TRIM);
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
            default -> 0;
        };
        var mb = switch (p) {
            case "primogemcraft:yuansu_0" -> 1;
            case "primogemcraft:yuansu_1" -> 2;
            case "primogemcraft:yuansu_2" -> 3;
            default -> 0;
        };
        NBTmb(i, y, "Ys");
        NBTmb(i, mb, "mb");
    }

    public static void NBTmb(ItemStack item, int zhi, String wen) {
        CustomData.update(DataComponents.CUSTOM_DATA, item, tag -> tag.putDouble("pgc_" + wen, zhi));
    }
}