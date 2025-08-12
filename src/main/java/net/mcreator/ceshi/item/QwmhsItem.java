package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Qwmhs_sx_0Procedure;
import net.mcreator.ceshi.procedures.Qw_mhs_sx_1Procedure;

import java.util.List;

public class QwmhsItem extends Item {
	public QwmhsItem() {
		super(new Item.Properties().durability(10));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.qwmhs.description_0"));
		list.add(Component.translatable("item.primogemcraft.qwmhs.description_1"));
		list.add(Component.translatable("item.primogemcraft.qwmhs.description_2"));
		list.add(Component.translatable("item.primogemcraft.qwmhs.description_3"));
		list.add(Component.translatable("item.primogemcraft.qwmhs.description_4"));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		Qwmhs_sx_0Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Qw_mhs_sx_1Procedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}