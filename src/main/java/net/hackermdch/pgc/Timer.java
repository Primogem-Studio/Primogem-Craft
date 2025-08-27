package net.hackermdch.pgc;

import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(modid = MODID)
public class Timer {
    private static final Map<Entity, Map<String, Timer>> map = new HashMap<>();
    private int tick;

    private Timer(int tick) {
        this.tick = tick;
    }

    public static void set(Entity entity, String name, int tick) {
        if (!map.containsKey(entity)) map.put(entity, new HashMap<>());
        var timers = map.get(entity);
        timers.put(name, new Timer(tick));
    }

    public static boolean isDone(Entity entity, String name) {
        if (!map.containsKey(entity)) return true;
        var timers = map.get(entity);
        if (!timers.containsKey(name)) return true;
        return timers.get(name).tick <= 0;
    }

    @SubscribeEvent
    private static void onTick(ServerTickEvent.Post event) {
        var actions = new ArrayList<Runnable>();
        for (var entry : map.values()) {
            for (var timer : entry.entrySet()) {
                var key = timer.getKey();
                var value = timer.getValue();
                value.tick--;
                if (value.tick <= 0) actions.add(() -> entry.remove(key));
            }
        }
        actions.forEach(Runnable::run);
    }
}
