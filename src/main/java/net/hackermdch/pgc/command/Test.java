package net.hackermdch.pgc.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.mcreator.ceshi.procedures.WuqishuaxinProcedure;
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
        dispatcher.register(Commands.literal("pgc-test").requires(c -> c.hasPermission(2)).then(Commands.literal("set-weapon").then(Commands.argument("level", IntegerArgumentType.integer()).then(Commands.argument("qua", IntegerArgumentType.integer()).executes(c -> {
            var p = c.getSource().getPlayer();
            if (p != null) {
                var it = p.getMainHandItem();
                if (it.is(tag)) {
                    var level = IntegerArgumentType.getInteger(c, "level");
                    var qua = IntegerArgumentType.getInteger(c, "qua");
                    CustomData.update(DataComponents.CUSTOM_DATA, it, t -> {
                        t.putDouble("deng_ji", level - 1);
                        t.putDouble("jing_lian", qua - 1);
                    });
                    WuqishuaxinProcedure.execute(p.level(), p, it);
                    c.getSource().sendSuccess(() -> Component.literal("已设置至：精炼" + qua + "等级" + level), true);
                    return 0;
                }
                c.getSource().sendFailure(Component.literal("无法设置此物品"));
                return 1;
            }
            c.getSource().sendFailure(Component.literal("无效的命令执行者"));
            return 2;
        })))));
    }
}
