package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class TczdgsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			i1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			a = HSjinglianupProcedure.execute(entity, itemstack);
			b = entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0;
			c = (b * (0.28 + 0.07 * a) + b * (0.28 + 0.07 * a) * (0.4 + 0.1 * a)) * (i1.getItem() == PrimogemcraftModItems.WQZHG.get() ? 1.06 + HSjinglianupProcedure.execute(entity, i1) * 0.015 * a : 1);
			XsfHSProcedure.execute(itemstack, false, false, (float) c, "tcsx");
			JlqhewaiProcedure.execute(entity, itemstack);
			if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
				XsfHSProcedure.execute(itemstack, false, true, -0.8 + 0.1 * a, "tccf");
			} else {
				XsfHSProcedure.execute(itemstack, false, true, 0, "tccf");
			}
		}
	}
}