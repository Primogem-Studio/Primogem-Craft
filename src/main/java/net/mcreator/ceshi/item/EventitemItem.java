package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.ceshi.procedures.Event_item_sxRProcedure;

public class EventitemItem extends Item {
	public EventitemItem() {
		super(new Item.Properties().stacksTo(1).fireResistant());
	}

	@Override
	public boolean isPiglinCurrency(ItemStack stack) {
		return true;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Event_item_sxRProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}