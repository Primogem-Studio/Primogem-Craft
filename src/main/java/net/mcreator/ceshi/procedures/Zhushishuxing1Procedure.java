package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Zhushishuxing1Procedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		boolean o1 = false;
		double n2 = 0;
		double ns = 0;
		double nx1 = 0;
		if (DaimaHSProcedure.execute(world, sourceentity, new ItemStack(PrimogemcraftModItems.MEIYOUZHUSHIDAIMA.get()))) {
			o1 = sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.QUEZHUSHIXIAOGUO);
			nx1 = DaimaHS0Procedure.execute(o1, sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.QUEZHUSHIXIAOGUO) ? _livEnt.getEffect(PrimogemcraftModMobEffects.QUEZHUSHIXIAOGUO).getAmplifier() : 0);
			ns = DaimaHS2Procedure.execute(world, x, y, z, sourceentity, 10);
			n2 = sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.QUEZHUSHIXIAOGUO) ? _livEnt.getEffect(PrimogemcraftModMobEffects.QUEZHUSHIXIAOGUO).getDuration() : 0;
			if (sourceentity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.QUEZHUSHIXIAOGUO);
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.QUEZHUSHIXIAOGUO, (int) DaimaHS1Procedure.execute(o1, n2), (int) (nx1 >= ns ? ns - 1 : nx1), false, false));
		}
	}
}