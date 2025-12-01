package net.mcreator.ceshi.procedures;

import io.netty.buffer.Unpooled;
import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Event_item_sxRProcedure {
    // 事件注册器 - 使用Function接收EventContext
    private static final Map<Integer, Function<EventContext, Boolean>> EVENT_HANDLERS = new HashMap<>();

    // 注册事件的方法（内部使用）
    private static void registerEventInternal(int eventId, Function<EventContext, Boolean> handler) {
        EVENT_HANDLERS.put(eventId, handler);
    }

    // 兼容API的注册方法（接收BiFunction）
    public static void registerEvent(int eventId, BiFunction<LevelAccessor, Entity, Boolean> handler) {
        EVENT_HANDLERS.put(eventId, ctx -> handler.apply(ctx.getWorld(), ctx.getEntity()));
    }

    static {
        // 使用EventContext注册事件
        registerEventInternal(1, ctx -> ctx.shijian_123(1, new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), 10));
        registerEventInternal(2, ctx -> ctx.shijian_123(ctx.suijiint(1, 3), new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), 20));
        registerEventInternal(3, ctx -> ctx.shijian_123(ctx.suijiint(2, 4), new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), 40));
        registerEventInternal(4, ctx -> ctx.Hp_jian(0.2) ? ctx.fumo(1) : ctx.no());
        registerEventInternal(5, ctx -> ctx.Hp_jian(0.7) ? ctx.fumo(2) : ctx.no());
        registerEventInternal(6, ctx -> ctx.Hp_jian(0.95) && ctx.item_zhi_1_1(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), 20) ? ctx.fumo(3) : ctx.no());
        registerEventInternal(7, ctx -> ctx.item_zhi(true, "c:curio/normal/b"));
        registerEventInternal(8, ctx -> ctx.item_zhi(true, "c:curio/normal/a"));
        registerEventInternal(9, ctx -> ctx.item_zhi(true, "c:curio/normal/s"));
        registerEventInternal(10, ctx -> ctx.item_zhi(true, "c:curio/normal/fusion/b"));
        registerEventInternal(11, ctx -> ctx.item_zhi(true, "c:curio/normal/fusion/a"));
        registerEventInternal(12, ctx -> ctx.item_zhi(true, "c:curio/normal/fusion/s"));
        registerEventInternal(13, ctx -> ctx.fumo(1));
        registerEventInternal(14, ctx -> ctx.fumo(2));
        registerEventInternal(15, ctx -> ctx.fumo(3));
        registerEventInternal(16, ctx -> ctx.fumo(4));
        registerEventInternal(17, ctx -> ctx.item_zhi(true, "c:curio/negative"));
        registerEventInternal(18, ctx -> ctx.item_zhi(true, "c:curio/clock"));
        registerEventInternal(19, ctx -> ctx.item_zhi(true, "c:curio/negative/cf"));
        registerEventInternal(20, ctx -> ctx.entity_loot(
                ctx.getWorld() instanceof ServerLevel serverLevel ?
                        PrimogemcraftModEntities.S_WFENGRAOJIANGSHI.get().spawn(serverLevel,
                                BlockPos.containing(ctx.getEntity().getX(), ctx.getEntity().getY(), ctx.getEntity().getZ()),
                                MobSpawnType.MOB_SUMMONED) : null,
                "primogemcraft:fengraozlpevent",
                false
        ));
    }

    public static boolean execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null) return false;

        double ie = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");
        int eventId = (int) ie;

        Function<EventContext, Boolean> handler = EVENT_HANDLERS.get(eventId);
        if (handler == null) return false;

        // 创建事件上下文并执行
        EventContext context = new EventContext(eventId, entity, world, itemstack);
        boolean result = handler.apply(context);

        if (result) {
            itemstack.shrink(1);
        }

        return result;
    }

    // 事件上下文类 - 封装所有事件相关的数据和操作
    public static class EventContext {
        private final int id;
        private final Entity entity;
        private final LevelAccessor world;
        private final ItemStack itemstack;
        private final Player player;
        private final RandomSource random;

        public EventContext(int id, Entity entity, LevelAccessor world, ItemStack itemstack) {
            this.id = id;
            this.entity = entity;
            this.world = world;
            this.itemstack = itemstack;
            this.player = entity instanceof Player ? (Player) entity : null;
            this.random = RandomSource.create();
        }

        // 获取器
        public int getId() { return id; }
        public Entity getEntity() { return entity; }
        public Player getPlayer() { return player; }
        public LevelAccessor getWorld() { return world; }
        public ItemStack getItemStack() { return itemstack; }

        /**
         * 接收对应等级附魔并为实体打开附魔GUI，最大4
         */
        public boolean fumo(int zhi) {
            entity.getPersistentData().putDouble("pgc_shijian_fumo_pinzhi", zhi);
            PrimogemcraftMod.queueServerWork(1, () -> {
                if (entity instanceof ServerPlayer serverPlayer) {
                    BlockPos pos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
                    serverPlayer.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.literal("GUISJfumo");
                        }

                        @Override
                        public boolean shouldTriggerClientSideContainerClosingOnOpen() {
                            return false;
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            return new GUISJfumoMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
                        }
                    }, pos);
                }
            });
            return true;
        }

        /**
         * 移除特定数量的item
         */
        public boolean item_zhi_1_1(ItemStack item, int zhi) {
            int total = 0;
            if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable itemHandler) {
                for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
                    ItemStack slotStack = itemHandler.getStackInSlot(slot).copy();
                    if (slotStack.getItem() == item.getItem()) {
                        total += slotStack.getCount();
                    }
                }
            }

            if (total >= zhi && player != null) {
                ItemStack toRemove = new ItemStack(item.getItem());
                player.getInventory().clearOrCountMatchingItems(
                        p -> toRemove.getItem() == p.getItem(),
                        zhi,
                        player.inventoryMenu.getCraftSlots()
                );
                return true;
            }
            return false;
        }

        /**
         * 移除 itzhi个 item 后打开 zhi 级别的附魔界面
         */
        public boolean shijian_123(int zhi, ItemStack item, int itzhi) {
            if (item_zhi_1_1(item, itzhi)) {
                fumo(zhi);
                return true;
            }
            no();
            return false;
        }

        /**
         * 服务器随机整数
         */
        public int suijiint(int min, int max) {
            if (!world.isClientSide()) {
                return Mth.nextInt(random, min, max);
            }
            return 0;
        }

        /**
         * 造成百分比的 zhi 伤害
         */
        public boolean Hp_jian(double zhi) {
            if (entity instanceof LivingEntity livingEntity) {
                float maxHealth = livingEntity.getMaxHealth();
                if (livingEntity.getHealth() >= maxHealth * zhi) {
                    entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), maxHealth * (float) zhi);
                    return true;
                }
            }
            return false;
        }

        /**
         * 播放条件不足
         */
        public boolean no() {
            if (Timer.isDone(entity, "Event_Tri")) {
                Timer.set(entity, "Event_Tri", 100);
                if (player != null && !player.level().isClientSide()) {
                    player.displayClientMessage(Component.literal("\u00A7c\u6761\u4EF6\u4E0D\u8DB3\uFF01"), false);
                }
            }
            return false;
        }

        /**
         * 立即生成物品三选一界面
         */
        public boolean item_zhi(boolean qd, String tag_) {
            GUIqwxz03Procedure.execute(world, entity, qd, tag_);
            return true;
        }

        /**
         * 将生成的实体赋予可选择额外战利品
         */
        public boolean entity_loot(Entity spawnedEntity, String loot, boolean tag) {
            if (spawnedEntity == null || entity == null) return false;

            if (!world.isClientSide()) {
                spawnedEntity.getPersistentData().putString("Event_Entity_Loot", loot);
                spawnedEntity.getPersistentData().putBoolean("Event_Entity_Loot_tag", tag);
                return true;
            }
            return false;
        }
    }

    // 保持原有静态辅助方法（为了向后兼容）
    public static int getRegisteredEventCount() {
        return EVENT_HANDLERS.isEmpty() ? 0 :
                EVENT_HANDLERS.keySet().stream().max(Integer::compareTo).orElse(0);
    }

    public static java.util.List<Integer> getRegisteredEventIds() {
        return new java.util.ArrayList<>(EVENT_HANDLERS.keySet());
    }

    public static boolean isEventRegistered(int eventId) {
        return EVENT_HANDLERS.containsKey(eventId);
    }

    // 静态suijiint方法（为了向后兼容EventGroupProcedure）
    public static int suijiint(LevelAccessor world, int min, int max) {
        if (!world.isClientSide()) {
            return Mth.nextInt(RandomSource.create(), min, max);
        }
        return 0;
    }
}