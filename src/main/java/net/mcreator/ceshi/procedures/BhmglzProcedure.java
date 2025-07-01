package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.hackermdch.pgc.network.ParticlePacket;

public class BhmglzProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double y = 0;
		double z = 0;
		if (entity.getPersistentData().getBoolean("lizi")) {
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
			if (entity.level() instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new ParticlePacket(0, x, y, z));
			entity.getPersistentData().putBoolean("lizi", false);
		}
	}
}