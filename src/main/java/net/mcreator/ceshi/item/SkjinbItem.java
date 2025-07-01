package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.SkjinbisxProcedure;

import java.util.List;

public class SkjinbItem extends Item {
	public SkjinbItem() {
		super(new Item.Properties().durability(12));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.skjinb.description_0"));
		list.add(Component.translatable("item.primogemcraft.skjinb.description_1"));
		list.add(Component.translatable("item.primogemcraft.skjinb.description_2"));
		list.add(Component.translatable("item.primogemcraft.skjinb.description_3"));
		list.add(Component.translatable("item.primogemcraft.skjinb.description_4"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SkjinbisxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}