package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class Qhmbmlys02Item extends Item {
	public Qhmbmlys02Item() {
		super(new Item.Properties().fireResistant());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.qhmbmlys_02.description_0"));
		list.add(Component.translatable("item.primogemcraft.qhmbmlys_02.description_1"));
		list.add(Component.translatable("item.primogemcraft.qhmbmlys_02.description_2"));
		list.add(Component.translatable("item.primogemcraft.qhmbmlys_02.description_3"));
		list.add(Component.translatable("item.primogemcraft.qhmbmlys_02.description_4"));
		list.add(Component.translatable("item.primogemcraft.qhmbmlys_02.description_5"));
	}
}