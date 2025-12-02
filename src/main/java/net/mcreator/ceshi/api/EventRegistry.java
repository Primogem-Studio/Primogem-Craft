package net.mcreator.ceshi.api;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

import java.util.function.BiFunction;

/**
 * 增强版事件系统API
 * 提供完整的事件注册、管理和执行功能
 */
public class EventRegistry {
    /**
     * 注册新事件
     */
    public static void registerEvent(int eventId, BiFunction<LevelAccessor, Entity, Boolean> handler) {
        net.mcreator.ceshi.procedures.Event_item_sxRProcedure.registerEvent(eventId, handler);
    }

    /**
     * 注册新事件组
     */
    public static void registerGroup(int groupId, BiFunction<Entity, LevelAccessor, Boolean> handler) {
        net.mcreator.ceshi.procedures.EventGroupProcedure.registerGroup(groupId, handler);
    }

    /**
     * 注册事件描述
     */
    public static void registerDescription(int eventId, java.util.function.Supplier<String> descriptionProvider) {
        net.mcreator.ceshi.procedures.EventitemmssxrProcedure.registerDescription(eventId, descriptionProvider);
    }

    /**
     * 获取事件上限
     */
    public static int getEventLimit() {
        return net.mcreator.ceshi.procedures.EventGroupProcedure.event_X_limit();
    }

    /**
     * 获取事件组上限
     */
    public static int getGroupLimit() {
        return net.mcreator.ceshi.procedures.EventGroupProcedure.event_limit();
    }

}