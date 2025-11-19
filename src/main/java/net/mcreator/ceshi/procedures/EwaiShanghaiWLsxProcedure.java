package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.ceshi.init.PrimogemcraftModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EwaiShanghaiWLsxProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double a = 0;
		double s = 0;
		if (!world.isClientSide()) {
			s = sourceentity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(PrimogemcraftModAttributes.EWAI_SHANGHAI_MF) ? _livingEntity1.getAttribute(PrimogemcraftModAttributes.EWAI_SHANGHAI_MF).getValue() : 0;
			if (net.hackermdch.pgc.Timer.isDone(sourceentity, "ewsh_mf_lq") && s > 0) {
				a = sourceentity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(PrimogemcraftModAttributes.LQSJP) ? _livingEntity2.getAttribute(PrimogemcraftModAttributes.LQSJP).getValue() : 0;
				net.hackermdch.pgc.Timer.set(sourceentity, "ewsh_mf_lq", (int) (0 - a < 20 ? 20 : 0 - a));
				entity.invulnerableTime = 0;
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC), sourceentity), (float) s);
				entity.invulnerableTime = 10;
			}
		}
	}
}