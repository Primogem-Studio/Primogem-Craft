package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.QwwcnsxProcedure;

import java.util.List;

public class QwwcnItem extends Item {
	public QwwcnItem() {
		super(new Item.Properties().durability(20));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.qwwcn.description_0"));
		list.add(Component.translatable("item.primogemcraft.qwwcn.description_1"));
		list.add(Component.translatable("item.primogemcraft.qwwcn.description_2"));
		list.add(Component.translatable("item.primogemcraft.qwwcn.description_3"));
		list.add(Component.translatable("item.primogemcraft.qwwcn.description_4"));
		list.add(Component.translatable("item.primogemcraft.qwwcn.description_5"));
		list.add(Component.translatable("item.primogemcraft.qwwcn.description_6"));
		list.add(Component.translatable("item.primogemcraft.qwwcn.description_7"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwwcnsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}