package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Ljtg2sxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

public class Ljtg02Item extends ShieldItem {
	public Ljtg02Item() {
		super(new Item.Properties().durability(1500));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(PrimogemcraftModItems.JLZA.get()), new ItemStack(Items.IRON_INGOT)).test(repairitem);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.ljtg_02.description_0"));
		list.add(Component.translatable("item.primogemcraft.ljtg_02.description_1"));
		list.add(Component.translatable("item.primogemcraft.ljtg_02.description_2"));
		list.add(Component.translatable("item.primogemcraft.ljtg_02.description_3"));
		list.add(Component.translatable("item.primogemcraft.ljtg_02.description_4"));
		list.add(Component.translatable("item.primogemcraft.ljtg_02.description_5"));
		list.add(Component.translatable("item.primogemcraft.ljtg_02.description_6"));
		list.add(Component.translatable("item.primogemcraft.ljtg_02.description_7"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Ljtg2sxProcedure.execute(world, entity, itemstack);
	}
}