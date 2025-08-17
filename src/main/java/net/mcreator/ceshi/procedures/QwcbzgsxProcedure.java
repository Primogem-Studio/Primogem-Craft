package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QwcbzgsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		a = new ItemStack(PrimogemcraftModItems.SJBCQ.get()).copy();
		{
			final String _tagName = "shijianbuchang";
			final double _tagValue = (Mth.nextInt(RandomSource.create(), 1, 2));
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
		}
		YimuguoshisxhsProcedure.execute(world, x, y, z, entity, a, itemstack, true, true, 5, 1200, 2);
	}
}