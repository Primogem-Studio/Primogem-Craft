package net.mcreator.ceshi.procedures;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;

public class EventGroupProcedure {
    public static int event_limit() {
        //定义 “事件组上限”
        return 7;
    }

    public static void execute(LevelAccessor world, Entity entity, int zu) {
        if (entity == null) return;
        GUIqwxz03Procedure.execute(world, entity, false, "primogemcraft:event");
        boolean o1 = switch ((int) zu) {
            //使用"事件“定义“事件组”和“事件组名称”
            case 1 -> zu(entity, 1, 2, 3, "§d附魔");
            case 2 -> zu(entity, 4, 5, 6, "§d附魔");
            case 3 -> zu(entity, 1, 4, 0, "§c抉择");
            case 4 -> zu(entity, 7, 13, 0, "§a奖励");
            case 5 -> zu(entity, 2, 5, 0, "§c抉择");
            case 6 -> zu(entity, 3, 6, 0, "§c抉择");
            case 7 -> zu(entity, 11, 14, 0, "§a奖励");
            case 8 -> zu(entity, 18, 18, 18, "§c咕咕钟");
            case 9 -> zu(entity, 17, 17, 17, "§c惩罚");
            case 10 -> zu(entity, 19, 19, 19, "§c太失败了");
            default -> false;
        };
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