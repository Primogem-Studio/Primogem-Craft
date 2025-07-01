package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QwwcnsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getPersistentData().getBoolean("guan_zi_po_huai")) {
				entity.getPersistentData().putBoolean("guan_zi_po_huai", false);
				if (HSqwwsnProcedure.execute(world, x, y, z, entity, new ItemStack(PrimogemcraftModItems.QIWUCHONGWANG.get()), itemstack, true, true, 0.05, 1, "loot spawn ~ ~ ~ loot primogemcraft:blocks/daguanzi",
						itemstack.getDisplayName().getString(), "loot spawn ~ ~ ~ loot primogemcraft:blocks/xiaoguanzi")) {
					if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(PrimogemcraftModMobEffects.JISHENG))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.JISHENG, 200, 1));
					}
				}
			}
		}
	}
}