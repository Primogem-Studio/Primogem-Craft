package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class FtkxsxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean o1 = false;
		double n1 = 0;
		n1 = entity.getPersistentData().getDouble("zzss_kj_hjxz");
		int n2 = (int) n1 + (n1 < 4 ? 1 : -3);
		String s1 = ysrz_ms(n2);
		entity.getPersistentData().putDouble("zzss_kj_hjxz", n2);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A77\u81EA\u5728\u677E\u77F3\u6548\u679C  " + s1)), false);
	}

	public static String ysrz_ms(int n2) {
		return switch (n2) {
			case 1 -> "§c禁用 §f缓降";
			case 2 -> "§c禁用 §b跳跃提升";
			case 3 -> "§c仅飞行 §9如果满足";
			case 4 -> "§a全部启用";
			default -> "§f暂未设定";
		};
	}
}