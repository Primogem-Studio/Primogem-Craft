package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class KwglsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			HsnjxfProcedure.execute(world, x, y, z, entity, entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY, itemstack, false, entity.getPersistentData().getBoolean("jingyanzhi_shiqu"), 0, 0.2, 0.3,
					"jingyanzhi_shiqu", "c:curio");
		}
	}
}