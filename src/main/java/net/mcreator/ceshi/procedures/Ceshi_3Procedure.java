package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.g;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class Ceshi_3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		Entity e = null;
		boolean o1 = false;
		o1 = world instanceof ServerLevel _level0 && _level0.isVillage(BlockPos.containing(x, y, z));
		e = entity;
		//!!!对于附属模组的随机事件即组的注册实例！！！！
		init();//调用注册器
		EventGroupProcedure.execute(world, entity, 20);//为实体打开20号事件组
		java.util.List<Integer> g = net.mcreator.ceshi.procedures.EventGroupProcedure.getRegisteredGroupIds();
		System.out.println(g);//这两行不管！！
	}

	public static void init() {
		// 直接调用主模组的注册方法
		net.mcreator.ceshi.procedures.Event_item_sxRProcedure.registerEvent(100, (world, entity) -> {
			// 附属模组自定义事件逻辑
			if (entity instanceof Player player) {
				player.displayClientMessage(Component.literal("附属模组事件触发！"), false);
				// 添加附属模组特有的逻辑
				return true;
			}
			return false;
		});
		// 注册附属模组的事件组
		net.mcreator.ceshi.procedures.EventGroupProcedure.registerGroup(20, (entity, world) -> {
			// 使用主模组的zu方法
			return net.mcreator.ceshi.procedures.EventGroupProcedure.zu(entity, 100, 101, 102, "§a附属模组事件");
		});
		// 注册事件描述
		net.mcreator.ceshi.procedures.EventitemmssxrProcedure.registerDescription(100, () -> "§e附属模组特殊事件\n§b提供独特奖励");
	}
}