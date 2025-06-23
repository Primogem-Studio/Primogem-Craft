package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class Qwsczzsx0Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("qw")) {
				i1 = (itemstack.copy()).copy();
				itemstack.shrink(1);
				if (Math.random() < 0.1) {
					a = 3;
				} else if (Math.random() < 0.3) {
					a = 2;
				} else {
					a = 1;
				}
				{
					final String _tagName = "qw";
					final double _tagValue = a;
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = i1.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
	}
}
