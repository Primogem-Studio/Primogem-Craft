package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

import java.util.Comparator;

public class Qwmhs_sx_0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.CHICUNA);
				if (entityiterator instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.CHICUNB);
			}
		}
		if (itemstack.getDamageValue() >= 9) {
			DiaoyongqwyisunhuaiProcedure.execute(world, x, y, z, entity, itemstack);
		}
		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
	}
}