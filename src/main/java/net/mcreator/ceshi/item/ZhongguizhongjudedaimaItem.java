
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.FumianqiwufaguangProcedure;
import net.mcreator.ceshi.procedures.Daima3shuxingProcedure;

import java.util.List;

public class ZhongguizhongjudedaimaItem extends Item {
	public ZhongguizhongjudedaimaItem() {
		super(new Item.Properties().durability(31).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return FumianqiwufaguangProcedure.execute(itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u5C06\u8FD9\u6BB5\u4EE3\u7801\u4FEE\u590D\u6210\u6B63\u5E38\u7684\u5947\u7269\u9700\u8981"));
		list.add(Component.literal("\u00A77\u51FB\u674030\u53EA\u751F\u7269"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A77\u4FEE\u590D\u671F\u95F4\uFF1A"));
		list.add(Component.literal("\u00A72\u73A9\u5BB6\u88AB\u653B\u51FB\u4E14\u751F\u547D\u503C\u4F4E\u4E8E50%\u65F6"));
		list.add(Component.literal("\u00A72\u53D7\u5230\u989D\u5916\u4F24\u5BB3"));
		list.add(Component.literal("\u00A77\u4EE3\u7801\u4FEE\u590D\u540E\uFF1A"));
		list.add(Component.literal("\u00A72\u6709\u5C0F\u6982\u7387\u514D\u75AB\u4E00\u6B21\u653B\u51FB"));
		list.add(Component.literal("\u00A72\u6301\u7EED\u5230\u589E\u76CA\u7ED3\u675F"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Daima3shuxingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
