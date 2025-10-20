//package net.mcreator.ceshi.procedures;
//
//import net.mcreator.ceshi.init.PrimogemcraftModItems;
//import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.world.effect.MobEffect;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.LevelAccessor;
//
//public class Ystz_xgProcedure {
//
//    // ========== 元素效果调用方法 ==========
//
//    /**
//     * 风元素效果
//     * @param world 世界
//     * @param entity 实体
//     * @param zhi 基础值
//     * @param canFly 是否允许飞行效果
//     */
//    public static void feng(LevelAccessor world, Entity entity, double zhi, boolean canFly) {
//        if (!validateParams(world, entity)) return;
//
//        double finalValue = calculateFinalValue(entity, PrimogemcraftModItems.HQFENG.get(), zhi);
//
//        if (canFly && !hasEffect(entity, MobEffects.SLOW_FALLING.value()) && finalValue >= 2) {
//            applyEffect(entity, MobEffects.SLOW_FALLING.value(), 100, (int)(finalValue * 0.5 - 1), true, false);
//        }
//
//        if (canFly && !hasEffect(entity, MobEffects.JUMP.value()) && finalValue >= 4) {
//            applyEffect(entity, MobEffects.JUMP.value(), 100, (int)(finalValue + 2), true, false);
//        }
//
//        applyEffect(entity, PrimogemcraftModMobEffects.FEIXING.get(), 20, 0, false, false);
//    }
//
//    /**
//     * 岩元素效果
//     */
//    public static void yan(LevelAccessor world, Entity entity, double zhi) {
//        if (!validateParams(world, entity)) return;
//
//        double finalValue = calculateFinalValue(entity, PrimogemcraftModItems.HQYAN.get(), zhi);
//
//        if (!hasEffect(entity, MobEffects.DAMAGE_RESISTANCE.value()) && finalValue >= 2) {
//            applyEffect(entity, MobEffects.DAMAGE_RESISTANCE.value(), 100, (int)(finalValue - 7), true, false);
//        }
//
//        if (!hasEffect(entity, PrimogemcraftModMobEffects.XISHOULENGQUE.get()) &&
//                !hasEffect(entity, MobEffects.ABSORPTION.value()) && finalValue >= 4) {
//            applyEffect(entity, MobEffects.ABSORPTION.value(), 900, (int)(finalValue * 0.5 - 1), true, false);
//            applyEffect(entity, PrimogemcraftModMobEffects.XISHOULENGQUE.get(), 900, 0, false, false);
//        }
//    }
//
//    /**
//     * 雷元素效果
//     */
//    public static void lei(LevelAccessor world, Entity entity, double zhi) {
//        if (!validateParams(world, entity)) return;
//
//        double finalValue = calculateFinalValue(entity, PrimogemcraftModItems.HQLEI.get(), zhi);
//
//        if (hasEffect(entity, PrimogemcraftModMobEffects.GOUYU.get()) && finalValue >= 2) {
//            applyEffect(entity, MobEffects.DAMAGE_RESISTANCE.value(), 60, (int)(finalValue - 6), true, false);
//        }
//
//        if ((world.getLevelData().isRaining() || world.getLevelData().isThundering()) && finalValue >= 4) {
//            applyEffect(entity, MobEffects.DAMAGE_BOOST.value(), 60, (int)(finalValue * 0.5 - 2), true, false);
//            applyEffect(entity, MobEffects.MOVEMENT_SPEED.value(), 60, (int)(finalValue * 0.5 - 3), true, false);
//        }
//    }
//
//    /**
//     * 草元素效果
//     */
//    public static void cao(LevelAccessor world, Entity entity, double zhi) {
//        if (!validateParams(world, entity)) return;
//
//        double finalValue = calculateFinalValue(entity, PrimogemcraftModItems.HQCAO.get(), zhi);
//
//        if (finalValue >= 2 && Math.random() < 0.0005) {
//            applyEffect(entity, MobEffects.SATURATION.value(), 10, 0, true, false);
//        }
//
//        applyEffect(entity, PrimogemcraftModMobEffects.YSRZXG.get(), 60, 0, false, false);
//
//        manageCystEffect(entity, finalValue);
//    }
//
//    /**
//     * 水元素效果
//     */
//    public static void shui(LevelAccessor world, Entity entity, double zhi) {
//        if (!validateParams(world, entity)) return;
//
//        double finalValue = calculateFinalValue(entity, PrimogemcraftModItems.HQSHUI.get(), zhi);
//
//        if (finalValue >= 2 && !hasEffect(entity, MobEffects.CONDUIT_POWER.value())) {
//            applyEffect(entity, MobEffects.CONDUIT_POWER.value(), 80, 0, true, false);
//        }
//
//        if (!hasEffect(entity, PrimogemcraftModMobEffects.DJQJKJXGXIANZHI.get()) && entity.isAlive() && finalValue >= 4) {
//            applyHealingEffect(entity, finalValue);
//        }
//    }
//
//    /**
//     * 火元素效果
//     */
//    public static void huo(LevelAccessor world, Entity entity, double zhi) {
//        if (!validateParams(world, entity)) return;
//
//        double finalValue = calculateFinalValue(entity, PrimogemcraftModItems.HQHUO.get(), zhi);
//
//        if (finalValue >= 2 && !hasEffect(entity, MobEffects.FIRE_RESISTANCE.value())) {
//            applyEffect(entity, MobEffects.FIRE_RESISTANCE.value(), 80, 0, true, false);
//        }
//
//        manageRykjxgEffect(entity, finalValue);
//    }
//
//    // ========== 效果判定方法 ==========
//
//    /**
//     * 检查实体是否具有指定效果
//     */
//    public static boolean hasEffect(Entity entity, MobEffect effect) {
//        return entity instanceof LivingEntity living && living.hasEffect(effect);
//    }
//
//    /**
//     * 获取实体效果的放大器等级
//     */
//    public static int getEffectAmplifier(Entity entity, MobEffect effect) {
//        if (entity instanceof LivingEntity living && living.hasEffect(effect)) {
//            return living.getEffect(effect).getAmplifier();
//        }
//        return 0;
//    }
//
//    /**
//     * 获取实体效果的剩余持续时间（刻）
//     */
//    public static int getEffectDuration(Entity entity, MobEffect effect) {
//        if (entity instanceof LivingEntity living && living.hasEffect(effect)) {
//            return living.getEffect(effect).getDuration();
//        }
//        return 0;
//    }
//
//    /**
//     * 检查实体是否具有指定元素对应的火漆
//     */
//    public static boolean hasElementSeal(Entity entity, String element) {
//        return switch (element.toLowerCase()) {
//            case "feng" -> hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQFENG.get()));
//            case "yan" -> hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQYAN.get()));
//            case "lei" -> hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQLEI.get()));
//            case "cao" -> hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQCAO.get()));
//            case "shui" -> hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQSHUI.get()));
//            case "huo" -> hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQHUO.get()));
//            default -> false;
//        };
//    }
//
//    // ========== 效果移除方法 ==========
//
//    /**
//     * 移除实体的指定效果
//     */
//    public static void removeEffect(Entity entity, MobEffect effect) {
//        if (entity instanceof LivingEntity living) {
//            living.removeEffect(effect);
//        }
//    }
//
//    /**
//     * 移除实体的所有元素效果
//     */
//    public static void removeAllElementEffects(Entity entity) {
//        if (!(entity instanceof LivingEntity living)) return;
//
//        // 移除原版效果
//        living.removeEffect(MobEffects.SLOW_FALLING.value());
//        living.removeEffect(MobEffects.JUMP.value());
//        living.removeEffect(MobEffects.DAMAGE_RESISTANCE.value());
//        living.removeEffect(MobEffects.ABSORPTION.value());
//        living.removeEffect(MobEffects.DAMAGE_BOOST.value());
//        living.removeEffect(MobEffects.MOVEMENT_SPEED.value());
//        living.removeEffect(MobEffects.SATURATION.value());
//        living.removeEffect(MobEffects.CONDUIT_POWER.value());
//        living.removeEffect(MobEffects.FIRE_RESISTANCE.value());
//
//        // 移除自定义效果
//        living.removeEffect(PrimogemcraftModMobEffects.FEIXING.get());
//        living.removeEffect(PrimogemcraftModMobEffects.XISHOULENGQUE.get());
//        living.removeEffect(PrimogemcraftModMobEffects.GOUYU.get());
//        living.removeEffect(PrimogemcraftModMobEffects.YSRZXG.get());
//        living.removeEffect(PrimogemcraftModMobEffects.CYST.get());
//        living.removeEffect(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI.get());
//        living.removeEffect(PrimogemcraftModMobEffects.RYKJXG.get());
//    }
//
//    /**
//     * 移除指定元素的特定效果
//     */
//    public static void removeElementEffects(Entity entity, String element) {
//        if (!(entity instanceof LivingEntity living)) return;
//
//        switch (element.toLowerCase()) {
//            case "feng" -> {
//                living.removeEffect(MobEffects.SLOW_FALLING.value());
//                living.removeEffect(MobEffects.JUMP.value());
//                living.removeEffect(PrimogemcraftModMobEffects.FEIXING.get());
//            }
//            case "yan" -> {
//                living.removeEffect(MobEffects.DAMAGE_RESISTANCE.value());
//                living.removeEffect(MobEffects.ABSORPTION.value());
//                living.removeEffect(PrimogemcraftModMobEffects.XISHOULENGQUE.get());
//            }
//            case "lei" -> {
//                living.removeEffect(MobEffects.DAMAGE_RESISTANCE.value());
//                living.removeEffect(MobEffects.DAMAGE_BOOST.value());
//                living.removeEffect(MobEffects.MOVEMENT_SPEED.value());
//            }
//            case "cao" -> {
//                living.removeEffect(MobEffects.SATURATION.value());
//                living.removeEffect(PrimogemcraftModMobEffects.YSRZXG.get());
//                living.removeEffect(PrimogemcraftModMobEffects.CYST.get());
//            }
//            case "shui" -> {
//                living.removeEffect(MobEffects.CONDUIT_POWER.value());
//                living.removeEffect(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI.get());
//            }
//            case "huo" -> {
//                living.removeEffect(MobEffects.FIRE_RESISTANCE.value());
//                living.removeEffect(PrimogemcraftModMobEffects.RYKJXG.get());
//            }
//        }
//    }
//
//    // ========== 专用效果管理方法 ==========
//
//    private static void manageCystEffect(Entity entity, double finalValue) {
//        int targetAmplifier = (int)(finalValue - 1);
//
//        if (!hasEffect(entity, PrimogemcraftModMobEffects.CYST.get()) && finalValue >= 4) {
//            applyEffect(entity, PrimogemcraftModMobEffects.CYST.get(), -1, targetAmplifier, false, false);
//        }
//
//        if (hasEffect(entity, PrimogemcraftModMobEffects.CYST.get())) {
//            int currentAmplifier = getEffectAmplifier(entity, PrimogemcraftModMobEffects.CYST.get());
//            if (currentAmplifier != targetAmplifier) {
//                removeEffect(entity, PrimogemcraftModMobEffects.CYST.get());
//            }
//        }
//    }
//
//    private static void manageRykjxgEffect(Entity entity, double finalValue) {
//        int targetAmplifier = (int)Math.round(finalValue - 1);
//
//        if (!hasEffect(entity, PrimogemcraftModMobEffects.RYKJXG.get()) && finalValue >= 4) {
//            applyEffect(entity, PrimogemcraftModMobEffects.RYKJXG.get(), 1200, targetAmplifier, false, false);
//        }
//
//        if (hasEffect(entity, PrimogemcraftModMobEffects.RYKJXG.get())) {
//            int currentAmplifier = getEffectAmplifier(entity, PrimogemcraftModMobEffects.RYKJXG.get());
//            if (currentAmplifier != targetAmplifier) {
//                removeEffect(entity, PrimogemcraftModMobEffects.RYKJXG.get());
//            }
//        }
//    }
//
//    private static void applyHealingEffect(Entity entity, double finalValue) {
//        if (!(entity instanceof LivingEntity living)) return;
//
//        double healAmount;
//        int effectDuration;
//
//        if (finalValue < 6) {
//            healAmount = living.getMaxHealth() * finalValue * 0.5 * 0.02;
//            effectDuration = (int)(finalValue * 20);
//        } else {
//            healAmount = living.getMaxHealth() * finalValue * 0.5 * 0.03;
//            effectDuration = (int)(finalValue * 20 * 0.5);
//        }
//
//        living.setHealth((float)Math.min(living.getHealth() + healAmount, living.getMaxHealth()));
//        applyEffect(entity, PrimogemcraftModMobEffects.DJQJKJXGXIANZHI.get(), effectDuration, 0, false, false);
//    }
//
//    // ========== 通用工具方法 ==========
//
//    private static boolean validateParams(LevelAccessor world, Entity entity) {
//        return entity != null && !world.isClientSide();
//    }
//
//    private static double calculateFinalValue(Entity entity, net.minecraft.world.level.ItemLike sealItem, double zhi) {
//        boolean hasSeal = hasEntityInInventory(entity, new ItemStack(sealItem));
//        double sealBonus = hasSeal ? 2.0 : 0.0;
//        return zhi + sealBonus;
//    }
//
//    private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
//        return entity instanceof Player player &&
//                player.getInventory().contains(stack ->
//                        !stack.isEmpty() && ItemStack.isSameItemSameComponents(stack, itemstack));
//    }
//
//    private static void applyEffect(Entity entity, MobEffect effect,
//                                    int duration, int amplifier, boolean ambient, boolean showIcon) {
//        if (entity instanceof LivingEntity living && !living.level().isClientSide()) {
//            living.addEffect(new MobEffectInstance(effect, duration, amplifier, ambient, showIcon));
//        }
//    }
//}