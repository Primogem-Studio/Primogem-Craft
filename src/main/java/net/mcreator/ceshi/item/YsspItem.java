package net.mcreator.ceshi.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class YsspItem extends Item {
	public YsspItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).saturationModifier(0.2f).alwaysEdible().build()));
	}
}