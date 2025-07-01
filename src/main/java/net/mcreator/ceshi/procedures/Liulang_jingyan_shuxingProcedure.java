package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.hackermdch.pgc.CustomAPI;

public class Liulang_jingyan_shuxingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		double jingyan = 0;
		double a = 0;
		stack = itemstack.copy();
		var bar = CustomAPI.getCustomBar(stack);
		if (entity.isShiftKeyDown()) {
			if (bar.numerator == 0) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7a\u7ECF\u9A8C\u503C\u00A7c\u4E3A\u7A7A\uFF01"), false);
			} else {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) bar.numerator);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7a\u7ECF\u9A8C\u503C\u00A7e\u5DF2\u53D6\u51FA\uFF01"), false);
				if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
				}
				bar.numerator = 0;
			}
		} else {
			if (bar.numerator < bar.denominator) {
				jingyan = DiaoyongjisuanjingyanzhiProcedure.execute(entity);
				if (jingyan != 0) {
					a = bar.denominator - bar.numerator;
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(-((int) a));
					if (jingyan > a) {
						bar.numerator = bar.denominator;
					} else {
						bar.numerator += (int) jingyan;
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7a\u7ECF\u9A8C\u503C\u00A7b\u5DF2\u5B58\u5165\uFF01"), false);
					if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.OFF_HAND, true);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7a\u7ECF\u9A8C\u4E66\u00A7c\u5DF2\u5B58\u6EE1\uFF01"), false);
			}
		}
	}
}