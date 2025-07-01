package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerWakeUpEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShijianxianzhishuaxinProcedure {
	@SubscribeEvent
	public static void onEntityEndSleep(PlayerWakeUpEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (!world.isClientSide()) {
			PrimogemcraftModVariables.MapVariables.get(world).shijian_xianzhi = 0;
			PrimogemcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}
}