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

import net.mcreator.ceshi.procedures.LajizunyanProcedure;

import java.util.List;

public class LajitongzunyanItem extends Item {
	public LajitongzunyanItem() {
		super(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible().build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.lajitongzunyan.description_0"));
		list.add(Component.translatable("item.primogemcraft.lajitongzunyan.description_1"));
		list.add(Component.translatable("item.primogemcraft.lajitongzunyan.description_2"));
		list.add(Component.translatable("item.primogemcraft.lajitongzunyan.description_3"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		LajizunyanProcedure.execute(entity);
		return retval;
	}
}