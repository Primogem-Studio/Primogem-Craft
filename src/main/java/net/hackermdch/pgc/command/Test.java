package net.hackermdch.pgc.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.mcreator.ceshi.procedures.EventGroupProcedure;
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

        dispatcher.register(Commands.literal("pgc-test")
                .requires(c -> c.hasPermission(2))

                .then(Commands.literal("set-event")
                        .then(Commands.literal("event")
                                .then(Commands.argument("值", IntegerArgumentType.integer())
                                        .executes(c -> {
                                            var p = c.getSource().getPlayer();
                                            if (p != null) {
                                                int value = IntegerArgumentType.getInteger(c, "值");
                                                EventGroupProcedure.setEventItem(value, p,true);
                                                c.getSource().sendSuccess(() ->
                                                        Component.literal("§a已创建事件物品，事件ID: " + value), true);
                                                return 0;
                                            }
                                            c.getSource().sendFailure(Component.literal("此命令只能由玩家执行"));
                                            return 1;
                                        })
                                )
                                .executes(c -> {
                                    c.getSource().sendFailure(Component.literal("请输入事件值，例如: /pgc-test set-event event 5"));
                                    return 1;
                                })
                        )

                        .then(Commands.literal("group")
                                .then(Commands.argument("值", IntegerArgumentType.integer())
                                        .executes(c -> {
                                            var source = c.getSource();
                                            var entity = source.getEntity();
                                            if (entity != null) {
                                                int groupId = IntegerArgumentType.getInteger(c, "值");
                                                EventGroupProcedure.execute(source.getLevel(), entity, groupId);
                                                source.sendSuccess(() ->
                                                        Component.literal("§a已执行事件组 #" + groupId), true);
                                                return 0;
                                            }
                                            source.sendFailure(Component.literal("无效的命令执行者"));
                                            return 1;
                                        })
                                )
                                .executes(c -> {
                                    c.getSource().sendFailure(Component.literal("请输入事件组ID，例如: /pgc-test set-event group 3"));
                                    return 1;
                                })
                        )

                        .executes(c -> {
                            var source = c.getSource();
                            source.sendSuccess(() -> Component.literal("§6=== 事件设置命令帮助 ==="), false);
                            source.sendSuccess(() -> Component.literal("§e/pgc-test set-event event <值> §7- 获取指定ID的事件物品"), false);
                            source.sendSuccess(() -> Component.literal("§e/pgc-test set-event group <值> §7- 执行指定ID的事件组"), false);

                            var groupIds = EventGroupProcedure.getRegisteredGroupIds();
                            if (!groupIds.isEmpty()) {
                                source.sendSuccess(() ->
                                        Component.literal("§7可用事件组ID: " +
                                                java.util.Collections.min(groupIds) + " - " +
                                                java.util.Collections.max(groupIds)), false);
                            }

                            return 0;
                        })
                )

                .then(Commands.literal("set-weapon")
                        .then(Commands.argument("level", IntegerArgumentType.integer())
                                .then(Commands.argument("qua", IntegerArgumentType.integer())
                                        .executes(c -> {
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
                                        })
                                )
                        )
                        .executes(c -> {
                            c.getSource().sendFailure(Component.literal("请输入等级和精炼值，例如: /pgc-test set-weapon 5 3"));
                            return 1;
                        })
                )

                .executes(c -> {
                    var source = c.getSource();
                    source.sendSuccess(() -> Component.literal("§6=== PGC测试命令帮助 ==="), false);
                    source.sendSuccess(() -> Component.literal("§e/pgc-test set-event §7- 事件/组设置命令"), false);
                    source.sendSuccess(() -> Component.literal("§e/pgc-test set-weapon <等级> <精炼> §7- 设置手持武器"), false);
                    source.sendSuccess(() -> Component.literal("§7输入具体命令查看详细帮助，如: /pgc-test set-event"), false);

                    return 0;
                })
        );
    }
}