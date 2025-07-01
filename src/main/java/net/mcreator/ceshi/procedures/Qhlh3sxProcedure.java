package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Qhlh3sxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (!world.isClientSide() && !itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("lihe_zhuanhua")) {
			{
				final String _tagName = "lihe_zhuanhua";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			if (itemstack.getCount() > 1) {
				a = 0;
				for (int index0 = 0; index0 < itemstack.getCount(); index0++) {
					if (Math.random() < 0.2) {
						a = a + 1;
					}
				}
				itemstack.shrink((int) a);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PrimogemcraftModItems.QHZLLH_4.get()).copy();
					_setstack.setCount((int) a);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else {
				if (Math.random() < 0.2) {
					itemstack.shrink(1);
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.QHZLLH_4.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}