package net.per.curio;

import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.procedures.DadaletoushibiezhuangtaiProcedure;
import net.mcreator.ceshi.procedures.GUIqwxz03Procedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.per.tool.ToolPGC;

import java.util.HashSet;
import java.util.function.Supplier;

public class CurioEffectPGC {
    public static class Processor {
        private final LevelAccessor world;
        private final Player player;
        private final ItemStack curio;
        private final ToolPGC.set set;

        public Processor(LevelAccessor world, Entity entity,ItemStack curio) {
            this.world = world;
            this.player = (Player) entity;
            this.curio = curio;
            this.set = new ToolPGC.set(player,world);
        }
        public ToolPGC.set getTool(){
            return set;
        }

        public boolean getRandomResult(double value) {
            if (world.isClientSide())return false;
            return Math.random() < value;
        }

        public int getRandomInt(int value,int max) {
            return !world.isClientSide() ? Mth.nextInt(RandomSource.create(), value, max) : 0;
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

        /**
         *奇物
         */
        //乐透
        public boolean lottery(double odds, Runnable ok, Runnable err) {
            if (!getRandomResult(getLotteryLuck() ? 0.8 : 0.3)) return false;
            boolean result = getRandomResult((getLotteryLuck() ? Math.min(odds + (odds * 0.2),0.8) : odds));
            if (result) {
                ok.run();
                set.playAudio("entity.firework_rocket.launch");
                if (getRandomResult(0.01)) set.giveItem(new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get()),1);
            } else {
                err.run();
                announceCurioBroken();
                set.giveItem(new ItemStack(PrimogemcraftModItems.SHQWYHDLT.get()),1);
                PrimogemcraftModVariables.PlayerVariables _vars = player.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
                _vars.daletou_jishu++;
                if (_vars.daletou_jishu>=100) DadaletoushibiezhuangtaiProcedure.execute(player);
                _vars.markSyncDirty();
            }
            return result;
        }
        public boolean getLotteryLuck(){
            return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get())));
        }
        /**
         * 工具
        */
        public void announceCurioBroken() {
            if (curio.isDamageableItem() && curio.getDamageValue() > curio.getMaxDamage() - 1)
                curio.hurtAndBreak(1, player, null);
            announce(curio.getDisplayName().getString() + "§c已损坏！");
            set.playAudio("primogemcraft:qiwusunhuai066");
            curio.shrink(1);
        }

        public void announce(String s){
            if (!player.level().isClientSide())
                player.displayClientMessage(Component.literal(s), false);
        }

        public void setplayerFood(double value){
            player.getFoodData().setFoodLevel((int) ((player.getFoodData().getFoodLevel()) - (player.getFoodData().getFoodLevel() * value)));
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
