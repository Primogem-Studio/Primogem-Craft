package net.mcreator.ceshi.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Cxbd_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		Entity e1 = null;
		if (world instanceof ServerLevel level) {
			e1 = level.getEntity((int) entity.getPersistentData().getDouble("cxbd"));
			level.sendParticles(ParticleTypes.SNOWFLAKE, entity.getX(), entity.getY() + entity.getBbHeight() / 2, entity.getZ(), 5, 0.3, 0.3, 0.3, 0.05);
		}
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.CXBD))) {
			entity.setTicksFrozen(139);
		}
		if (net.hackermdch.pgc.Timer.isDone(entity, "cxbd") && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.BNXXU))) {
			net.hackermdch.pgc.Timer.set(entity, "cxbd", 10);
			entity.invulnerableTime = 0;
			a = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.CXBD) ? _livEnt.getEffect(PrimogemcraftModMobEffects.CXBD).getAmplifier() : 0;
			entity.hurt(ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.FREEZE), e1), 1, 4), (float) (ModList.get().isLoaded("genshincraft") ? a * 25 : a));
			entity.invulnerableTime = 10;
		}
	}
}