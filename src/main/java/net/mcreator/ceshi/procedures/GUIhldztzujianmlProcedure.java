package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.CustomComponents;
import net.minecraft.world.item.ItemStack;

public class GUIhldztzujianmlProcedure {
    public static int execute(ItemStack itemstack) {
        Integer i = itemstack.get(CustomComponents.YSZUJIAN_JIAN);
        if (i == null) return -1;
        return i;
    }
}
