package net.per.curio;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

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
        //三八面骰
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
            return lottery(odds, ok, ()->{});
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
            playAudio("primogemcraft:qiwusunhuai066");
            curio.shrink(1);
        }

        public void announce(String s){
            if (!player.level().isClientSide())
                player.displayClientMessage(Component.literal(s), false);
        }

        private void playAudio(String s) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse(s)), SoundSource.PLAYERS, 1, 1);
                }
            }
        }

        public boolean spawnTable(String lootTableId, Integer times) {
            if (world.isClientSide() || !(world instanceof ServerLevel _level)) return false;
            int generateTimes = (times != null && times > 0) ? times : 1;
            Vec3 pos = player.position();
            CommandSourceStack source = new CommandSourceStack(CommandSource.NULL, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput();
            for (int i = 0; i < generateTimes; i++) {
                String command = String.format("loot spawn %.2f %.2f %.2f loot %s", pos.x, pos.y, pos.z, lootTableId);
                _level.getServer().getCommands().performPrefixedCommand(source, command);
            }
            return true;
        }

        public boolean spawnTable(String lootTableId) {
            return spawnTable(lootTableId, null);
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
