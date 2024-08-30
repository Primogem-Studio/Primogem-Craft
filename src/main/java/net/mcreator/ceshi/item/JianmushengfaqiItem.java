
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

import net.mcreator.ceshi.procedures.ShengfaqishuxingProcedure;

import java.util.List;

public class JianmushengfaqiItem extends Item {
	public JianmushengfaqiItem() {
		super(new Item.Properties().durability(11).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u53F3\u952E\u63D0\u9AD8\u9B54\u9634\u8EAB\u751F\u6210\u6982\u7387"));
		list.add(Component.literal("\u00A77\u6F5C\u884C+\u53F3\u952E\u964D\u4F4E\u9B54\u9634\u8EAB\u751F\u6210\u6982\u7387"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ShengfaqishuxingProcedure.execute(world, entity, ar.getObject());
		return ar;
	}
}
