package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class YstzsxOProcedure {

    public static void main(String[] args) {

    }

    public static void feng(Entity entity, double zhi) {
        var zzss_kj_hjxz = false;
        var b = zhi;
        zzss_kj_hjxz = entity.getPersistentData().getBoolean("zzss_kj_hjxz");
        b = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQFENG.get())) ? zhi + zhi * 0.25 : zhi;
        if (b >= 2 && !zzss_kj_hjxz) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, (int) (b * 0.5 - 1), true, false));
        }
        if (b >= 4) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b + 2), true, false));
        }
    }

    public static void yan(Entity entity, double zhi) {
        var c = zhi;
        c = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQYAN.get())) ? zhi + zhi * 0.25 : zhi;
        if (c >= 2) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, (int) (c - 7), true, false));
        }
        if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(PrimogemcraftModMobEffects.XISHOULENGQUE)) && !(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.ABSORPTION))) {
            if (c >= 4) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 900, (int) (c * 0.5 - 1), true, false));
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.XISHOULENGQUE, 900, 0, false, false));
            }
        }
    }

    public static void lei(Entity entity, double zhi) {
        var d = zhi;
        d = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQLEI.get())) ? zhi + zhi * 0.25 : zhi;
        if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(PrimogemcraftModMobEffects.GOUYU)) {
            if (d >= 2) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, (int) (d - 6), true, false));
            }
        }
        if (entity.isInWaterRainOrBubble()) {
            if (d >= 4) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, (int) (d * 0.5 - 2), true, false));
            }
            if (d >= 4) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, (int) (d * 0.5 - 3), true, false));
            }
        }
    }

    public static void cao(Entity entity, double zhi) {
        var a = zhi;
        a = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQCAO.get())) ? zhi + zhi * 0.25 : zhi;
        entity.getPersistentData().putDouble("qysx_a", a);
        if (a >= 2) {
            if (Timer.isDone(entity, "cys_02")) {
                Timer.set(entity, "cys_02", 400 - (int) a * 2);
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0, true, false));
            }
        }
        if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(PrimogemcraftModMobEffects.CYST)) && a >= 4) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.CYST, -1, (int) (a - 1), false, false));
        }
//        if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.CYST) ? _livEnt.getEffect(PrimogemcraftModMobEffects.CYST).getAmplifier() : 0) != a - 1) {
//            if (entity instanceof LivingEntity _entity) _entity.removeEffect(PrimogemcraftModMobEffects.CYST);
//        }
    }

    public static void shui(Entity entity, double zhi) {
        var e = zhi;
        double a1 = 0;
        double b1 = 0;
        e = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQSHUI.get())) ? zhi + zhi * 0.25 : zhi;
        if (e >= 2) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 80, 0, true, false));

        }
        if (!(entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI)) && entity.isAlive()) {
            if (e >= 4) {
                if (e < 6) {
                    a1 = e * 20;
                    if (entity instanceof LivingEntity _entity)
                        _entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * e * 0.5 * 0.02));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI, (int) a1, 0, false, false));
                } else {
                    b1 = e * 20 * 0.5;
                    if (entity instanceof LivingEntity _entity)
                        _entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * e * 0.5 * 0.03));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI, (int) b1, 0, false, false));
                }
            }
        }
    }

    public static void huo(Entity entity, double zhi) {
        var f = zhi;
        f = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQHUO.get())) ? zhi + zhi * 0.25 : zhi;
        if (f >= 2) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 80, 0, true, false));
        }
        if (f >= 4) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.RYKJXG, 1200, (int) Math.round(f - 1), false, false));
        }
        if (entity instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(PrimogemcraftModMobEffects.RYKJXG)) {
            if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.RYKJXG) ? _livEnt.getEffect(PrimogemcraftModMobEffects.RYKJXG).getAmplifier() : 0) != Math.round(f - 1)) {
                if (entity instanceof LivingEntity _entity) _entity.removeEffect(PrimogemcraftModMobEffects.RYKJXG);
            }
        }
    }

    private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
        if (entity instanceof Player player)
            return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
        return false;
    }
}
