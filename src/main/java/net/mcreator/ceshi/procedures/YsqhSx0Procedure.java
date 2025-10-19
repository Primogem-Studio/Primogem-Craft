package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import javax.annotation.Nullable;

import static net.minecraft.world.entity.EquipmentSlot.*;

@EventBusSubscriber
public class YsqhSx0Procedure {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        execute(event, event.getEntity());
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        if (net.hackermdch.pgc.Timer.isDone(entity, "ysqh")) {
            net.hackermdch.pgc.Timer.set(entity,"ysqh",40);
            YsqhsxProcedure.execute(Bw(FEET, entity), Bw(LEGS, entity), Bw(CHEST, entity), Bw(HEAD, entity));
        }
    }

    public static ItemStack Bw(EquipmentSlot bw, Entity entity) {
        return (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(bw) : ItemStack.EMPTY);
    }
}