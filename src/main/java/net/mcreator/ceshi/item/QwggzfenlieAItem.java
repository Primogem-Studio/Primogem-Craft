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

import net.mcreator.ceshi.procedures.Flggz_sx_1Procedure;

import java.util.List;

public class QwggzfenlieAItem extends Item {
	public QwggzfenlieAItem() {
		super(new Item.Properties().durability(1396));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_0"));
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_1"));
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_2"));
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_3"));
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_4"));
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_5"));
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_6"));
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_7"));
		list.add(Component.translatable("item.primogemcraft.qwggzfenlie_a.description_8"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Flggz_sx_1Procedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}