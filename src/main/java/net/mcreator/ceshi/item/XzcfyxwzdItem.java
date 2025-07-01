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

import net.mcreator.ceshi.procedures.Ljtg3sxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

public class XzcfyxwzdItem extends ShieldItem {
	public XzcfyxwzdItem() {
		super(new Item.Properties().durability(2048).fireResistant());
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(PrimogemcraftModItems.JINZHIMOLA.get()), new ItemStack(PrimogemcraftModItems.JLLIANG.get())).test(repairitem);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.xzcfyxwzd.description_0"));
		list.add(Component.translatable("item.primogemcraft.xzcfyxwzd.description_1"));
		list.add(Component.translatable("item.primogemcraft.xzcfyxwzd.description_2"));
		list.add(Component.translatable("item.primogemcraft.xzcfyxwzd.description_3"));
		list.add(Component.translatable("item.primogemcraft.xzcfyxwzd.description_4"));
		list.add(Component.translatable("item.primogemcraft.xzcfyxwzd.description_5"));
		list.add(Component.translatable("item.primogemcraft.xzcfyxwzd.description_6"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Ljtg3sxProcedure.execute(world, entity, itemstack);
	}
}