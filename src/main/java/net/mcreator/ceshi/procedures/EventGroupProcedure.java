package net.mcreator.ceshi.procedures;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static net.mcreator.ceshi.procedures.Event_item_sxRProcedure.suijiint;

public class EventGroupProcedure {
    private static final Map<Integer, BiFunction<Entity, LevelAccessor, Boolean>> GROUP_HANDLERS = new HashMap<>();

    static {
        // 注册所有事件组处理器
        registerGroup(1, (entity, world) -> zu(entity, 1, 2, 3, "§d附魔"));
        registerGroup(2, (entity, world) -> zu(entity, 4, 5, 6, "§d附魔"));
        registerGroup(3, (entity, world) -> zu(entity, 1, 4, 0, "§c抉择"));
        registerGroup(4, (entity, world) -> zu(entity, 7, 13, 0, "§a奖励"));
        registerGroup(5, (entity, world) -> zu(entity, 2, 5, 0, "§c抉择"));
        registerGroup(6, (entity, world) -> zu(entity, 3, 6, 0, "§c抉择"));
        registerGroup(7, (entity, world) -> zu(entity, 11, 14, 0, "§a奖励"));
        registerGroup(8, (entity, world) -> zu(entity, 18, 18, 18, "§c咕咕钟"));
        registerGroup(9, (entity, world) -> zu(entity, 17, 17, 17, "§c惩罚"));
        registerGroup(10, (entity, world) -> zu(entity, 19, 19, 19, "§c太失败了"));
        registerGroup(11, (entity, world) -> {
            // 自适应随机事件组 - 从所有已注册事件中随机选择
            int event1 = getRandomRegisteredEventId(world);
            int event2 = getRandomRegisteredEventId(world);
            int event3 = getRandomRegisteredEventId(world);
            return zu(entity, event1, event2, event3, "§c§khaha");
        });
        registerGroup(12, (entity, world) -> zu(entity, 20, 20, 17, "§c战斗"));
    }

    public static void registerGroup(int groupId, BiFunction<Entity, LevelAccessor, Boolean> handler) {
        GROUP_HANDLERS.put(groupId, handler);
    }

    /**
     * 获取已注册的事件组数量上限（自适应）
     */
    public static int event_limit() {
        if (GROUP_HANDLERS.isEmpty()) return 0;
        return GROUP_HANDLERS.keySet().stream().max(Integer::compareTo).orElse(0);
    }

    /**
     * 获取已注册的事件数量上限（自适应）
     */
    public static int event_X_limit() {
        // 从事件执行类获取已注册的事件数量
        return Event_item_sxRProcedure.getRegisteredEventCount();
    }

    /**
     * 从所有已注册事件中随机选择一个事件ID
     */
    public static int getRandomRegisteredEventId(LevelAccessor world) {
        int eventCount = event_X_limit();
        if (eventCount <= 0) return 0;

        // 获取所有已注册的事件ID
        java.util.List<Integer> registeredEvents = Event_item_sxRProcedure.getRegisteredEventIds();
        if (registeredEvents.isEmpty()) return 0;

        // 从已注册事件中随机选择
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

        // 过滤指定范围内的组ID
        java.util.List<Integer> filteredGroups = groupIds.stream()
                .filter(id -> id >= minGroupId && id <= maxGroupId)
                .collect(java.util.stream.Collectors.toList());

        if (filteredGroups.isEmpty()) return 0;

        int randomIndex = suijiint(world, 0, filteredGroups.size() - 1);
        return filteredGroups.get(randomIndex);
    }

    public static void execute(LevelAccessor world, Entity entity, int zu) {
        if (entity == null) return;
        GUIqwxz03Procedure.execute(world, entity, false, "primogemcraft:event");

        BiFunction<Entity, LevelAccessor, Boolean> handler = GROUP_HANDLERS.get(zu);
        if (handler != null) {
            handler.apply(entity, world);
        }
    }

    public static boolean zu(Entity entity, int zU0, int zU1, int zU2, String name) {
        int a = 0;
        for (int index0 = 0; index0 < 3; index0++) {
            ItemStack i = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(index0).getItem() : ItemStack.EMPTY);
            a = switch (index0) {
                case 0 -> zU0;
                case 1 -> zU1;
                case 2 -> zU2;
                default -> 0;
            };
            i.set(DataComponents.CUSTOM_NAME, Component.literal(name));
            {
                int finalA = a;
                CustomData.update(DataComponents.CUSTOM_DATA, i, tag -> tag.putDouble("event_", finalA));
            }
        }
        return true;
    }

    /**
     * 获取已注册的事件组ID列表（用于调试或其他用途）
     */
    public static java.util.List<Integer> getRegisteredGroupIds() {
        return new java.util.ArrayList<>(GROUP_HANDLERS.keySet());
    }
}