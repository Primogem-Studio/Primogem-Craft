package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QwwsxsxProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return false;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (entity.getPersistentData().getBoolean("guan_zi_po_huai")) {
				entity.getPersistentData().putBoolean("guan_zi_po_huai", false);
				a = new ItemStack(PrimogemcraftModItems.SJBCQ.get());
				{
					final String _tagName = "shijianbuchang";
					final double _tagValue = (Math.random() < 0.3 ? 2 : 1);
					CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (HSqwwsnProcedure.execute(world, x, y, z, entity, a, itemstack, true, true, 0.15, Math.random() < 0.5 ? 1 : 0, "loot spawn ~ ~ ~ loot primogemcraft:blocks/daguanzi", itemstack.getDisplayName().getString(),
						"loot spawn ~ ~ ~ loot primogemcraft:blocks/xiaoguanzi")) {
					return true;
				}
			}
		}
		return false;
	}
}
