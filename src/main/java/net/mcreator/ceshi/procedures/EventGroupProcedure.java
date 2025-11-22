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
    public static void execute(LevelAccessor world, Entity entity, int zu) {
        if (entity == null)
            return;
        GUIqwxz03Procedure.execute(world,entity.getX(), entity.getY(), entity.getZ(), entity, false, "primogemcraft:event");
        boolean o1 = switch ((int) zu) {
            case 1 -> zu(entity, 1, 2, 3, "§d附魔§6选择事件");
            default -> false;
        };
    }

    public static boolean zu(Entity entity, int zU0, int zU1, int zU2, String name) {

        int a = 0;
        for (int index0 = 0; index0 < 3; index0++) {
            System.out.println(index0);
            ItemStack i = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(index0).getItem() : ItemStack.EMPTY);
            a = switch (index0) {
                case 0 -> zU0;
                case 1 -> zU1;
                case 2 -> zU2;
                default -> 0;
            };
            i.set(DataComponents.CUSTOM_NAME,
                    Component.literal(name));
            {
                int finalA = a;
                CustomData.update(DataComponents.CUSTOM_DATA,
                        i, tag -> tag.putDouble("event_", finalA));
            }
        }
        return true;

    }
}