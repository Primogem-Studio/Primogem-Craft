package net.per.curio;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

import java.util.HashSet;

public class CurioEffectPGC {
    public static class Processor {
        private final LevelAccessor world;
        private final Player player;

        public Processor(LevelAccessor world, Entity entity) {
            this.world = world;
            this.player = (Player) entity;
        }

        public double curioDice(ItemPredicate condition) {
            double out = 0;
            var set = new HashSet<Item>();
            player.getInventory().items.forEach(itemstack -> {
                if (set.contains(itemstack.getItem())) return;
                if (condition.test(itemstack)) {
                    set.add(itemstack.getItem());
                    itemstack.shrink(1);
                }
            });
            out = set.size();
            return out;
        }

        @FunctionalInterface
        public interface ItemPredicate {
            boolean test(ItemStack itemstack);
        }
    }

    public boolean isInAnyCurioDiceTag(ItemStack curio) {
        return isInAnyCurioDiceTag(curio, "c:curio", "c:curio/bad");
    }

    public boolean isInAnyCurioDiceTag(ItemStack fusioncurio, boolean fusion) {
        return isInAnyCurioDiceTag(fusioncurio, "c:curio", "c:curio/normal/fusion/s", "c:curio/normal/fusion/a", "c:curio/normal/fusion/b");
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
