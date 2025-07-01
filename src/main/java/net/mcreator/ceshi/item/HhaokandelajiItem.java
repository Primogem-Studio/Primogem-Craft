package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.HhaokanlajishuxingProcedure;

import java.util.List;

public class HhaokandelajiItem extends Item {
	public HhaokandelajiItem() {
		super(new Item.Properties().rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).alwaysEdible().build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.hhaokandelaji.description_0"));
		list.add(Component.translatable("item.primogemcraft.hhaokandelaji.description_1"));
		list.add(Component.translatable("item.primogemcraft.hhaokandelaji.description_2"));
		list.add(Component.translatable("item.primogemcraft.hhaokandelaji.description_3"));
		list.add(Component.translatable("item.primogemcraft.hhaokandelaji.description_4"));
		list.add(Component.translatable("item.primogemcraft.hhaokandelaji.description_5"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		HhaokanlajishuxingProcedure.execute(entity);
		return retval;
	}
}