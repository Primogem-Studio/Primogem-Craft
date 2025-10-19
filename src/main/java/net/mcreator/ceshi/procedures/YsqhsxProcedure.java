package net.mcreator.ceshi.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;

public class YsqhsxProcedure {
    public static void execute(ItemStack item) {
        var trim = item.get(DataComponents.TRIM);
        if (trim == null) return;
        var m = trim.material().getRegisteredName();
        var p = trim.pattern().getRegisteredName();
        if (m.equals("primogemcraft:yuanshi")) {
            System.out.println(0);
        }
        if (p.equals("primogemcraft:yuansu_0")) {
            System.out.println("摩拉模板，默认0");}
    }
}