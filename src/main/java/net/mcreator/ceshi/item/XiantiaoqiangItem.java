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

import net.mcreator.ceshi.procedures.XiantiaoqiangjixuxiaoguoProcedure;

import java.util.List;

public class XiantiaoqiangItem extends Item {
	public XiantiaoqiangItem() {
		super(new Item.Properties().stacksTo(8).fireResistant().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.8f).alwaysEdible().build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.xiantiaoqiang.description_0"));
		list.add(Component.translatable("item.primogemcraft.xiantiaoqiang.description_1"));
		list.add(Component.translatable("item.primogemcraft.xiantiaoqiang.description_2"));
		list.add(Component.translatable("item.primogemcraft.xiantiaoqiang.description_3"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		XiantiaoqiangjixuxiaoguoProcedure.execute(entity);
		return retval;
	}
}