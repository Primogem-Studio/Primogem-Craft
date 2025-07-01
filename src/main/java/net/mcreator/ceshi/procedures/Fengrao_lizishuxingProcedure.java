package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Fengrao_lizishuxingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
			}
		}
		if (Math.random() < 0.2) {
			if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(PrimogemcraftModMobEffects.FENGRAO)) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("/particle primogemcraft:moyin " + (("~" + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)) + " ~ " + ("~" + Mth.nextDouble(RandomSource.create(), -0.1, 0.1))) + " 0 1 1 0.25 5 normal"));
					}
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(PrimogemcraftModMobEffects.HSLGGZFUZHIPIN) && !(entity instanceof Player)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.FENGRAO);
		}
	}
}