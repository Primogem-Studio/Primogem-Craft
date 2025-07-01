package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.LjtchenshouProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

public class Ljtg01Item extends ShieldItem {
	public Ljtg01Item() {
		super(new Item.Properties().durability(200));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(PrimogemcraftModItems.LAJITONGSUIPIAN.get()), new ItemStack(PrimogemcraftModItems.JLZA.get())).test(repairitem);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.ljtg_01.description_0"));
		list.add(Component.translatable("item.primogemcraft.ljtg_01.description_1"));
		list.add(Component.translatable("item.primogemcraft.ljtg_01.description_2"));
		list.add(Component.translatable("item.primogemcraft.ljtg_01.description_3"));
		list.add(Component.translatable("item.primogemcraft.ljtg_01.description_4"));
		list.add(Component.translatable("item.primogemcraft.ljtg_01.description_5"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		LjtchenshouProcedure.execute(world, entity, itemstack);
	}
}