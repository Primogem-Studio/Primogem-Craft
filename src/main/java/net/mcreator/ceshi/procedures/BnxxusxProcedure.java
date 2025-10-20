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
		if (!world.isClientSide()) {
			a = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.BNXXU) ? _livEnt.getEffect(PrimogemcraftModMobEffects.BNXXU).getAmplifier() : 0;
			b = entity.getPersistentData().getDouble("bnxxu");
			hp = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
			if (entity.getTicksFrozen() > 1) {
				if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(PrimogemcraftModMobEffects.CXBD))) {
					entity.getPersistentData().putDouble("bnxxu", (b + 1));
					if (net.hackermdch.pgc.Timer.isDone(entity, "bnxxu")) {
						net.hackermdch.pgc.Timer.set(entity, "bnxxu", (int) (40 - a * 5));
						if (entity instanceof LivingEntity le)
							le.heal((float) (a * 0.8));
					}
				}
				entity.setTicksFrozen(1);
			} else if (b > 0 && net.hackermdch.pgc.Timer.isDone(entity, "bnxxu_h")) {
				net.hackermdch.pgc.Timer.set(entity, "bnxxu_h", 200);
				if (a < 3) {
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FREEZE)), (float) Math.min(hp - 1, b / 20));
				} else {
					if (entity instanceof LivingEntity le)
						le.heal((float) (((b / 40) * a) * 0.5));
				}
				entity.getPersistentData().putDouble("bnxxu", 0);
			}
		}
	}
}