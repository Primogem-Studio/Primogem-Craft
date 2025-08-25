package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;

import net.hackermdch.pgc.CustomAPI;

public class JdzqsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double a = 0;
		double ae = 0;
		double x = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		for (Entity entityiterator : world.getEntities(sourceentity, new AABB((entity.getX() + 2), (entity.getY() + 2), (entity.getZ() + 2), (entity.getX() - 2), (entity.getY() - 2), (entity.getZ() - 2)))) {
			if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity || entityiterator instanceof Player) {
				ae = ae + 1;
			}
		}
		x = ae > 0 ? (ae < 2 ? 0.28 + 0.07 * a : 0.16 + 0.04 * a) : 0;
		XsfHSProcedure.execute(itemstack, true, false, x, "");
		var attr = CustomAPI.getAttributes(itemstack);
		attr.add(Attributes.ARMOR, "hjz", ae > 1 ? 0.16 + 0.04 * a : 0, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
		attr.apply();
	}
}