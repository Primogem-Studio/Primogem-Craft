package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class GUIxuanitemProcedure {
	public static ItemStack execute(LevelAccessor world, boolean qd, String _tag) {
		if (_tag == null)
			return ItemStack.EMPTY;
		ItemStack item = ItemStack.EMPTY;
		item = (qd ? TagItemProcedure.execute(_tag) : LoottItemProcedure.execute(world, _tag));
		if (qd) {
			item.setCount(1);
		}
		return item;
	}
}