package net.mcreator.ceshi.api;

import net.mcreator.ceshi.procedures.EventGroupProcedure;
import net.mcreator.ceshi.procedures.Event_item_sxRProcedure;
import net.mcreator.ceshi.procedures.EventiProcedure;
import net.mcreator.ceshi.procedures.EventitemmssxrProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 新版事件系统API（基于EventContext模式）
 * 完全抛弃老式BiFunction用法，使用新的EventContext驱动
 */
public class EventRegistry {

    // ========== 事件注册 ==========

    /**
     * 注册新事件（使用EventContext）
     *
     * @param eventId 事件ID
     * @param handler 事件处理器（接收EventContext）
     */
    public static void registerEvent(int eventId, Function<Event_item_sxRProcedure.EventContext, Boolean> handler) {
        registerEventInternal(eventId, handler);
    }

    /**
     * 注册新事件（兼容快捷方式）
     *
     * @param eventId 事件ID
     * @param handler 接收 Player 和 LevelAccessor 的处理器（内部转换为 EventContext）
     */
    public static void registerEventLegacy(int eventId, Function<Player, Function<LevelAccessor, Boolean>> handler) {
        registerEventInternal(eventId, ctx -> handler.apply(ctx.getPlayer()).apply(ctx.getWorld()));
    }

    private static void registerEventInternal(int eventId, Function<Event_item_sxRProcedure.EventContext, Boolean> handler) {
        try {
            var method = Event_item_sxRProcedure.class.getDeclaredMethod("registerEventInternal", int.class, Function.class);
            method.setAccessible(true);
            method.invoke(null, eventId, handler);
        } catch (Exception e) {
            throw new RuntimeException("无法注册事件: " + eventId, e);
        }
    }

    /**
     * 注册新事件组
     *
     * @param groupId 事件组ID
     * @param handler 事件组处理器
     */
    public static void registerGroup(int groupId, Function<EventGroupProcedure.GroupContext, Boolean> handler) {
        EventGroupProcedure.registerGroup(groupId, (entity, world) -> {
            var context = new EventGroupProcedure.GroupContext(entity, world);
            return handler.apply(context);
        });
    }

    /**
     * 注册事件描述
     */
    public static void registerDescription(int eventId, Supplier<String> descriptionProvider) {
        EventitemmssxrProcedure.registerDescription(eventId, descriptionProvider);
    }

    /**
     * 直接产卵事件组
     *
     * @param value 事件组ID
     */
    public static void spawnEventGroup(LevelAccessor world, Entity entity, int value) {
        EventiProcedure.execute(world, 0, -128, 0, entity, value, true);
    }

    public static void spawnEventGroup(LevelAccessor world, Entity entity, int value, boolean count) {
        EventiProcedure.execute(world, 0, -128, 0, entity, value, count);
    }

    public static void spawnEventGroup(LevelAccessor world, double x, double y, double z, Entity entity, int value) {
        EventiProcedure.execute(world, x, y, z, entity, value, true);
    }
    /**
     * 直接产卵事件组
     *
     * @param count 记录并受限？
     * @param value 事件组ID
     */
    public static void spawnEventGroup(LevelAccessor world, double x, double y, double z, Entity entity, int value, boolean count) {
        EventiProcedure.execute(world, x, y, z, entity, value, count);
    }
    /**
     * 直接产卵事件
     */
    public static void spawnEvent(LevelAccessor world, Player player, int value) {
        EventGroupProcedure.execute(world, player, value);
    }


    /**
     * 获取所有已注册的事件ID
     */
    public static List<Integer> getAllEventIds() {
        return Event_item_sxRProcedure.getRegisteredEventIds();
    }

    /**
     * 获取所有已注册的事件组ID
     */
    public static List<Integer> getAllGroupIds() {
        return EventGroupProcedure.getRegisteredGroupIds();
    }

    /**
     * 检查事件是否已注册
     */
    public static boolean isEventRegistered(int eventId) {
        return Event_item_sxRProcedure.isEventRegistered(eventId);
    }

    /**
     * 检查事件组是否已注册
     */
    public static boolean isGroupRegistered(int groupId) {
        return EventGroupProcedure.getRegisteredGroupIds().contains(groupId);
    }

    /**
     * 获取事件数量上限
     */
    public static int getEventLimit() {
        return EventGroupProcedure.event_X_limit();
    }

    /**
     * 获取事件组数量上限
     */
    public static int getGroupLimit() {
        return EventGroupProcedure.event_limit();
    }

    /**
     * 获取已注册事件数量
     */
    public static int getEventCount() {
        return getAllEventIds().size();
    }

    /**
     * 获取已注册事件组数量
     */
    public static int getGroupCount() {
        return getAllGroupIds().size();
    }

    /**
     * 打印所有已注册事件
     */
    public static void printAllEvents() {
        System.out.println("=== 已注册事件列表 ===");
        System.out.println("事件总数: " + getEventCount());
        List<Integer> eventIds = getAllEventIds();
        if (eventIds.isEmpty()) {
            System.out.println("(无注册事件)");
        } else {
            eventIds.forEach(id -> System.out.println("事件ID: " + id));
        }
        System.out.println("=====================");
    }

    /**
     * 打印所有已注册事件组
     */
    public static void printAllGroups() {
        System.out.println("=== 已注册事件组列表 ===");
        System.out.println("事件组总数: " + getGroupCount());
        List<Integer> groupIds = getAllGroupIds();
        if (groupIds.isEmpty()) {
            System.out.println("(无注册事件组)");
        } else {
            groupIds.forEach(id -> System.out.println("事件组ID: " + id));
        }
        System.out.println("=======================");
    }

    /**
     * 随机返回一个已注册的事件ID
     */
    public static int getRandomEventId() {
        List<Integer> eventIds = getAllEventIds();
        if (eventIds.isEmpty()) return 0;
        return eventIds.get((int) (Math.random() * eventIds.size()));
    }

    /**
     * 随机返回一个已注册的事件组ID
     */
    public static int getRandomGroupId() {
        List<Integer> groupIds = getAllGroupIds();
        if (groupIds.isEmpty()) return 0;
        return groupIds.get((int) (Math.random() * groupIds.size()));
    }

    /**
     * 创建EventContext实例
     */
    public static Event_item_sxRProcedure.EventContext createContext(int eventId, Player player, LevelAccessor world) {
        return new Event_item_sxRProcedure.EventContext(eventId, player, world);
    }

    /**
     * 事件组注册器（支持链式调用）
     */
    public static class GroupRegistrar {
        public GroupRegistrar register(int groupId, Function<EventGroupProcedure.GroupContext, Boolean> handler) {
            EventRegistry.registerGroup(groupId, handler);
            return this;
        }
    }
}