package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

import java.util.Comparator;

public class QwcgsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (YimuguoshisxhsProcedure.execute(world, x, y, z, entity, itemstack, itemstack, false, true, 5, 1200, 2)) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (!(entityiterator == entity) && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 10) {
						if (!(entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(PrimogemcraftModMobEffects.JISHENG))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.JISHENG, 400, 4));
						}
					}
				}
			}
		}
	}
}