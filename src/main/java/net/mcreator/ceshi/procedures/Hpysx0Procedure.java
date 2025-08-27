package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Hpysx0Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double n = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		n = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j");
		if (!world.isClientSide()) {
			if (n < 2 + 1 * (a - 3) && !(entity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown(PrimogemcraftModItems.ZZIYOUSONGSHIDUANPIAN.get()))) {
				{
					final String _tagName = "hpy_bd_j";
					final double _tagValue = (n + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(PrimogemcraftModItems.ZZIYOUSONGSHIDUANPIAN.get(), (int) (160 - 20 * a));
			}
		}
	}
}