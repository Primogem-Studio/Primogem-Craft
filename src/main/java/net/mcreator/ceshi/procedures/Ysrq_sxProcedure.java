package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Ysrq_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		double e = 0;
		double a1 = 0;
		double b1 = 0;
		double f = 0;
		if (!world.isClientSide()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("yan")) {
				c = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQYAN.get())) ? 10 : 8;
				if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
					if (c >= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, (int) (c - 7), true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(PrimogemcraftModMobEffects.XISHOULENGQUE)) && !(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.ABSORPTION))) {
					if (c >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 900, (int) (c * 0.5 - 1), true, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.XISHOULENGQUE, 900, 0, false, false));
					}
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("feng")) {
				b = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQFENG.get())) ? 10 : 8;
				if (!(entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.SLOW_FALLING)) && !entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
					if (b >= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, (int) (b * 0.5 - 1), true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.JUMP))) {
					if (b >= 4) {
						if (!entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b + 2), true, false));
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b - 1), true, false));
						}
					}
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("lei")) {
				d = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQLEI.get())) ? 10 : 8;
				if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(PrimogemcraftModMobEffects.GOUYU)) {
					if (d >= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, (int) (d - 6), true, false));
					}
				}
				if (world.getLevelData().isRaining() || world.getLevelData().isThundering()) {
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
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("cao")) {
				a = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQCAO.get())) ? 10 : 8;
				if (a >= 2) {
					if (Math.random() < 0.0005) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0, true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(MobEffects.HEALTH_BOOST)) && !(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(PrimogemcraftModMobEffects.SZTSXCWDP))) {
					entity.getPersistentData().putDouble("yuanbenshengminzhi", (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
					if (a >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200000, (int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4) * Math.round(a) * 0.1), true, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.YSRZXG, 200000, 0, false, false));
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0) != Math
							.floor((entity.getPersistentData().getDouble("yuanbenshengminzhi") / 4) * Math.floor(a) * 0.1) || a < 4) {
						entity.getPersistentData().putBoolean("yuanbenshengminzhi", false);
						if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0) < 254) {
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.HEALTH_BOOST);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SZTSXCWDP, 20, 0, false, false));
						}
					}
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("shui")) {
				e = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQSHUI.get())) ? 10 : 8;
				if (e >= 2) {
					if (!(entity instanceof LivingEntity _livEnt49 && _livEnt49.hasEffect(MobEffects.CONDUIT_POWER))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 80, 0, true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt51 && _livEnt51.hasEffect(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI)) && entity.isAlive()) {
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
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("huo")) {
				f = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQHUO.get())) ? 10 : 8;
				if (!(entity instanceof LivingEntity _livEnt64 && _livEnt64.hasEffect(MobEffects.FIRE_RESISTANCE))) {
					if (f >= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 80, 0, true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt66 && _livEnt66.hasEffect(PrimogemcraftModMobEffects.RYKJXG))) {
					if (f >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.RYKJXG, 1200, (int) Math.round(f - 1), false, false));
					}
				}
				if (entity instanceof LivingEntity _livEnt68 && _livEnt68.hasEffect(PrimogemcraftModMobEffects.RYKJXG)) {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.RYKJXG) ? _livEnt.getEffect(PrimogemcraftModMobEffects.RYKJXG).getAmplifier() : 0) != Math.round(f - 1)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(PrimogemcraftModMobEffects.RYKJXG);
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}