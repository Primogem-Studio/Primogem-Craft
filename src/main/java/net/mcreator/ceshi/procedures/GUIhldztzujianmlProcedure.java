package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.CustomComponents;
import net.minecraft.world.item.ItemStack;

public class GUIhldztzujianmlProcedure {
    public static int execute(ItemStack itemstack) {
        return itemstack.getOrDefault(CustomComponents.YSZUJIAN_JIAN, -1);
    }
}
