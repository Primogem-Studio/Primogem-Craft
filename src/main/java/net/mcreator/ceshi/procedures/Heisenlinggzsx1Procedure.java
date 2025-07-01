package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Heisenlinggzsx1Procedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		Entity a = null;
		if (!(entity instanceof Player) && (sourceentity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PrimogemcraftModMobEffects.HEISENLINGGZ)
				|| immediatesourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.HEISENLINGGZ))) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
				if (!(sourceentity instanceof Player _plrCldCheck7 && _plrCldCheck7.getCooldowns().isOnCooldown(PrimogemcraftModItems.QIWUHEISENLINGGZ.get()))) {
					if (Math.random() < 0.1) {
						if (sourceentity instanceof Player _player)
							_player.getCooldowns().addCooldown(PrimogemcraftModItems.QIWUHEISENLINGGZ.get(), 20);
						for (int index0 = 0; index0 < 3; index0++) {
							if (Math.random() < 0.4) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else if (Math.random() < 0.4) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}