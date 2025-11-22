package net.mcreator.ceshi.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public class EventitemmssxrProcedure {
    public static String execute(ItemStack itemstack) {
        double a = 0;
        String s1 = "";
        a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");
        String sR1 = "§d右键使用" + "\n";
        s1 = switch ((int) a) {
            case 1 -> sR1 + yuzhou_fumo_1(10, "§7低级");
            case 2 -> sR1 + yuzhou_fumo_1(20, "§7低级§e~§d中级");
            case 3 -> sR1 + yuzhou_fumo_1(40, "§d中级§e~§c特级");
            default -> "什么事件都没有...";
        };
        return s1;
    }

    public static String yuzhou_fumo_1(int zhi, String s) {
        return "§e换取" + s + "§e附魔" + "\n" + "§e消耗§b" + zhi + "§e宇宙碎片";
    }
}