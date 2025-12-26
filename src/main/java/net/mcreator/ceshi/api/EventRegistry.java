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

public class EventRegistry {
    /**
     * \\\\\\\\\以 防 真 有 人 看 ! !/////////
     * @本API大部分由AI完成，不一定所有功能有效！！
     * @关于ID注册规范（可选但最好遵循）：
     * @事件ID： modID前 4 个字母的字母顺序：@例：primogem... -> 1618913 开始避免冲突
     * @事件组ID： modID前 3 个字母的字母顺序：@例：primogem... -> 16189 开始避免冲突（不会与事件ID冲突，即使重合）
     * @事件描述ID： 与事件ID一致
     */

    /**
     * 注册新事件
     */
    public static void registerEvent(int eventId, Function<Event_item_sxRProcedure.EventContext, Boolean> handler) {
        registerEventInternal(eventId, handler);
    }

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
     * 注册新事件组（默认权重为1）
     */
    public static void registerGroup(int groupId, Function<EventGroupProcedure.GroupContext, Boolean> handler) {
        EventGroupProcedure.registerGroup(groupId, (entity, world) -> {
            var context = new EventGroupProcedure.GroupContext(entity, world);
            return handler.apply(context);
        });
    }

    /**
     * 注册新事件组（带权重参数）
     */
    public static void registerGroup(int groupId, Function<EventGroupProcedure.GroupContext, Boolean> handler, int weight) {
        EventGroupProcedure.registerGroup(groupId, (entity, world) -> {
            var context = new EventGroupProcedure.GroupContext(entity, world);
            return handler.apply(context);
        }, weight);
    }

    public static void registerDescription(int eventId, Supplier<String> descriptionProvider) {
        EventitemmssxrProcedure.registerDescription(eventId, descriptionProvider);
    }

    /**
     * 直接产卵事件组
     *
     * @param count 记录并受限？
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

    public static void spawnEventGroup(LevelAccessor world, double x, double y, double z, Entity entity, int value, boolean count) {
        EventiProcedure.execute(world, x, y, z, entity, value, count);
    }

    /**
     * 直接产卵事件
     */

    public static void spawnEvent(LevelAccessor world, Player player, int value) {
        EventGroupProcedure.execute(world, player, value);
    }

    public static List<Integer> getAllEventIds() {
        return Event_item_sxRProcedure.getRegisteredEventIds();
    }

    public static List<Integer> getAllGroupIds() {
        return EventGroupProcedure.getRegisteredGroupIds();
    }

    public static boolean isEventRegistered(int eventId) {
        return Event_item_sxRProcedure.isEventRegistered(eventId);
    }

    public static boolean isGroupRegistered(int groupId) {
        return EventGroupProcedure.getRegisteredGroupIds().contains(groupId);
    }

    public static int getEventLimit() {
        return EventGroupProcedure.event_X_limit();
    }

    public static int getGroupLimit() {
        return EventGroupProcedure.event_limit();
    }

    public static int getEventCount() {
        return getAllEventIds().size();
    }

    public static int getGroupCount() {
        return getAllGroupIds().size();
    }

    /**
     * 获取事件组的权重
     */
    public static int getGroupWeight(int groupId) {
        return EventGroupProcedure.getGroupWeight(groupId);
    }

    /**
     * 根据权重随机选择事件组ID
     */
    public static int getWeightedRandomGroupId(LevelAccessor world) {
        return EventGroupProcedure.getWeightedRandomGroupId(world);
    }

    /**
     * 获取随机事件组ID
     */
    public static int getRandomGroupId(LevelAccessor world) {
        return EventGroupProcedure.getRandomGroupId(world);
    }

    /**
     * 获取指定范围内的随机事件组ID
     */
    public static int getRandomGroupId(LevelAccessor world, int minGroupId, int maxGroupId) {
        return EventGroupProcedure.getRandomGroupId(world, minGroupId, maxGroupId);
    }

    /**
     * 随机返回一个已注册的事件ID
     */
    public static int getRandomEventId() {
        List<Integer> eventIds = getAllEventIds();
        if (eventIds.isEmpty()) return 0;
        return eventIds.get((int) (Math.random() * eventIds.size()));
    }

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

        public GroupRegistrar register(int groupId, Function<EventGroupProcedure.GroupContext, Boolean> handler, int weight) {
            EventRegistry.registerGroup(groupId, handler, weight);
            return this;
        }
    }
}