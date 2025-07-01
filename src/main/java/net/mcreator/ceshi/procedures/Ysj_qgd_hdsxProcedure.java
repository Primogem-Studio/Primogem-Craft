package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Ysj_qgd_hdsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (Math.random() < 0.05) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(itemstack.getMaxDamage(), _level, null, _stkprov -> {
				});
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PrimogemcraftModItems.QGDYSJ.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}