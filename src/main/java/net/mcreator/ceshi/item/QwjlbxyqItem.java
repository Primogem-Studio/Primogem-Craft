package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.HtdzsxProcedure;

import java.util.List;

public class QwjlbxyqItem extends Item {
	public QwjlbxyqItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.qwjlbxyq.description_0"));
		list.add(Component.translatable("item.primogemcraft.qwjlbxyq.description_1"));
		list.add(Component.translatable("item.primogemcraft.qwjlbxyq.description_2"));
		list.add(Component.translatable("item.primogemcraft.qwjlbxyq.description_3"));
		list.add(Component.translatable("item.primogemcraft.qwjlbxyq.description_4"));
		list.add(Component.translatable("item.primogemcraft.qwjlbxyq.description_5"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		HtdzsxProcedure.execute(entity);
	}
}