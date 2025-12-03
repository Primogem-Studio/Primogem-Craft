package net.mcreator.ceshi.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EventitemmssxrProcedure {
    private static final Map<Integer, Supplier<String>> DESCRIPTION_HANDLERS = new HashMap<>();

    static {
        // 注册所有事件描述
        registerDescription(1, () -> yuzhou_fumo_1(10, "§7低级"));
        registerDescription(2, () -> yuzhou_fumo_1(20, "§7低级§e~§b中级"));
        registerDescription(3, () -> yuzhou_fumo_1(40, "§d中级§e~§c特级"));
        registerDescription(4, () -> yuzhou_fumo_2("20%", "§7低级"));
        registerDescription(5, () -> yuzhou_fumo_2("70%", "§b中级"));
        registerDescription(6, () -> yuzhou_fumo_2("95%", "§6高级") + "\n" + "§e消耗§b20§e宇宙碎片");
        registerDescription(7, () -> QiWu("§7低级", ""));
        registerDescription(8, () -> QiWu("§b中级", ""));
        registerDescription(9, () -> QiWu("§6高级", ""));
        registerDescription(10, () -> QiWu("§7低级", "§d融合"));
        registerDescription(11, () -> QiWu("§b中级", "§d融合"));
        registerDescription(12, () -> QiWu("§6高级", "§d融合"));
        registerDescription(13, () -> Fumo("§7低级"));
        registerDescription(14, () -> Fumo("§b中级"));
        registerDescription(15, () -> Fumo("§6高级"));
        registerDescription(16, () -> Fumo("§c特级"));
        registerDescription(17, () -> QiWu("§c负面", ""));
        registerDescription(18, () -> QiWu("§c咕咕钟", ""));
        registerDescription(19, () -> QiWu("§c绝对失败处方", ""));
        registerDescription(20, () -> "§c与一只§e丰饶孽物§c进行战斗" + "\n" + "§c胜利后可选择一个它的战利品" + "\n" + "§d珍贵战利品的概率将提高");
        registerDescription(21, () -> "§e与2只§b弱小§e的丰饶孽物搏斗");
        registerDescription(22, () -> "§e与5只§7普通§e的§7僵尸§e搏斗");
        registerDescription(23, () -> "§e我掉落的是这个§7垃圾桶盖");
        registerDescription(24, () -> "§e我掉落的是这个§b铁制圆形盾牌！");
        registerDescription(25, () -> "§e我掉落的是这个§6华丽的摩拉制盾牌");

    }

    public static void registerDescription(int eventId, Supplier<String> descriptionProvider) {
        DESCRIPTION_HANDLERS.put(eventId, descriptionProvider);
    }

    //定义"事件"中的描述
    public static String execute(ItemStack itemstack) {
        double a = 0;
        String s1 = "";
        a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");
        String sR1 = "§c§l立即触发§a//§d§l右键触发" + "\n" + "§8 #" + new java.text.DecimalFormat("##.##").format(a) + "\n";

        Supplier<String> descriptionProvider = DESCRIPTION_HANDLERS.get((int) a);
        s1 = descriptionProvider != null ? descriptionProvider.get() : "什么事件都没有...";

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