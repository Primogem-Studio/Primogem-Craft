package net.hackermdch.pgc.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.component.CustomData;

public class Test {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        var tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", "wuqi"));
        dispatcher.register(Commands.literal("pgc-test").requires(c -> c.hasPermission(2)).then(Commands.literal("1").executes(c -> {
            var p = c.getSource().getPlayer();
            if (p != null) {
                var it = p.getMainHandItem();
                if (it.is(tag)) {
                    CustomData.update(DataComponents.CUSTOM_DATA, it, t -> {
                        t.putDouble("deng_ji", 89);
                        t.putDouble("jing_lian", 7);
                    });
                    c.getSource().sendSuccess(() -> Component.literal("已强化至最大"), true);
                    return 0;
                }
                c.getSource().sendFailure(Component.literal("无法强化此物品"));
                return 1;
            }
            c.getSource().sendFailure(Component.literal("无效的命令执行者"));
            return 2;
        })));
    }
}
