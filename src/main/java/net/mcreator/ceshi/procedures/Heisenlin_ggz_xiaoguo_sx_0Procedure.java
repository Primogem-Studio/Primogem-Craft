package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

import java.util.Comparator;

public class Heisenlin_ggz_xiaoguo_sx_0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("heisenlin_ggz", (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.HEISENLINGGZ) ? _livEnt.getEffect(PrimogemcraftModMobEffects.HEISENLINGGZ).getDuration() : 0));
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			}
		}
	}
}