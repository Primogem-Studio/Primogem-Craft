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
        String sR1 = "§c§l立即触发§a//§d§l右键触发" + "\n"+"\n";
        s1 = switch ((int) a) {
            case 1 -> sR1 + yuzhou_fumo_1(10, "§7低级");
            case 2 -> sR1 + yuzhou_fumo_1(20, "§7低级§e~§b中级");
            case 3 -> sR1 + yuzhou_fumo_1(40, "§d中级§e~§c特级");
            case 4 -> sR1 + yuzhou_fumo_2("20%","§7低级");
            case 5 -> sR1 + yuzhou_fumo_2("70%","§b中级");
            case 6 -> sR1 + yuzhou_fumo_2("95%","§6高级")+"\n"+"§e消耗§b20§e宇宙碎片";
            default -> "什么事件都没有...";
        };
        return s1;
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
}