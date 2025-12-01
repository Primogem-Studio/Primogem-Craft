package net.mcreator.ceshi.procedures;

import net.mcreator.ceshi.event.Event;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class Ceshi_3Procedure {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double ceshi_01 = 0;
        int a = 0;
        ItemStack stack = ItemStack.EMPTY;
        Entity e = null;
        boolean o1 = false;
        boolean w = false;
        stack = itemstack;
        e = entity;
        o1 = world.isClientSide();

        var i = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());

        Event event = new Event(a, e, world);
        if (event.use(event.comItem(i, 20))) event.openEnchantGui(3);
    }
}