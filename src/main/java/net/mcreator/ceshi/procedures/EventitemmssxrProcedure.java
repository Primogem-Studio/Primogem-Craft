package net.mcreator.ceshi.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public class EventitemmssxrProcedure {
    //定义“事件“中的描述
    public static String execute(ItemStack itemstack) {
        double a = 0;
        String s1 = "";
        a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");
        String sR1 = "§c§l立即触发§a//§d§l右键触发" + "\n" + "\n";
        s1 = switch ((int) a) {
            case 1 -> yuzhou_fumo_1(10, "§7低级");
            case 2 -> yuzhou_fumo_1(20, "§7低级§e~§b中级");
            case 3 -> yuzhou_fumo_1(40, "§d中级§e~§c特级");
            case 4 -> yuzhou_fumo_2("20%", "§7低级");
            case 5 -> yuzhou_fumo_2("70%", "§b中级");
            case 6 -> yuzhou_fumo_2("95%", "§6高级") + "\n" + "§e消耗§b20§e宇宙碎片";
            case 7 -> QiWu("§7低级", "");
            case 8 -> QiWu("§b中级", "");
            case 9 -> QiWu("§6高级", "");
            case 10 -> QiWu("§7低级", "§d融合");
            case 11 -> QiWu("§b中级", "§d融合");
            case 12 -> QiWu("§6高级", "§d融合");
            case 13 -> Fumo("§7低级");
            case 14 -> Fumo("§b中级");
            case 15 -> Fumo("§6高级");
            case 16 -> Fumo("§c特级");
            default -> "什么事件都没有...";
        };
        return sR1 + s1;
    }

    public static String yuzhou_fumo(String s) {
        return "§e换取" + s + "§e附魔" + "\n";
    }

    public static String yuzhou_fumo_1(int zhi, String s) {
        return yuzhou_fumo(s) + "§e消耗§b" + zhi + "§e宇宙碎片";
    }

    public static String yuzhou_fumo_2(String bai, String s) {
        return yuzhou_fumo(s) + "§e消耗§b" + bai + "§e生命值";
    }

    public static String QiWu(String qw, String Rh) {
        return "§e获得一个" + qw + "§e级别" + Rh + "§e奇物";
    }

    public static String Fumo(String fm) {
        return "§e获得一个" + fm + "§e级别附魔";
    }
}