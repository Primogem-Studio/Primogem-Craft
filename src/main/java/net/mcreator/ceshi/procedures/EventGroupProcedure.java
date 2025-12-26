package net.mcreator.ceshi.procedures;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.items.ItemHandlerHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import static net.mcreator.ceshi.procedures.Event_item_sxRProcedure.suijiint;

public class EventGroupProcedure {
    private static class WeightedGroupHandler {
        final Function<GroupContext, Boolean> handler;
        final int weight;

        WeightedGroupHandler(Function<GroupContext, Boolean> handler, int weight) {
            this.handler = handler;
            this.weight = weight;
        }
    }

    private static final Map<Integer, WeightedGroupHandler> GROUP_HANDLERS = new HashMap<>();

    private static void registerGroupInternal(int groupId, Function<GroupContext, Boolean> handler) {
        registerGroupInternal(groupId, handler, 1);
    }

    private static void registerGroupInternal(int groupId, Function<GroupContext, Boolean> handler, int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("权重必须大于0");
        }
        GROUP_HANDLERS.put(groupId, new WeightedGroupHandler(handler, weight));
    }
    static {
        registerGroupInternal(1, ctx -> ctx.zu(1, 2, 3, "§d附魔"));
        registerGroupInternal(2, ctx -> ctx.zu(4, 5, 6, "§d附魔"));
        registerGroupInternal(3, ctx -> ctx.zu(1, 4, 0, "§c抉择"));
        registerGroupInternal(4, ctx -> ctx.zu(7, 13, 0, "§a奖励"));
        registerGroupInternal(5, ctx -> ctx.zu(2, 5, 0, "§c抉择"));
        registerGroupInternal(6, ctx -> ctx.zu(3, 6, 0, "§c抉择"));
        registerGroupInternal(7, ctx -> ctx.zu(11, 14, 0, "§a奖励"));
        registerGroupInternal(8, ctx -> ctx.zu(18, 18, 18, "§c咕咕钟"));
        registerGroupInternal(9, ctx -> ctx.zu(17, 17, 17, "§c惩罚"));
        registerGroupInternal(10, ctx -> ctx.zu(19, 19, 19, "§c太失败了"));
        registerGroupInternal(11, ctx -> {
            int event1 = ctx.getRandomRegisteredEventId();
            int event2 = ctx.getRandomRegisteredEventId();
            int event3 = ctx.getRandomRegisteredEventId();
            return ctx.zu(event1, event2, event3, "§c§khaha");
        },5);
        registerGroupInternal(12, ctx -> ctx.zu(20, 26, 17, "§c战斗"));
        registerGroupInternal(13, ctx -> ctx.zu(21, 22, 17, "§c战斗"));
        registerGroupInternal(14, ctx -> ctx.zu(23, 24, 25, "§e你从垃圾桶获得了物品"));
        registerGroupInternal(15, ctx -> ctx.zu(27, 27, 27, "§c遭遇"));
        registerGroupInternal(16, ctx -> ctx.zu(28, 28, 28, "§c遭遇"));
        registerGroupInternal(17, ctx -> ctx.zu(29, 29, 29, "§c可循环战斗"));
        registerGroupInternal(18, ctx -> ctx.zu(30, 31, 30, "§a奖励"));
        registerGroupInternal(19, ctx -> ctx.zu(38, 34, 36, "§6更多事件！"));
        registerGroupInternal(20, ctx -> ctx.zu(39, 35, 37, "§c更少的事件"));
        registerGroupInternal(21, ctx -> ctx.zu(33, 38, 12, "§a抉择"));
        registerGroupInternal(22, ctx -> ctx.zu(35, 39, 17, "§c抉择"));
        registerGroupInternal(23, ctx -> ctx.zu(19, 36, 38, "§c抉择"));
        registerGroupInternal(24, ctx -> ctx.zu(32, 32, 32, "§e宇宙碎片！"));
        registerGroupInternal(25, ctx -> ctx.zu(40, 41, 42, "§a我要点餐"));
    }
    public static void registerGroup(int groupId, BiFunction<Entity, LevelAccessor, Boolean> handler) {
        GROUP_HANDLERS.put(groupId, new WeightedGroupHandler(ctx -> handler.apply(ctx.getEntity(), ctx.getWorld()), 1));
    }
    public static void registerGroup(int groupId, BiFunction<Entity, LevelAccessor, Boolean> handler, int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("权重必须大于0");
        }
        GROUP_HANDLERS.put(groupId, new WeightedGroupHandler(ctx -> handler.apply(ctx.getEntity(), ctx.getWorld()), weight));
    }
    /**
     * 获取已注册的事件组数量上限
     */
    public static int event_limit() {
        if (GROUP_HANDLERS.isEmpty()) return 0;
        return GROUP_HANDLERS.keySet().stream().max(Integer::compareTo).orElse(0);
    }

    /**
     * 获取已注册的事件数量上限
     */
    public static int event_X_limit() {
        return Event_item_sxRProcedure.getRegisteredEventCount();
    }

    /**
     * 从所有已注册事件中随机选择一个事件ID
     */
    public static int getRandomRegisteredEventId(LevelAccessor world) {
        int eventCount = event_X_limit();
        if (eventCount <= 0) return 0;

        java.util.List<Integer> registeredEvents = Event_item_sxRProcedure.getRegisteredEventIds();
        if (registeredEvents.isEmpty()) return 0;

        int randomIndex = suijiint(world, 0, registeredEvents.size() - 1);
        return registeredEvents.get(randomIndex);
    }

    /**
     * 获取随机事件组ID（从所有已注册的事件组中随机选择）
     */
    public static int getRandomGroupId(LevelAccessor world) {
        java.util.List<Integer> groupIds = getRegisteredGroupIds();
        if (groupIds.isEmpty()) return 0;

        int randomIndex = suijiint(world, 0, groupIds.size() - 1);
        return groupIds.get(randomIndex);
    }

    /**
     * 获取随机事件组ID（从指定范围内随机选择）
     */
    public static int getRandomGroupId(LevelAccessor world, int minGroupId, int maxGroupId) {
        java.util.List<Integer> groupIds = getRegisteredGroupIds();
        if (groupIds.isEmpty()) return 0;

        java.util.List<Integer> filteredGroups = groupIds.stream()
                .filter(id -> id >= minGroupId && id <= maxGroupId)
                .collect(java.util.stream.Collectors.toList());

        if (filteredGroups.isEmpty()) return 0;

        int randomIndex = suijiint(world, 0, filteredGroups.size() - 1);
        return filteredGroups.get(randomIndex);
    }

    /**
     * 根据权重随机选择事件组ID
     */
    public static int getWeightedRandomGroupId(LevelAccessor world) {
        if (GROUP_HANDLERS.isEmpty()) return 0;

        // 计算总权重
        int totalWeight = GROUP_HANDLERS.values().stream()
                .mapToInt(handler -> handler.weight)
                .sum();

        if (totalWeight <= 0) return 0;

        // 生成随机权重值
        int randomWeight = suijiint(world, 1, totalWeight);

        // 根据权重选择组
        int currentWeight = 0;
        for (Map.Entry<Integer, WeightedGroupHandler> entry : GROUP_HANDLERS.entrySet()) {
            currentWeight += entry.getValue().weight;
            if (randomWeight <= currentWeight) {
                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * 获取事件组的权重
     */
    public static int getGroupWeight(int groupId) {
        WeightedGroupHandler handler = GROUP_HANDLERS.get(groupId);
        return handler != null ? handler.weight : 0;
    }

    public static void execute(LevelAccessor world, Entity entity, int zu) {
        if (entity == null) return;

        GUIqwxz03Procedure.execute(world, entity, false, "primogemcraft:event");

        GroupContext context = new GroupContext(entity, world);
        WeightedGroupHandler weightedHandler = GROUP_HANDLERS.get(zu);

        if (weightedHandler != null && weightedHandler.handler != null) {
            weightedHandler.handler.apply(context);
        }
    }

    /**
     * 获取已注册的事件组ID列表
     */
    public static java.util.List<Integer> getRegisteredGroupIds() {
        return new java.util.ArrayList<>(GROUP_HANDLERS.keySet());
    }

    /**
     * 事件组上下文类
     */
    public static class GroupContext {
        private final Entity entity;
        private final LevelAccessor world;
        private final Player player;

        public GroupContext(Entity entity, LevelAccessor world) {
            this.entity = entity;
            this.world = world;
            this.player = entity instanceof Player ? (Player) entity : null;
        }

        public Entity getEntity() { return entity; }
        public Player getPlayer() { return player; }
        public LevelAccessor getWorld() { return world; }

        public boolean zu(int zU0, int zU1, int zU2, String name) {
            for (int index0 = 0; index0 < 3; index0++) {
                ItemStack i = getSlotItem(index0);
                int eventId = switch (index0) {
                    case 0 -> zU0;
                    case 1 -> zU1;
                    case 2 -> zU2;
                    default -> 0;
                };

                int finalEventId = eventId;
                CustomData.update(DataComponents.CUSTOM_DATA, i, tag ->
                        tag.putDouble("event_", finalEventId)
                );
                i.set(DataComponents.CUSTOM_NAME, Component.literal(
                        finalEventId<1?"§7离开这里": name));
            }
            return true;
        }

        private ItemStack getSlotItem(int slotIndex) {
            if (player != null && player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor menuAccessor) {
                var slots = menuAccessor.getSlots();
                if (slotIndex >= 0 && slotIndex < slots.size()) {
                    return slots.get(slotIndex).getItem();
                }
            }
            return ItemStack.EMPTY;
        }

        public int getRandomRegisteredEventId() {
            int eventCount = Event_item_sxRProcedure.getRegisteredEventCount();
            if (eventCount <= 0) return 0;

            java.util.List<Integer> registeredEvents = Event_item_sxRProcedure.getRegisteredEventIds();
            if (registeredEvents.isEmpty()) return 0;

            int randomIndex = suijiint(world, 0, registeredEvents.size() - 1);
            return registeredEvents.get(randomIndex);
        }

        public boolean isPlayerCreative() {
            return player != null && player.isCreative();
        }

        public GroupConfiguration configure() {
            return new GroupConfiguration(this);
        }

        public boolean quickSet(String name, int... eventIds) {
            if (eventIds.length == 0) return false;

            int zU0 = eventIds.length > 0 ? eventIds[0] : 0;
            int zU1 = eventIds.length > 1 ? eventIds[1] : 0;
            int zU2 = eventIds.length > 2 ? eventIds[2] : 0;

            return zu(zU0, zU1, zU2, name);
        }
    }

    public static void setEventItem(int value, Player player,boolean b) {
        ItemStack i = new ItemStack(PrimogemcraftModItems.EVENTITEM.get());
        CustomData.update(DataComponents.CUSTOM_DATA, i, tag -> tag.putDouble("event_", value));
        CustomData.update(DataComponents.CUSTOM_DATA, i, tag -> tag.putBoolean("LIji", b));
        ItemHandlerHelper.giveItemToPlayer(player, i);
    }

    /**
     * 组配置类
     */
    public static class GroupConfiguration {
        private final GroupContext context;
        private int slot0 = 0;
        private int slot1 = 0;
        private int slot2 = 0;
        private String name = "§f事件";

        public GroupConfiguration(GroupContext context) {
            this.context = context;
        }

        public GroupConfiguration slot0(int eventId) {
            this.slot0 = eventId;
            return this;
        }

        public GroupConfiguration slot1(int eventId) {
            this.slot1 = eventId;
            return this;
        }

        public GroupConfiguration slot2(int eventId) {
            this.slot2 = eventId;
            return this;
        }

        public GroupConfiguration name(String name) {
            this.name = name;
            return this;
        }

        public boolean apply() {
            return context.zu(slot0, slot1, slot2, name);
        }
    }

    public static boolean createSimpleGroup(Player player, LevelAccessor world,
                                            int event1, int event2, int event3,
                                            String groupName) {
        if (player == null) return false;

        GroupContext context = new GroupContext(player, world);
        return context.zu(event1, event2, event3, groupName);
    }

    public static void registerGroups(Map<Integer, Consumer<GroupContext>> groups) {
        groups.forEach((groupId, consumer) -> {
            registerGroupInternal(groupId, ctx -> {
                consumer.accept(ctx);
                return true;
            });
        });
    }
}