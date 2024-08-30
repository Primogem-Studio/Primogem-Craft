
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ZhzhenyinhedaletouItem extends Item {
	public ZhzhenyinhedaletouItem() {
		super(new Item.Properties().durability(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A74\u4E00\u751F\u4E00\u6B21\u673A\u4F1A"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A7a\u526F\u624B\u6301\u6709\u65F6\uFF1A"));
		list.add(Component.literal("\u00A7d\u7834\u574F\u7F50\u5B50\uFF1A"));
		list.add(Component.literal("\u00A7a - \u5C0F\u6982\u7387\u83B7\u5F97\u5947\u7269"));
		list.add(Component.literal("\u00A7c - \u5927\u6982\u7387\u4F7F\u81EA\u8EAB\u751F\u547D\u503C\u4FDD\u6301\u81F31\u70B9"));
	}
}
