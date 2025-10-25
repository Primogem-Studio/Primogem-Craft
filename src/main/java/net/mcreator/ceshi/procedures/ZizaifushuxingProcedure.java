package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class ZizaifushuxingProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		double n1 = 0;
		double n2 = 0;
		i1 = new ItemStack(PrimogemcraftModItems.HQFENG.get());
		n1 = YsjianzhihsProcedure.execute(entity, i1, itemstack, true, 0.9);
		n2 = YsjianzhihsProcedure.execute(entity, i1, itemstack, false, 4);
		if (entity.isInWaterOrBubble()) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.DOLPHINS_GRACE))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 240, (int) n1, false, false));
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak((int) n2, _level, null, _stkprov -> {
					});
				}
			}
		} else {
			if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.MOVEMENT_SPEED))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 240, (int) n1, false, false));
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak((int) n2, _level, null, _stkprov -> {
					});
				}
			}
		}
	}
}