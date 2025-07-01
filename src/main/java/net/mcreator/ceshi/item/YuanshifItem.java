package net.mcreator.ceshi.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class YuanshifItem extends Item {
	public YuanshifItem() {
		super(new Item.Properties().rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0.1f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 10;
	}
}