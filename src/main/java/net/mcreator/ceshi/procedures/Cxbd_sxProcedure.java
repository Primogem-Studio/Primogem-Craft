package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Cxbd_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity e1 = null;
		if (world instanceof ServerLevel e) {
			e1 = e.getEntity((int) entity.getPersistentData().getDouble("cxbd"));
		}
		entity.setTicksFrozen(139);
		if (net.hackermdch.pgc.Timer.isDone(entity, "cxbd")) {
			net.hackermdch.pgc.Timer.set(entity, "cxbd", 10);
			entity.invulnerableTime = 0;
			entity.hurt(ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.FREEZE), e1), 1, 4),
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.CXBD) ? _livEnt.getEffect(PrimogemcraftModMobEffects.CXBD).getAmplifier() : 0);
			entity.invulnerableTime = 10;
		}
	}
}