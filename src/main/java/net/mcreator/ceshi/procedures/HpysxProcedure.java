package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class HpysxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		if (entity.isShiftKeyDown()) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.JUMP)) && !net.hackermdch.pgc.Timer.isDone(entity, "hpy_t")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, (int) (200 + 50 * a), (int) (4 + 1 * a), false, false));
				net.hackermdch.pgc.Timer.set(entity, "hpy_t", (int) (160 - 20 * a));
			}
		} else {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j") > 0) {
				{
					final String _tagName = "hpy_bd_j";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j") - 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				boolean d = entity.onGround();
				var f = (2 + 0.5 * a) * (d ? 2 : 1);
				Vec3 lookAngle = entity.getLookAngle();
				Vec3 movement = new Vec3(lookAngle.x * f, d ? 0 : 0.2, lookAngle.z * f);
				entity.setDeltaMovement(movement);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.HPYXG, (int) (5 + 1 * a), 0, false, false));
			}
		}
	}
}