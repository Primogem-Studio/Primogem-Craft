package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class TczdgsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		b = entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0;
		c = (b * (0.28 + 0.07 * a) + b * (0.28 + 0.07 * a) * (0.4 + 0.1 * a)) * ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.WQZHG.get() ? 1.2 + 0.05 * a : 1);
		XsfHSProcedure.execute(itemstack, false, false, (float) c, "tcsx");
		JlqhewaiProcedure.execute(entity, itemstack);
		if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
			XsfHSProcedure.execute(itemstack, false, true, -0.4 + 0.01 * a, "tccf");
		} else {
			XsfHSProcedure.execute(itemstack, false, true, 0, "tccf");
		}
	}
}