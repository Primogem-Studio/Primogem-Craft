package net.mcreator.ceshi.procedures;

import net.per.wish.WishVale;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class QyhxcxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		ItemStack i = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			i = itemstack;
			i = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			if (!(i.getItem() == Blocks.AIR.asItem())) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(("\u00A75\u5F53\u524D\u526F\u624B\u7269\u54C1\u603B\u5171\u53EF\u63D0\u4F9B\u00A7b" + new java.text.DecimalFormat("").format(WishVale.getItemWishVale(i)) + "\u00A75\u70B9\u7948\u613F\u503C")), false);
			}
		}
	}
}