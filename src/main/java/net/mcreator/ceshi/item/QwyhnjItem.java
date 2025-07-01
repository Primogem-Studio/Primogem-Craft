package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.QwyhnjsxProcedure;

import java.util.List;

public class QwyhnjItem extends Item {
	public QwyhnjItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.qwyhnj.description_0"));
		list.add(Component.translatable("item.primogemcraft.qwyhnj.description_1"));
		list.add(Component.translatable("item.primogemcraft.qwyhnj.description_2"));
		list.add(Component.translatable("item.primogemcraft.qwyhnj.description_3"));
		list.add(Component.translatable("item.primogemcraft.qwyhnj.description_4"));
		list.add(Component.translatable("item.primogemcraft.qwyhnj.description_5"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		QwyhnjsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}