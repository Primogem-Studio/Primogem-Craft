package net.mcreator.ceshi.api;

import net.mcreator.ceshi.procedures.Event_item_sxRProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 增强版事件系统API
 * 提供完整的事件注册、管理和执行功能
 */
public class EventRegistry {

    // ========== 基础API（保持向后兼容） ==========

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

    // ========== 新API ==========

    /**
     * 事件构建器 - 提供流畅的事件创建API
     */
    public static class EventBuilder {
        private final int id;
        private String name = "未命名事件";
        private String description = "";
        private int weight = 1; // 默认权重
        private int cooldown = 0; // 冷却时间（ticks）
        private boolean canRepeat = true; // 是否可重复触发
        private boolean requiresPlayer = true; // 是否需要玩家
        private Consumer<Event_item_sxRProcedure.EventContext> action;
        private BiConsumer<Event_item_sxRProcedure.EventContext, ItemStack> consumeAction;
        private Function<Event_item_sxRProcedure.EventContext, Boolean> condition;

        private EventBuilder(int id) {
            this.id = id;
        }

        public static EventBuilder create(int id) {
            return new EventBuilder(id);
        }

        public static EventBuilder create(String prefix, int sequentialId) {
            // 生成基于前缀的ID（避免冲突）
            int hashId = Math.abs(prefix.hashCode() % 10000) * 1000 + sequentialId;
            return new EventBuilder(hashId);
        }

        public EventBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EventBuilder description(String description) {
            this.description = description;
            return this;
        }

        public EventBuilder weight(int weight) {
            this.weight = Math.max(1, weight);
            return this;
        }

        public EventBuilder cooldown(int ticks) {
            this.cooldown = Math.max(0, ticks);
            return this;
        }

        public EventBuilder repeatable(boolean repeatable) {
            this.canRepeat = repeatable;
            return this;
        }

        public EventBuilder requiresPlayer(boolean requires) {
            this.requiresPlayer = requires;
            return this;
        }

        public EventBuilder action(Consumer<Event_item_sxRProcedure.EventContext> action) {
            this.action = action;
            return this;
        }

        public EventBuilder action(BiConsumer<Event_item_sxRProcedure.EventContext, ItemStack> consumeAction) {
            this.consumeAction = consumeAction;
            return this;
        }

        public EventBuilder condition(Function<Event_item_sxRProcedure.EventContext, Boolean> condition) {
            this.condition = condition;
            return this;
        }

        /**
         * 注册构建好的事件
         */
        public EventBuilder register() {
            // 注册事件处理逻辑
            EventRegistry.registerEvent(id, (world, entity) -> {
                if (requiresPlayer && !(entity instanceof Player)) {
                    return false;
                }

                Event_item_sxRProcedure.EventContext context = new Event_item_sxRProcedure.EventContext(id, entity, world, ItemStack.EMPTY);

                // 检查条件
                if (condition != null && !condition.apply(context)) {
                    return false;
                }

                // 执行动作
                if (action != null) {
                    action.accept(context);
                }

                // 返回是否成功
                return true;
            });

            // 注册描述
            EventRegistry.registerDescription(id, () ->
                    String.format("§6%s\n§7%s\n§8权重: %d | ID: %d", name, description, weight, id)
            );

            // 记录事件信息（用于后续查询）
            EventInfo info = new EventInfo(id, name, description, weight);
            eventRegistry.put(id, info);

            return this;
        }

        /**
         * 注册并返回事件ID
         */
        public int registerAndGetId() {
            register();
            return id;
        }
    }

    /**
     * 事件组构建器
     */
    public static class GroupBuilder {
        private final int id;
        private String name = "未命名事件组";
        private int[] events = new int[3];
        private String displayName = "§f事件";
        private int weight = 1;
        private int minLevel = 0; // 最小玩家等级
        private int maxLevel = Integer.MAX_VALUE; // 最大玩家等级

        private GroupBuilder(int id) {
            this.id = id;
        }

        public static GroupBuilder create(int id) {
            return new GroupBuilder(id);
        }

        public GroupBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GroupBuilder events(int event1, int event2, int event3) {
            this.events[0] = event1;
            this.events[1] = event2;
            this.events[2] = event3;
            return this;
        }

        public GroupBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public GroupBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public GroupBuilder levelRange(int min, int max) {
            this.minLevel = min;
            this.maxLevel = max;
            return this;
        }

        public GroupBuilder register() {
            EventRegistry.registerGroup(id, (entity, world) -> {
                // 等级检查
                if (entity instanceof Player player) {
                    int playerLevel = player.experienceLevel;
                    if (playerLevel < minLevel || playerLevel > maxLevel) {
                        return false;
                    }
                }

                // 使用事件组上下文
                net.mcreator.ceshi.procedures.EventGroupProcedure.GroupContext context =
                        new net.mcreator.ceshi.procedures.EventGroupProcedure.GroupContext(entity, world);
                return context.zu(events[0], events[1], events[2], displayName);
            });

            // 记录组信息
            GroupInfo info = new GroupInfo(id, name, events, weight, minLevel, maxLevel);
            groupRegistry.put(id, info);

            return this;
        }
    }

