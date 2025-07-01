package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Xyzpsxhs0Procedure {
	public static void execute(Entity entity, ItemStack itemstack, double zhi, String wen) {
		if (entity == null || wen == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(wen), false);
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(PrimogemcraftModItems.XINGQIONG.get()).copy();
			_setstack.setCount((int) zhi);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		itemstack.shrink(1);
	}
}