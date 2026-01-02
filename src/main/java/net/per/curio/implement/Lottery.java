package net.per.curio.implement;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.per.curio.CurioEffectPGC;

public class Lottery {
    public static void register(IEventBus eventBus) {
        eventBus.register(Lottery.class);
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        System.out.println("aaa");
        Player player = event.getPlayer();
        if (player == null) return;
        ItemStack curioItem = getCurioItemFromPlayer(player);
        if (curioItem.isEmpty()) return;
        CurioEffectPGC.Processor processor = new CurioEffectPGC.Processor(event.getLevel(), player, curioItem);


        processor.lottery(0.5,
                () -> {
                    processor.spawnTable("minecraft:chests/simple_dungeon");
                    processor.announce("§a饰品效果触发：发现了宝藏！");
                },
                () -> {
                    processor.announce("§c饰品效果失败，并发生了损耗。");
                }
        );
    }

    private static ItemStack getCurioItemFromPlayer(Player player) {
        return player instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY;
    }
}