    // ========== 事件上下文增强 ==========

    /**
     * 增强版事件上下文（继承自原有上下文）
     */
    public static class EnhancedEventContext
            extends net.mcreator.ceshi.procedures.Event_item_sxRProcedure.EventContext {

        private final long triggerTime;
        private final UUID playerUUID;
        private Map<String, Object> customData;

        public EnhancedEventContext(int id, Entity entity, LevelAccessor world, ItemStack itemstack) {
            super(id, entity, world, itemstack);
            this.triggerTime = System.currentTimeMillis();
            this.playerUUID = entity instanceof Player ? entity.getUUID() : null;
            this.customData = new HashMap<>();
        }

        public long getTriggerTime() {
            return triggerTime;
        }

        public UUID getPlayerUUID() {
            return playerUUID;
        }

        public void setData(String key, Object value) {
            customData.put(key, value);
        }

        @SuppressWarnings("unchecked")
        public <T> T getData(String key, T defaultValue) {
            return (T) customData.getOrDefault(key, defaultValue);
        }

        public boolean hasData(String key) {
            return customData.containsKey(key);
        }
        /**
         * 检查事件是否在冷却中
         */
        public boolean isOnCooldown(String cooldownKey) {
            if (getPlayer() == null) return false;
            String key = "event_cooldown_" + getId() + "_" + cooldownKey;
            long lastTime = getPlayer().getPersistentData().getLong(key);
            return System.currentTimeMillis() - lastTime < 5000; // 5秒冷却
        }

        /**
         * 设置冷却
         */
        public void setCooldown(String cooldownKey) {
            if (getPlayer() != null) {
                String key = "event_cooldown_" + getId() + "_" + cooldownKey;
                getPlayer().getPersistentData().putLong(key, System.currentTimeMillis());
            }
        }
    }

    // ========== 管理功能 ==========

    private static final Map<Integer, EventInfo> eventRegistry = new HashMap<>();
    private static final Map<Integer, GroupInfo> groupRegistry = new HashMap<>();
    private static final Map<String, EventCategory> categories = new HashMap<>();

    /**
     * 事件信息记录
     */
    public static class EventInfo {
        public final int id;
        public final String name;
        public final String description;
        public final int weight;
        public int triggerCount = 0;
        public String category = "default";

