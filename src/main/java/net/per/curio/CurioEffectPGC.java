package net.per.curio;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.HashSet;
import java.util.function.Supplier;

public class CurioEffectPGC {
    public static class Processor {
        private final LevelAccessor world;
        private final Player player;
        private final ItemStack curio;

        public Processor(LevelAccessor world, Entity entity,ItemStack curio) {
            this.world = world;
            this.player = (Player) entity;
            this.curio = curio;
        }

        public boolean getRandomResult(double value) {
            return !world.isClientSide() ? Math.random() < value : false;
        }

        public LevelAccessor getWorld() {return world;}

        public Player getPlayer() {return player;}

        public ItemStack getCurio(){return curio;}

        public double curioDice(boolean remove, ItemPredicate condition) {
            double out = 0;
            var set = new HashSet<Item>();
            player.getInventory().items.forEach(itemstack -> {
                if (set.contains(itemstack.getItem())) return;
                if (condition.test(itemstack)) {
                    set.add(itemstack.getItem());
                    if (remove) itemstack.shrink(1);
                }
            });
            out = set.size();
            return out;
        }

        @FunctionalInterface
        public interface ItemPredicate {
            boolean test(ItemStack itemstack);
        }

        //乐透
        public boolean lottery(double odds, Runnable ok) {
            return lottery(odds, ok, null);
        }

        public boolean lottery(double odds, Runnable ok, Runnable err) {
            if (!getRandomResult(0.3)) return false;
            boolean result = getRandomResult(odds);
            if (result) {ok.run();} else {
                err.run();
                announceCurioBroken();
            }
            return result;
        }
        /**
         * 工具
        */
        public void announceCurioBroken() {
            if (curio.isDamageableItem() && curio.getDamageValue() > curio.getMaxDamage() - 1)
                curio.hurtAndBreak(1, player, null);
            announce(curio.getDisplayName().getString() + "§c已损坏！");
            playAudio();
            curio.shrink(1);
        }

        public void announce(String s){
            if (!player.level().isClientSide())
                player.displayClientMessage(Component.literal(s), false);
        }

        private void playAudio() {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1);
                }
            }
        }
    }


    public boolean isInAnyCurioDiceTag(ItemStack itemstack, String... tagNames) {
        for (String tagName : tagNames) {
            if (itemstack.is(ItemTags.create(ResourceLocation.parse(tagName)))) {
                return true;
            }
        }
        return false;
    }
}
