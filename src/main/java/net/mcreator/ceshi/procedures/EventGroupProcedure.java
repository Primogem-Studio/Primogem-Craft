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
        return 2;
    }

    public static void execute(LevelAccessor world, Entity entity, int zu) {
        if (entity == null) return;
        GUIqwxz03Procedure.execute(world, entity, false, "primogemcraft:event");
        boolean o1 = switch ((int) zu) {
            //使用"事件“定义“事件组”和“事件组名称”
            case 1 -> zu(entity, 1, 2, 3, "§d附魔§6选择事件");
            case 2 -> zu(entity, 4, 5, 6, "§d附魔§6选择事件");
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