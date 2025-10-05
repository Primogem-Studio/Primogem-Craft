package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.init.PrimogemcraftModAttributes;

import net.hackermdch.pgc.CustomAPI;

public class QwJzyjsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double z = 0;
		double h = 0;
		ItemStack stack = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (net.hackermdch.pgc.Timer.isDone(entity, "jzyj")) {
				net.hackermdch.pgc.Timer.set(entity, "jzyj", 40);
				h = entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1;
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
					for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("c:curio/bad")))) {
							a = a + itemstackiterator.getCount();
						}
					}
				}
				z = Math.round(h * 0.003 * a) > Math.round(h * 0.3) ? Math.round(h * 0.3) : Math.round(h * 0.003 * a);
				stack = itemstack;
				var attr = CustomAPI.getAttributes(stack);
				attr.add(PrimogemcraftModAttributes.EWAI_SHANGHAI_MF, "jzyj", z, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.ANY);
				attr.apply();
			}
		}
	}
}