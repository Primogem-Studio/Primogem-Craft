package net.mcreator.ceshi.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CaoyuanheItem extends Item {
	public CaoyuanheItem() {
		super(new Item.Properties().rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(4).saturationModifier(2f).alwaysEdible().build()));
	}
}