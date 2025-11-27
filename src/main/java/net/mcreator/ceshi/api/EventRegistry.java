package net.mcreator.ceshi.api;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

import java.util.function.BiFunction;
///PepperMO留言：“AI真是太好用了。”；
public class EventRegistry {
    /**
     * 注册新事件
     * @param eventId 事件ID（建议从 模组四个首字母顺序作为ID开始，例：Primogem... -> 1618913 开始避免冲突）
     * @param handler 事件处理器
     */
    public static void registerEvent(int eventId, BiFunction<LevelAccessor, Entity, Boolean> handler) {
        net.mcreator.ceshi.procedures.Event_item_sxRProcedure.registerEvent(eventId, handler);
    }

    /**
     * 注册新事件组
     * @param groupId 事件组ID（建议从 模组三个首字母顺序作为ID开始，例：Primogem... -> 16189 开始避免冲突（冲突了也没办法！！））
     * @param handler 事件组处理器
     */
    public static void registerGroup(int groupId, BiFunction<Entity, LevelAccessor, Boolean> handler) {
        net.mcreator.ceshi.procedures.EventGroupProcedure.registerGroup(groupId, handler);
    }

    /**
     * 注册事件描述
     * @param eventId 事件ID
     * @param descriptionProvider 描述提供器
     */
    public static void registerDescription(int eventId, java.util.function.Supplier<String> descriptionProvider) {
        net.mcreator.ceshi.procedures.EventitemmssxrProcedure.registerDescription(eventId, descriptionProvider);
    }

    /**
     * 获取事件上限（供其他mod参考）
     */
    public static int getEventLimit() {
        return net.mcreator.ceshi.procedures.EventGroupProcedure.event_X_limit();
    }

    /**
     * 获取事件组上限（供其他mod参考）
     */
    public static int getGroupLimit() {
        return net.mcreator.ceshi.procedures.EventGroupProcedure.event_limit();
    }
}
//// 示例：（注：API和示例都是AI写的，可能会无效）：
//public class OtherModEvents {
//    public static void registerEvents() {
//        // 注册新事件
//        EventRegistry.registerEvent(1001, (world, entity) -> {
//            // 自定义事件逻辑
//            if (entity instanceof Player player) {
//                player.displayClientMessage(Component.literal("来自其他mod的事件！"), false);
//                player.giveExperiencePoints(100);
//                return true;
//            }
//            return false;
//        });
//
//        // 注册新事件组
//        EventRegistry.registerGroup(101, (entity, world) -> {
//            // 使用你提供的zu方法创建事件组
//            return net.mcreator.ceshi.procedures.EventGroupProcedure.zu(entity, 1001, 1002, 1003, "§a其他mod事件组");
//        });
//
//        // 注册事件描述
//        EventRegistry.registerDescription(1001, () -> "§e来自其他mod的奖励事件\n§a获得100经验值");
//    }
//}
