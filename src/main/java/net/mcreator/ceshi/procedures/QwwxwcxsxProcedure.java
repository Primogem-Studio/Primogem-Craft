package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

public class QwwxwcxsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		HSQwwxwctsxProcedure.execute(world, x, y, z, entity, entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY, itemstack, false, false, true, false, false, 20, 2, itemstack.getDisplayName().getString(),
				BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString() + "xianzhi");
	}
}