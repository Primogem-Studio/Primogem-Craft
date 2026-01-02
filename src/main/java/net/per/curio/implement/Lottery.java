package net.per.curio.implement;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.per.curio.CurioEffectPGC;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@EventBusSubscriber
public class Lottery {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;
        ItemStack curioItem = player instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY;
        if (curioItem.isEmpty()) return;
        if (!curioItem.is(ItemTags.create(ResourceLocation.parse("c:curio"))))return;
        CurioEffectPGC.Processor processor = new CurioEffectPGC.Processor(event.getLevel(), player, curioItem);
        effect(processor);
    }

    private static Map<Item, Consumer<CurioEffectPGC.Processor>> effectMap;

    private static Map<Item, Consumer<CurioEffectPGC.Processor>> getEffectMap() {
        if (effectMap == null) {
            effectMap = new HashMap<>();
            effectMap.put(PrimogemcraftModItems.QWLZDLT.get(), cp ->
                    cp.lottery(0.5,
                            () -> {
                                cp.spawnTable("minecraft:chests/desert_pyramid");
                                cp.announce("§d遗音河大乐透触发！");
                            },
                            () -> cp.announce("§5遗音河能量消散...")
                    ));
            effectMap.put(PrimogemcraftModItems.QWXYDLT.get(), cp ->
                    cp.lottery(0.5,
                            () -> {
                                cp.spawnTable("minecraft:chests/desert_pyramid");
                                cp.announce("§d遗音河大乐透触发！");
                            },
                            () -> cp.announce("§5遗音河能量消散...")
                    ));
            effectMap.put(PrimogemcraftModItems.QWHYDLT.get(), cp ->
                    cp.lottery(0.5,
                            () -> {
                                cp.spawnTable("minecraft:chests/desert_pyramid");
                                cp.announce("§d遗音河大乐透触发！");
                            },
                            () -> cp.announce("§5遗音河能量消散...")
                    ));
            effectMap.put(PrimogemcraftModItems.YIYINHEDALETOU.get(), cp ->
                    cp.lottery(0.5,
                            () -> {
                                cp.spawnTable("minecraft:chests/desert_pyramid");
                                cp.announce("§d遗音河大乐透触发！");
                            },
                            () -> cp.announce("§5遗音河能量消散...")
                    ));
        }
        return effectMap;
    }

    private static void effect(CurioEffectPGC.Processor cp) {
        Consumer<CurioEffectPGC.Processor> effect = getEffectMap().get(cp.getCurio().getItem());
        if (effect != null) effect.accept(cp);
    }
}