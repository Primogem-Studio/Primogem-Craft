package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.ceshi.PrimogemcraftMod;

public class BaiseshitishengchengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		PrimogemcraftMod.queueServerWork(40, () -> {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y - 64), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y - 64), z, _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
		});
	}
}