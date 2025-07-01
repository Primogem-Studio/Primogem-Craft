package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class JianmufuzhuoshuxingfushouProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double zhi) {
		if (entity == null)
			return;
		Jianmuhs2Procedure.execute(world, x, y, z, entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY, zhi);
		Jianmuhs2Procedure.execute(world, x, y, z, entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY, zhi);
	}
}