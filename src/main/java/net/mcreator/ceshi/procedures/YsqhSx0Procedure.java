package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.Timer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class YsqhSx0Procedure {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        var player = event.getEntity();
        if (!player.level().isClientSide && Timer.isDone(player, "ysqh")) {
            Timer.set(player, "ysqh", 10);
            YsqhsxProcedure.process(player.getInventory().armor,player);
        }
    }
}