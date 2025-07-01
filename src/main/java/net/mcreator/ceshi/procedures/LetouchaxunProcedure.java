package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.PrimogemcraftMod;

public class LetouchaxunProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (!entity.getPersistentData().getBoolean("letouchaxun_lengque")) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList()
							.broadcastSystemMessage(Component.literal(("\u00A7d\u5168\u5458\u6D88\u606F\uFF1A\u00A77\u73A9\u5BB6\u00A7f<" + entity.getDisplayName().getString() + ">\u00A77\u73B0\u603B\u5171\u00A7c\u635F\u574F\u8FC7\u00A7a"
									+ new java.text.DecimalFormat("##.##").format(entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).daletou_jishu) + "\u00A7c\u5F20 \u00A7b\u94F6\u6CB3\u5927\u4E50\u900F\uFF01")), false);
				entity.getPersistentData().putBoolean("letouchaxun_lengque", true);
				PrimogemcraftMod.queueServerWork(1200, () -> {
					entity.getPersistentData().putBoolean("letouchaxun_lengque", false);
				});
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77\u73B0\u603B\u5171\u00A7c\u635F\u574F\u8FC7\u00A7a" + new java.text.DecimalFormat("##.##").format(entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).daletou_jishu)
							+ "\u00A7c\u5F20 \u00A7b\u94F6\u6CB3\u5927\u4E50\u900F\uFF01")), false);
			}
		}
	}
}