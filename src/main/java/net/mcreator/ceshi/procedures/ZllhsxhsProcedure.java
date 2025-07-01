package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class ZllhsxhsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack, ItemStack tiem0, String zllh_hs_zlpb) {
		if (entity == null || zllh_hs_zlpb == null)
			return;
		double a = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pig.saddle")), SoundSource.PLAYERS, (float) 0.3, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1));
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pig.saddle")), SoundSource.PLAYERS, (float) 0.3, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1), false);
			}
		}
		if (entity.isShiftKeyDown()) {
			a = tiem0.getCount();
			tiem0.shrink((int) a);
			for (int index0 = 0; index0 < (int) a; index0++) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							zllh_hs_zlpb);
			}
		} else {
			tiem0.shrink(1);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), zllh_hs_zlpb);
		}
		DiaoyonghuishouProcedure.execute(entity, itemstack);
	}
}