package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.CustomComponents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class Ysrq_sx_0Procedure {
    public static void execute(LevelAccessor world, ItemStack itemstack) {
        if (world.isClientSide()) return;
        var name = "";
        String desc;
        if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("qidong")) {
            var str = "§6获得相当于8点套装值且受火漆影响的";
            var a = Mth.nextInt(RandomSource.create(), 0, 6);
            desc = switch (a) {
                case 0 -> {
                    name = "§2元素熔珠";
                    yield "§2风元素熔珠" + "\n" + str + "\n" + "§6缓降和跳跃提升效果，同时也可永久飞行" + "\n" + "§5药水效果可通过§b原石工艺 风属性效果§5按键配置";
                }
                case 1 -> {
                    name = "§6元素熔珠";
                    yield "§6岩元素熔珠" + "\n" + str + "\n" + "§6抗性提升和伤害吸收效果";
                }
                case 2 -> {
                    name = "§d元素熔珠";
                    yield "§d雷元素熔珠" + "\n" + str + "\n" + "§6雨天加成和雷元素剑加成";
                }
                case 3 -> {
                    name = "§a元素熔珠";
                    yield "§a草元素熔珠" + "\n" + str + "\n" + "§6饱和和生命提升效果";
                }
                case 4 -> {
                    name = "§9元素熔珠";
                    yield "§9水元素熔珠" + "\n" + str + "\n" + "§6潮涌能量和间歇回复生命值效果";
                }
                case 5 -> {
                    name = "§c元素熔珠";
                    yield "§c火元素熔珠" + "\n" + str + "\n" + "§6抗火和反伤效果";
                }
                case 6 -> {
                    name = "§b元素熔珠";
                    yield "§b冰元素熔珠" + "\n" + str + "\n" + "§6冰元素附着和冻伤治疗效果";
                }
                default -> "";
            };
            itemstack.set(CustomComponents.ELEMENT_TYPE, a + 1);
            itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(name));
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> {
                tag.putString("ms", desc);
                tag.putBoolean("qidong", true);
            });
        }
        if (itemstack.getOrDefault(CustomComponents.ELEMENT_TYPE, 0) == 1)
            itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).update(tag -> tag.putBoolean("feng_teshu", !tag.getBoolean("feng_teshu")));
    }
}