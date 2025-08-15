package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class YsrzxgcsxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		a = new ItemStack(PrimogemcraftModItems.YSRZ_0.get());
		{
			final String _tagName = "cao";
			final double _tagValue = 1;
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
		}
		a.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7a\u5143\u7D20\u7194\u73E0"));
		{
			final String _tagName = "qidong";
			final boolean _tagValue = true;
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putBoolean(_tagName, _tagValue));
		}
		if (!hasEntityInInventory(entity, a)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.YSRZXG);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.CYST);
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}