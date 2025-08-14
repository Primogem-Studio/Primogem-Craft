package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Holder;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

import net.hackermdch.pgc.CustomAPI;

public class WuqishuaxinProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, ItemStack item) {
		if (entity == null)
			return false;
		ItemStack stack = ItemStack.EMPTY;
		double a1 = 0;
		double a11 = 0;
		double a = 0;
		double a2 = 0;
		double b = 0;
		double a12 = 0;
		double c = 0;
		stack = item;
		a = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + 1;
		a1 = 30;
		a2 = 60;
		a11 = (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGHAI));
		a12 = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jun_heng / 1000;
		if (a > a2) {
			b = a1 * a11 * (0.01 + a12);
			c = c + b;
			b = a1 * a11 * (0.02 + a12 * 1.5);
			c = c + b;
			c = c + (a - a2) * a11 * (0.03 + a12 * 2);
			return WuqishuaxinProcedure.wuqishixian(stack, c);
		} else if (a >= a1 && a <= a2) {
			b = a1 * a11 * (0.01 + a12);
			c = c + b;
			c = c + (a - a1) * a11 * (0.02 + a12 * 1.5);
			return WuqishuaxinProcedure.wuqishixian(stack, c);
		} else if (a < a1) {
			c = c + a * a11 * (0.01 + a12);
			return WuqishuaxinProcedure.wuqishixian(stack, c);
		}
		return false;
	}

	public static boolean wuqishixian(ItemStack stack, double c) {
		var z = Attributes.ATTACK_DAMAGE;
		boolean o1 = false;
		if (NBTwuqi(stack, "pgc:wuqi/danshou", 1f, c, z)) {
			o1 = true;
		} // else if (NBTwuqi(stack, "pgc:wuqi/changbing", 1.3f, c, z)) {
			// o1 = true;
			// }
		return o1;
	}

	public static boolean NBTwuqi(ItemStack stack, String tag, float cheng, double c, Holder<Attribute> z) {
		if (stack.is(ItemTags.create(ResourceLocation.parse(tag)))) {
			var attr = CustomAPI.getAttributes(stack);
			attr.add(z, "djjc", c * cheng, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
			return true;
		}
		return false;
	}
}