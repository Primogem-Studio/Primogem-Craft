package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.PrimogemcraftMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SwfengraojiangshiscProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof Zombie) {
				if (Math.random() < (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV)) * 0.01) {
					PrimogemcraftMod.queueServerWork(1, () -> {
						if (!entity.level().isClientSide())
							entity.discard();
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = PrimogemcraftModEntities.S_WFENGRAOJIANGSHI.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					});
				}
			}
		}
	}
}