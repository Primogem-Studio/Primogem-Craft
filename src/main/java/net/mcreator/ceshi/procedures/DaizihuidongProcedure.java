package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class DaizihuidongProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(PrimogemcraftModGameRules.JINYONGNANG)) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u6E38\u620F\u89C4\u5219 \u7981\u7528\u56CA \u5DF2\u88AB\u7BA1\u7406\u5458\u542F\u7528\uFF01\u56CA\u7C7B\u9053\u5177\u5C06\u65E0\u6CD5\u7EE7\u7EED\u4F7F\u7528\uFF01"), false);
		} else {
			if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			}
			if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
			}
		}
	}
}