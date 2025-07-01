package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.PrimogemcraftMod;

public class Yimuguo_shuxingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getPersistentData().getBoolean("ymgc_cheng_fa")) {
			PrimogemcraftMod.queueServerWork(20, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7f\u8BE5\u8D70\u4E86"), false);
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), (float) Math.pow(2, 64));
				PrimogemcraftMod.queueServerWork(1, () -> {
					if (entity.getPersistentData().getBoolean("yijieguo_a")) {
						entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), (float) Math.pow(2, 64));
					}
				});
			});
		} else {
			entity.getPersistentData().putBoolean("ymgc_cheng_fa", false);
		}
	}
}