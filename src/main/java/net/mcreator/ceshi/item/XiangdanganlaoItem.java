package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.XxiangdangaolaozaibeibaoshiProcedure;
import net.mcreator.ceshi.procedures.XixiangdanganlaoshiyongxiaoguoProcedure;

import java.util.List;

public class XiangdanganlaoItem extends Item {
	public XiangdanganlaoItem() {
		super(new Item.Properties().durability(1).fireResistant().food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible().build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.xiangdanganlao.description_0"));
		list.add(Component.translatable("item.primogemcraft.xiangdanganlao.description_1"));
		list.add(Component.translatable("item.primogemcraft.xiangdanganlao.description_2"));
		list.add(Component.translatable("item.primogemcraft.xiangdanganlao.description_3"));
		list.add(Component.translatable("item.primogemcraft.xiangdanganlao.description_4"));
		list.add(Component.translatable("item.primogemcraft.xiangdanganlao.description_5"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		XixiangdanganlaoshiyongxiaoguoProcedure.execute(world, x, y, z, entity);
		return retval;
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		XxiangdangaolaozaibeibaoshiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}
}