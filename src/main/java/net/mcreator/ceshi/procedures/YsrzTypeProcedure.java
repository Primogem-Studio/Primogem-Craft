package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.CustomComponents;
import net.minecraft.world.item.ItemStack;

public class YsrzTypeProcedure {
    public static double execute(ItemStack itemstack) {
        return itemstack.getOrDefault(CustomComponents.ELEMENT_TYPE, 0);
    }
}