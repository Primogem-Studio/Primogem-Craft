package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.Timer;
import net.hackermdch.pgc.interfaces.IPlayerExt;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class YstzsxOProcedure {
    public static void feng(Player player, double zhi) {
        var flag = player.getPersistentData().getBoolean("zzss_kj_hjxz");
        var b = hasEntityInInventory(player, PrimogemcraftModItems.HQFENG.toStack()) ? zhi + zhi * 0.25 : zhi;
        if (b >= 2 && !flag) addEffect(player, MobEffects.SLOW_FALLING, 100, (int) (b * 0.5 - 1), true, false);
        if (b >= 4) addEffect(player, MobEffects.JUMP, 100, (int) (b + 2), true, false);
    }

    public static void yan(Player player, double zhi) {
        var c = hasEntityInInventory(player, PrimogemcraftModItems.HQYAN.toStack()) ? zhi + zhi * 0.25 : zhi;
        if (c >= 2) {
            addEffect(player, MobEffects.DAMAGE_RESISTANCE, 100, (int) (c - 7), true, false);
        }
        if (c >= 4 && !(player.hasEffect(PrimogemcraftModMobEffects.XISHOULENGQUE)) && !(player.hasEffect(MobEffects.ABSORPTION))) {
            addEffect(player, MobEffects.ABSORPTION, 900, (int) (c * 0.5 - 1), true, false);
            addEffect(player, PrimogemcraftModMobEffects.XISHOULENGQUE, 900, 0, false, false);
        }
    }

    public static void lei(Player player, double zhi) {
        var d = hasEntityInInventory(player, PrimogemcraftModItems.HQLEI.toStack()) ? zhi + zhi * 0.25 : zhi;
        if (d >= 2 && player.hasEffect(PrimogemcraftModMobEffects.GOUYU)) {
            addEffect(player, MobEffects.DAMAGE_RESISTANCE, 60, (int) (d - 6), true, false);
        }
        if (d >= 4 && player.isInWaterRainOrBubble()) {
            addEffect(player, MobEffects.DAMAGE_BOOST, 60, (int) (d * 0.5 - 2), true, false);
            addEffect(player, MobEffects.MOVEMENT_SPEED, 60, (int) (d * 0.5 - 3), true, false);
        }
    }

    public static void cao(Player player, double zhi) {
        var a = hasEntityInInventory(player, PrimogemcraftModItems.HQCAO.toStack()) ? zhi + zhi * 0.25 : zhi;
        player.getPersistentData().putDouble("qysx_a", a);
        if (a >= 2 && Timer.isDone(player, "cys_02")) {
            Timer.set(player, "cys_02", 400 - (int) a * 2);
            addEffect(player, MobEffects.SATURATION, 10, 0, true, false);
        }
        if (a >= 4)
            player.forceAddEffect(new MobEffectInstance(PrimogemcraftModMobEffects.CYST, -1, (int) (a - 1), false, false), null);
    }

    public static void shui(Player player, double zhi) {
        var e = hasEntityInInventory(player, PrimogemcraftModItems.HQSHUI.toStack()) ? zhi + zhi * 0.25 : zhi;
        if (e >= 2) {
            addEffect(player, MobEffects.CONDUIT_POWER, 80, 0, true, false);
        }
        if (!player.hasEffect(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI) && player.isAlive()) {
            if (e >= 4) {
                if (e < 6) {
                    var a1 = e * 20;
                    player.setHealth((float) (player.getHealth() + player.getMaxHealth() * e * 0.5 * 0.02));
                    addEffect(player, PrimogemcraftModMobEffects.DJQJKJXGXIANZHI, (int) a1, 0, false, false);
                } else {
                    var b1 = e * 20 * 0.5;
                    player.setHealth((float) (player.getHealth() + player.getMaxHealth() * e * 0.5 * 0.03));
                    addEffect(player, PrimogemcraftModMobEffects.DJQJKJXGXIANZHI, (int) b1, 0, false, false);
                }
            }
        }
    }

    public static void huo(Player player, double zhi) {
        var f = hasEntityInInventory(player, PrimogemcraftModItems.HQHUO.toStack()) ? zhi + zhi * 0.25 : zhi;
        if (f >= 2) {
            addEffect(player, MobEffects.FIRE_RESISTANCE, 80, 0, true, false);
        }
        if (f >= 4) {
            addEffect(player, PrimogemcraftModMobEffects.RYKJXG, 60, (int) Math.round(f - 1), false, false);
        }
        var effect = player.getEffect(PrimogemcraftModMobEffects.RYKJXG);
        if (effect != null && effect.getAmplifier() != Math.round(f - 1)) {
            player.removeEffect(PrimogemcraftModMobEffects.RYKJXG);
        }
    }

    public static void bing(Player player, double zhi) {
        var x = hasEntityInInventory(player, PrimogemcraftModItems.HQBING.toStack()) ? zhi + zhi * 0.25 : zhi;
        if (x >= 2) addEffect(player, PrimogemcraftModMobEffects.BNXXU, 60, (int) ((x - 1) * 0.5), true, false);
        if (x >= 4) addEffect(player, PrimogemcraftModMobEffects.XXUFS, 60, (int) ((x - 1) * 0.5), true, false);
        ((IPlayerExt) player).pgc$setWalkSnow(x >= 2);
    }

    private static void addEffect(LivingEntity entity, Holder<MobEffect> effect, int duration, int amplifier, boolean ambient, boolean visible) {
        entity.addEffect(new MobEffectInstance(effect, duration, amplifier, ambient, visible));
    }

    private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
        if (entity instanceof Player player)
            return player.getInventory().contains(stack -> ItemStack.isSameItem(stack, itemstack));
        return false;
    }
}
