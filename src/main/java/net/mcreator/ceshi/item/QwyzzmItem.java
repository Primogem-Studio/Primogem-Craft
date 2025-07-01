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

import net.mcreator.ceshi.procedures.YzzmsxProcedure;

import java.util.List;

public class QwyzzmItem extends Item {
	public QwyzzmItem() {
		super(new Item.Properties().stacksTo(1).fireResistant());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_0"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_1"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_2"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_3"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_4"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_5"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_6"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_7"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_8"));
		list.add(Component.translatable("item.primogemcraft.qwyzzm.description_9"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		YzzmsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}