package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.LetouchaxunProcedure;
import net.mcreator.ceshi.procedures.DadaletoushibiezhuangtaiProcedure;

import java.util.List;

public class YiyinhedaletouItem extends Item {
	public YiyinhedaletouItem() {
		super(new Item.Properties().durability(2).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_0"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_1"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_2"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_3"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_4"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_5"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_6"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_7"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_8"));
		list.add(Component.translatable("item.primogemcraft.yiyinhedaletou.description_9"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		LetouchaxunProcedure.execute(world, entity, ar.getObject());
		return ar;
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		DadaletoushibiezhuangtaiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}
}