        public EventInfo(int id, String name, String description, int weight) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.weight = weight;
        }
    }

    /**
     * 事件组信息记录
     */
    public static class GroupInfo {
        public final int id;
        public final String name;
        public final int[] events;
        public final int weight;
        public final int minLevel;
        public final int maxLevel;
        public int triggerCount = 0;

        public GroupInfo(int id, String name, int[] events, int weight, int minLevel, int maxLevel) {
            this.id = id;
            this.name = name;
            this.events = events;
            this.weight = weight;
            this.minLevel = minLevel;
            this.maxLevel = maxLevel;
        }
    }

    /**
     * 事件分类
     */
    public static class EventCategory {
        public final String name;
        public final String colorCode;
        public final List<Integer> eventIds = new ArrayList<>();

        public EventCategory(String name, String colorCode) {
            this.name = name;
            this.colorCode = colorCode;
        }

        public void addEvent(int eventId) {
            if (!eventIds.contains(eventId)) {
                eventIds.add(eventId);
                EventInfo info = eventRegistry.get(eventId);
                if (info != null) {
                    info.category = name;
                }
            }
        }
    }

    /**
     * 创建事件分类
     */
    public static EventCategory createCategory(String name, String colorCode) {
        EventCategory category = new EventCategory(name, colorCode);
        categories.put(name, category);
        return category;
    }

    /**
     * 获取事件分类
     */
    public static EventCategory getCategory(String name) {
        return categories.get(name);
    }

    /**
     * 获取所有事件分类
     */
    public static Collection<EventCategory> getAllCategories() {
        return categories.values();
    }

    /**
     * 记录事件触发
     */
    public static void recordEventTrigger(int eventId) {
        EventInfo info = eventRegistry.get(eventId);
        if (info != null) {
            info.triggerCount++;
        }
    }

    /**
     * 记录事件组触发
     */
    public static void recordGroupTrigger(int groupId) {
        GroupInfo info = groupRegistry.get(groupId);
        if (info != null) {
            info.triggerCount++;
        }
    }

    /**
     * 获取事件触发统计
     */
    public static Map<String, Object> getEventStatistics() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalEvents", eventRegistry.size());
        stats.put("totalGroups", groupRegistry.size());
        stats.put("totalTriggers", eventRegistry.values().stream().mapToInt(e -> e.triggerCount).sum());
        stats.put("mostTriggeredEvent", eventRegistry.values().stream()
                .max(Comparator.comparingInt(e -> e.triggerCount))
                .map(e -> e.name + " (" + e.triggerCount + "次)" )
                .orElse("无"));
        return stats;
    }

    /**
     * 根据权重随机选择事件
     */
    public static int getRandomWeightedEventId() {
        if (eventRegistry.isEmpty()) return 0;

        List<EventInfo> events = new ArrayList<>(eventRegistry.values());
        int totalWeight = events.stream().mapToInt(e -> e.weight).sum();
        int random = new Random().nextInt(totalWeight);

        int currentWeight = 0;
        for (EventInfo event : events) {
            currentWeight += event.weight;
            if (random < currentWeight) {
                return event.id;
            }
        }

        return events.get(0).id;
    }

    /**
     * 根据玩家等级筛选事件组
     */
    public static List<Integer> getGroupsForLevel(int playerLevel) {
        return groupRegistry.values().stream()
                .filter(group -> playerLevel >= group.minLevel && playerLevel <= group.maxLevel)
                .map(group -> group.id)
                .collect(java.util.stream.Collectors.toList());
    }

    /**
     * 获取事件信息
     */
    public static EventInfo getEventInfo(int eventId) {
        return eventRegistry.get(eventId);
    }

    /**
     * 获取事件组信息
     */
    public static GroupInfo getGroupInfo(int groupId) {
        return groupRegistry.get(groupId);
    }

    /**
     * 获取所有已注册事件
     */
    public static List<EventInfo> getAllEvents() {
        return new ArrayList<>(eventRegistry.values());
    }

    /**
     * 获取所有已注册事件组
     */
    public static List<GroupInfo> getAllGroups() {
        return new ArrayList<>(groupRegistry.values());
    }

    /**
     * 搜索事件（按名称或描述）
     */
    public static List<EventInfo> searchEvents(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return eventRegistry.values().stream()
                .filter(event -> event.name.toLowerCase().contains(lowerKeyword) ||
                        event.description.toLowerCase().contains(lowerKeyword))
                .collect(java.util.stream.Collectors.toList());
    }

    // ========== 扩展功能 ==========

    /**
     * 事件链系统：连续触发多个事件
     */
    public static class EventChain {
        private final List<Integer> eventIds = new ArrayList<>();
        private String name = "事件链";
        private int currentIndex = 0;

        public EventChain addEvent(int eventId) {
            eventIds.add(eventId);
            return this;
        }

        public EventChain name(String name) {
            this.name = name;
            return this;
        }

        /**
         * 执行事件链中的下一个事件
         */
        public boolean executeNext(LevelAccessor world, Entity entity) {
            if (currentIndex >= eventIds.size()) {
                currentIndex = 0; // 重置
                return false;
            }

            int eventId = eventIds.get(currentIndex);
            // 这里需要实现事件的执行逻辑
            // 可能需要使用反射调用Event_item_sxRProcedure.execute
            currentIndex++;
            return true;
        }

        /**
         * 重置事件链
         */
        public void reset() {
            currentIndex = 0;
        }
    }

    /**
     * 条件事件：根据条件动态选择事件
     */
    public static class ConditionalEvent {
        private final Map<Function<Event_item_sxRProcedure.EventContext, Boolean>, Integer> conditions = new HashMap<>();
        private int defaultEventId = 0;

        public ConditionalEvent addCondition(Function<Event_item_sxRProcedure.EventContext, Boolean> condition, int eventId) {
            conditions.put(condition, eventId);
            return this;
        }

        public ConditionalEvent setDefault(int eventId) {
            this.defaultEventId = eventId;
            return this;
        }

        public int evaluate(Event_item_sxRProcedure.EventContext context) {
            for (Map.Entry<Function<Event_item_sxRProcedure.EventContext, Boolean>, Integer> entry : conditions.entrySet()) {
                if (entry.getKey().apply(context)) {
                    return entry.getValue();
                }
            }
            return defaultEventId;
        }
    }

    // ========== 实用工具 ==========

    /**
     * 创建事件物品
     */
    public static ItemStack createEventItem(int eventId, String displayName) {
        ItemStack stack = new ItemStack(net.mcreator.ceshi.init.PrimogemcraftModItems.EVENTITEM.get());
        stack.set(net.minecraft.core.component.DataComponents.CUSTOM_NAME,
                Component.literal(displayName));

        net.minecraft.world.item.component.CustomData.update(
                net.minecraft.core.component.DataComponents.CUSTOM_DATA,
                stack,
                tag -> tag.putDouble("event_", eventId)
        );

        return stack;
    }
    /**
     * 调试工具：打印所有已注册事件
     */
    public static void debugPrintEvents() {
        System.out.println("=== 已注册事件 ===");
        eventRegistry.forEach((id, info) -> {
            System.out.printf("ID: %d | 名称: %s | 权重: %d | 触发次数: %d%n",
                    id, info.name, info.weight, info.triggerCount);
        });
        System.out.println("=================");
    }
}