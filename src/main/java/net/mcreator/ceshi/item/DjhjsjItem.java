
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class DjhjsjItem extends Item {
	public DjhjsjItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.djhjsj.description_0"));
		list.add(Component.translatable("item.primogemcraft.djhjsj.description_1"));
		list.add(Component.translatable("item.primogemcraft.djhjsj.description_2"));
		list.add(Component.translatable("item.primogemcraft.djhjsj.description_3"));
		list.add(Component.translatable("item.primogemcraft.djhjsj.description_4"));
	}
}
