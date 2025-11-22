package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Ceshi_3Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		stack = new ItemStack(PrimogemcraftModItems.EVENTITEM.get());
		{
			final String _tagName = "event_";
			final double _tagValue = (Mth.nextInt(RandomSource.create(), 1, 3));
			CustomData.update(DataComponents.CUSTOM_DATA, stack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = stack.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}