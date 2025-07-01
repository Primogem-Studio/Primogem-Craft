package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.procedures.Zhapianding_tuozhan_1Procedure;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.List;

public class ZhapiandingzhengshiItem extends Item {
	public ZhapiandingzhengshiItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "zhapiandingzhengshi"))));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.zhapiandingzhengshi.description_0"));
		list.add(Component.translatable("item.primogemcraft.zhapiandingzhengshi.description_1"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Zhapianding_tuozhan_1Procedure.execute();
		return InteractionResult.SUCCESS;
	}
}