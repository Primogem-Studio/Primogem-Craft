package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Yjsx2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
							new Vec3((entity.getX() + Mth.nextDouble(RandomSource.create(), -2, 2)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 3)), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2))), Vec2.ZERO, _level, 4,
							"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle dust 200.0 0.0 0.0 3.0");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
							new Vec3((entity.getX() + Mth.nextDouble(RandomSource.create(), -2, 2)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 1, 4)), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2))), Vec2.ZERO, _level, 4,
							"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle dust 200.0 0.0 0.0 3.0");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
							new Vec3((entity.getX() + Mth.nextDouble(RandomSource.create(), -2, 2)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 3)), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2))), Vec2.ZERO, _level, 4,
							"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle dust 100.0 0.0 0.0 1.0");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
							new Vec3((entity.getX() + Mth.nextDouble(RandomSource.create(), -2, 2)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 1, 4)), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2))), Vec2.ZERO, _level, 4,
							"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle dust 100.0 0.0 0.0 1.0");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
							new Vec3((entity.getX() + Mth.nextDouble(RandomSource.create(), -2, 2)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 3)), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2))), Vec2.ZERO, _level, 4,
							"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle dust 150.0 0.0 0.0 2.0");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
							new Vec3((entity.getX() + Mth.nextDouble(RandomSource.create(), -2, 2)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 1, 4)), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2))), Vec2.ZERO, _level, 4,
							"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle dust 150.0 0.0 0.0 2.0");
	}
}