package net.per.enchant.hunt;

import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.procedures.HSjinglianupProcedure;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.registries.DeferredHolder;

public class HuntEffect {
    private static final ResourceKey<Enchantment> HUNT_ENCHANTMENT = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:hunt"));

    public static boolean Effect(LevelAccessor world, Entity entity, Entity sourceentity) {
        HuntEffectProcessor processor = new HuntEffectProcessor(world, entity, sourceentity);
        return processor.process();
    }

    private static class HuntEffectProcessor {
        private final LevelAccessor world;
        private final Entity entity;
        private final Entity sourceentity;
        private final DeferredHolder<MobEffect, MobEffect> fengrao;

        private HuntEffectProcessor(LevelAccessor world, Entity entity, Entity sourceentity) {
            this.world = world;
            this.entity = entity;
            this.sourceentity = sourceentity;
            this.fengrao = PrimogemcraftModMobEffects.FENGRAO;
        }

        private boolean process() {
            if (!Timer.isDone(sourceentity, "hunt")) return false;
            int level = getEnchantmentLevel();
            if (level <= 0) return false;
            Timer.set(sourceentity, "hunt", level / 500);
            if (level >= 5 && Timer.isDone(sourceentity, "huntr")) {
                Timer.set(sourceentity, "huntr", 6000);
                addEffectToSource();
            }
            removeTargetEffect();
            return true;
        }

        private int getEnchantmentLevel() {
            if (!(sourceentity instanceof LivingEntity livingSource)) return 0;
            ItemStack item = livingSource.getMainHandItem();
            if (item.isEmpty()) return 0;
            int itemenchantlv = item.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(HUNT_ENCHANTMENT));
            int wuqilv = (item.getItem() == PrimogemcraftModItems.HEIYINQ.get() ? (1+(int) HSjinglianupProcedure.execute(sourceentity, item)) : 0);
            int varle = itemenchantlv + wuqilv;
            return varle;
        }

        private void removeTargetEffect() {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.removeEffect(fengrao);
            }
        }

        private void addEffectToSource() {
            if (!(sourceentity instanceof LivingEntity livingSource) || livingSource.level().isClientSide()) return;
            MobEffectInstance targetEffect = null;
            if (entity instanceof LivingEntity livingTarget) {
                targetEffect = livingTarget.getEffect(fengrao);
            }
            int duration = targetEffect != null ? Math.min(targetEffect.getDuration(),6000) : 0;
            int amplifier = targetEffect != null ? targetEffect.getAmplifier() : 0;
            livingSource.addEffect(new MobEffectInstance(fengrao, duration, Math.max(0, amplifier - 1), true, true));
        }
    }
}