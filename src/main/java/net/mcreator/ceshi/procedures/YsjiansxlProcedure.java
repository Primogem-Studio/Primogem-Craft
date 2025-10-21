package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import net.hackermdch.pgc.CustomComponents;

public class YsjiansxlProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			var it = itemstack.get(CustomComponents.YSZUJIAN_JIAN);
			if (it == null)
				return;
			if (it == 3 && entity.isShiftKeyDown()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.GOUYU, 200, (int) YsjianzhihsProcedure.execute(entity, new ItemStack(PrimogemcraftModItems.HQLEI.get()), itemstack, true, 1)));
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) Math.max(YsjianzhihsProcedure.execute(entity, new ItemStack(PrimogemcraftModItems.HQLEI.get()), itemstack, false, 800), 100));
			}
		}
	}
}