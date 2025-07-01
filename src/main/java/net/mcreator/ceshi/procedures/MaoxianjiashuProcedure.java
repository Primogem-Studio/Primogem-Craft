package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class MaoxianjiashuProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
		if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(itemstack.getMaxDamage() - itemstack.getDamageValue());
			itemstack.setDamageValue(itemstack.getMaxDamage());
		} else {
			if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) != 0) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) > 0 && (entity instanceof Player _plr ? _plr.experienceLevel : 0) < 17) {
					entity.getPersistentData().putDouble("jingyan",
							((entity instanceof Player _plr ? _plr.experienceLevel : 0) * (entity instanceof Player _plr ? _plr.experienceLevel : 0) + 6 * (entity instanceof Player _plr ? _plr.experienceLevel : 0)));
				}
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) > 16 && (entity instanceof Player _plr ? _plr.experienceLevel : 0) <= 31) {
					entity.getPersistentData().putDouble("jingyan",
							(2.5 * (entity instanceof Player _plr ? _plr.experienceLevel : 0) * (entity instanceof Player _plr ? _plr.experienceLevel : 0) - 40.5 * (entity instanceof Player _plr ? _plr.experienceLevel : 0) + 360));
				}
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) > 32) {
					entity.getPersistentData().putDouble("jingyan",
							(4.5 * (entity instanceof Player _plr ? _plr.experienceLevel : 0) * (entity instanceof Player _plr ? _plr.experienceLevel : 0) - 162.5 * (entity instanceof Player _plr ? _plr.experienceLevel : 0) + 2220));
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("jingyan")))), false);
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(-(itemstack.getDamageValue()));
				itemstack.setDamageValue((int) ((itemstack.getMaxDamage() - entity.getPersistentData().getDouble("jingyan")) - (itemstack.getMaxDamage() - itemstack.getDamageValue())));
				entity.getPersistentData().putDouble("jingyan", 0);
			}
		}
	}
}