package net.per.curio.implement;

import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.procedures.DiamondlotteryjdProcedure;
import net.mcreator.ceshi.procedures.QwhydltsxProcedure;
import net.mcreator.ceshi.procedures.XjdltsxProcedure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
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
        if (curioItem.isEmpty() || !Timer.isDone(player, "lottery")) return;
        Timer.set(player, "lottery", 5);
        if (!curioItem.is(ItemTags.create(ResourceLocation.parse("c:curio")))) return;
        CurioEffectPGC.Processor processor = new CurioEffectPGC.Processor(event.getLevel(), player, curioItem);
        effect(processor);
    }

    private static Map<Item, Consumer<CurioEffectPGC.Processor>> effectMap;

    private static Map<Item, Consumer<CurioEffectPGC.Processor>> getEffectMap() {
        if (effectMap == null) {
            effectMap = new HashMap<>();
            effectMap.put(PrimogemcraftModItems.YIYINHEDALETOU.get(), cp ->
                    cp.lottery(0.4,
                            () -> {
                                cp.getTool().giveTagLootItem("primogemcraft:entities/qqiwuzhanlipinshiti");
                                cp.announce("§a获得随机奇物");
                            },
                            () -> {
                                cp.getPlayer().setHealth((float) 1);
                                cp.setplayerFood(0.98);
                            }
                    ));
            effectMap.put(PrimogemcraftModItems.XINGJIDALETOU.get(), cp ->
                    cp.lottery(0.5,
                            () -> {
                                if (XjdltsxProcedure.execute(cp.getWorld(), cp.getPlayer()))
                                    cp.announce("§a获得随机附魔！");
                            },
                            () -> {
                                int xp = cp.getPlayer().experienceLevel;
                                cp.announce(("§9并且，移除了§a" + new java.text.DecimalFormat("##.##").format(xp) + "§9级经验等级！"));
                                cp.getPlayer().giveExperienceLevels(-(xp));
                            }
                    ));
            effectMap.put(PrimogemcraftModItems.QWLZDLT.get(), cp ->
                    cp.lottery(0.2,
                            () -> {
                                cp.getTool().giveItem(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()),40);
                                cp.announce("§a获得宇宙碎片！");
                            },
                            () -> {
                                cp.getTool().giveTagLootItem(true, "c:curio/negative");
                                cp.announce("§c获得负面奇物！");
                            }
                    ));
            effectMap.put(PrimogemcraftModItems.QWYHJB.get(), cp ->
                    cp.lottery(0.8,
                            () -> {
                                cp.getTool().giveTagLootItem(true,"c:curio/normal/b");
                                cp.announce("§a获得奇物！");
                            },
                            () -> {
                                cp.getPlayer().setHealth((float) 1);
                            }
                    ));
            effectMap.put(PrimogemcraftModItems.QWXYDLT.get(), cp ->
                    cp.lottery(0.2,
                            () -> {
                                int a = cp.getRandomInt(1,5);
                                cp.getTool().giveItem(cp.getRandomResult(0.7) ? new ItemStack(PrimogemcraftModItems.JLLIANG.get()) : new ItemStack(PrimogemcraftModItems.JLMO.get()),a);
                                cp.announce("§a获得强化材料！");
                            },()->{}
                    ));
            effectMap.put(PrimogemcraftModItems.QWHYDLT.get(), cp ->
                    cp.lottery(0,()->{},
                            () -> {
                                QwhydltsxProcedure.execute(cp.getWorld(),cp.getPlayer().getX(),cp.getPlayer().getY(),cp.getPlayer().getZ(),cp.getPlayer());
                            }
                    ));
            effectMap.put(PrimogemcraftModItems.DIAMONDLOTTERY.get(), cp ->
                    cp.lottery(0.5,
                            () -> {
                                int a = cp.getRandomInt(1,10);
                                if (cp.getRandomResult(0.006)){DiamondlotteryjdProcedure.execute(cp.getPlayer());a=648;}
                                cp.getTool().giveItem(new ItemStack(Items.DIAMOND),a);
                                cp.announce("§a获得钻石！");
                            },()->{
                                cp.getPlayer().setHealth((float) 1);
                                cp.setplayerFood(0.98);
                            }
                    ));
        }
        return effectMap;
    }

    private static void effect(CurioEffectPGC.Processor cp) {
        Consumer<CurioEffectPGC.Processor> effect = getEffectMap().get(cp.getCurio().getItem());
        if (effect != null) effect.accept(cp);
    }
}