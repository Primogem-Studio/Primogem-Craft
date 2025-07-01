package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Luodejingshe_shuxingProcedure;

import java.util.List;

public class PengkeluodejingshenItem extends Item {
	public PengkeluodejingshenItem() {
		super(new Item.Properties().durability(10).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		ItemStack retval = new ItemStack(this);
		retval.setDamageValue(itemstack.getDamageValue() + 1);
		if (retval.getDamageValue() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}

	@Override
	public boolean isRepairable(ItemStack itemstack) {
		return false;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.pengkeluodejingshen.description_0"));
		list.add(Component.translatable("item.primogemcraft.pengkeluodejingshen.description_1"));
		list.add(Component.translatable("item.primogemcraft.pengkeluodejingshen.description_2"));
		list.add(Component.translatable("item.primogemcraft.pengkeluodejingshen.description_3"));
		list.add(Component.translatable("item.primogemcraft.pengkeluodejingshen.description_4"));
		list.add(Component.translatable("item.primogemcraft.pengkeluodejingshen.description_5"));
		list.add(Component.translatable("item.primogemcraft.pengkeluodejingshen.description_6"));
		list.add(Component.translatable("item.primogemcraft.pengkeluodejingshen.description_7"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Luodejingshe_shuxingProcedure.execute(entity);
	}
}