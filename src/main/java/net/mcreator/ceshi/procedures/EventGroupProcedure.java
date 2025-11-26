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
        registerGroup(11, (entity, world) -> zu(entity, suijiint(world, 1, event_X_limit()), suijiint(world, 1, event_X_limit()), suijiint(world, 1, event_X_limit()), "§c§khaha"));
    }

    public static void registerGroup(int groupId, BiFunction<Entity, LevelAccessor, Boolean> handler) {
        GROUP_HANDLERS.put(groupId, handler);
    }

    public static int event_limit() {
        //定义 "事件组上限"
        return 11;
    }

    public static int event_X_limit() {
        // "事件"上限
        return 19;
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
}