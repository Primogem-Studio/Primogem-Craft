package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class BnxxusxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double hp = 0;
		a = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.BNXXU) ? _livEnt.getEffect(PrimogemcraftModMobEffects.BNXXU).getAmplifier() : 0;
		b = entity.getPersistentData().getDouble("bnxxu");
		hp = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
		if (entity.getTicksFrozen() > 1) {
			entity.getPersistentData().putDouble("bnxxu", (b + 1));
			if (net.hackermdch.pgc.Timer.isDone(entity, "bnxxu")) {
				net.hackermdch.pgc.Timer.set(entity, "bnxxu", (int) (40 - a * 5));
				hp(world, entity, a);
			}
			entity.setTicksFrozen(1);
		} else if (b > 0 && net.hackermdch.pgc.Timer.isDone(entity, "bnxxu_h")) {
			net.hackermdch.pgc.Timer.set(entity, "bnxxu_h", 20);
			if (a >= 4) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FREEZE)), (float) Math.min(hp - 1, b / 20));
				entity.getPersistentData().putDouble("bnxxu", 0);
			} else {
				hp(world, entity, b);
			}
		}
	}

	public static void hp(LevelAccessor world, Entity entity, double zhi) {
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + zhi));
		}
	}
}