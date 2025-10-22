package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Zuoshao_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle minecraft:lava ~ ~1 ~");
			}
		}
		if (net.hackermdch.pgc.Timer.isDone(entity, "zhuo_shao")) {
			a = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.ZHUOSHAO) ? _livEnt.getEffect(PrimogemcraftModMobEffects.ZHUOSHAO).getAmplifier() : 0;
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.LAVA)), (float) Math.max(a * 1, (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * (a + 1) * 0.01));
			net.hackermdch.pgc.Timer.set(entity, "zhuo_shao", 40);
		}
	}
}