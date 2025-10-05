package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.init.PrimogemcraftModAttributes;

import net.hackermdch.pgc.CustomAPI;

public class EwaishhsProcedure {
	public static boolean execute(Entity entity, String ss1) {
		if (entity == null || ss1 == null)
			return false;
		Entity e = null;
		String s1 = "";
		e = entity;
		s1 = ss1;
		if (net.hackermdch.pgc.Timer.isDone(entity, s1)) {
			net.hackermdch.pgc.Timer.set(entity, s1, 40);
			return true;
		}
		return false;
	}

	public static int obd(Entity entity) {
		var a = 0;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("c:curio/bad")))) {
					a = a + itemstackiterator.getCount();
				}
			}
		}
		return a;
	}

	public static void sl(double z, String s1, ItemStack itemstack) {
		var attr = CustomAPI.getAttributes(itemstack);
		attr.add(PrimogemcraftModAttributes.EWAI_SHANGHAI_MF, s1, z, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.ANY);
		attr.apply();
	}

	boolean s() {
		return false;
	}
}