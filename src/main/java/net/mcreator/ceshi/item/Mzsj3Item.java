package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class Mzsj3Item extends Item {
	public Mzsj3Item() {
		super(new Item.Properties().fireResistant().rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.mzsj_3.description_0"));
		list.add(Component.translatable("item.primogemcraft.mzsj_3.description_1"));
		list.add(Component.translatable("item.primogemcraft.mzsj_3.description_2"));
		list.add(Component.translatable("item.primogemcraft.mzsj_3.description_3"));
		list.add(Component.translatable("item.primogemcraft.mzsj_3.description_4"));
	}
}