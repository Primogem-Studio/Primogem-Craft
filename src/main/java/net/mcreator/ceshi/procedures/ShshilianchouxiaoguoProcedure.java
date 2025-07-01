package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.PrimogemcraftMod;

public class ShshilianchouxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double R_radius = 0;
		double D_delta_theta = 0;
		double T_theta = 0;
		double N_number = 0;
		if (!world.isClientSide()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:shilianyinpin")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:shilianyinpin")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PrimogemcraftModEntities.BAIGUANGGUODUSHENGWU.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			entity.getPersistentData().putDouble("shilian_x", x);
			entity.getPersistentData().putDouble("shilian_y", y);
			entity.getPersistentData().putDouble("shilian_z", z);
			entity.getPersistentData().putDouble("bu_chong", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 10));
			itemstack.shrink(1);
			PrimogemcraftMod.queueServerWork(40, () -> {
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getPersistentData().getDouble("shilian_x")), (entity.getPersistentData().getDouble("shilian_y")), (entity.getPersistentData().getDouble("shilian_z")));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("shilian_x")), (entity.getPersistentData().getDouble("shilian_y")), (entity.getPersistentData().getDouble("shilian_z")), _ent.getYRot(), _ent.getXRot());
				}
				entity.getPersistentData().putDouble("chouka", 10);
				entity.getPersistentData().putDouble("chouka_jiacheng", 10);
				entity.getPersistentData().putDouble("Prayers_strengthen", (entity.getPersistentData().getDouble("bu_chong")));
				ShilianhsProcedure.execute(world, x, y, z);
			});
		}
	}
}