package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;

public class Jhsbsx0Procedure {
	public static boolean execute(Entity entity, ItemStack item, ItemStack itemstack, double jun_heng, double zhi) {
		if (entity == null)
			return false;
		if (itemstack.getItem() == item.getItem()) {
			if (jun_heng < zhi) {
				{
					PrimogemcraftModVariables.PlayerVariables _vars = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
					_vars.jun_heng = zhi * 1000;
					_vars.syncPlayerVariables(entity);
				}
				return true;
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u5F53\u524D\u77F3\u677F\u6548\u679C\u5DF2\u83B7\u5F97"), false);
			}
		}
		return false;
	}
}