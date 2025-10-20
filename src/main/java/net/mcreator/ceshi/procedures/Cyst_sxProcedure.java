package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

public class Cyst_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack i = ItemStack.EMPTY;
		a = entity.getPersistentData().getDouble("qysx_a");
		if (hasEntityInInventory(entity, YsrzxgcsxProcedure.execute())) {
			a = hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQCAO.get())) ? 10 : 8;
		}
		if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(PrimogemcraftModMobEffects.YSRZXG)) || a != entity.getPersistentData().getDouble("qysx_b")) {
			entity.getPersistentData().putDouble("qysx_b", a);
			PrimogemcraftMod.queueServerWork(10, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.CYST);
			});
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}