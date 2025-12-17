package net.mcreator.ceshi.procedures;

import io.netty.buffer.Unpooled;
import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.item.YuzhousuipianItem;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.event.entity.living.LivingSwapItemsEvent;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.per.event.EventEntityScopeSpawn;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import static net.mcreator.ceshi.init.PrimogemcraftModEntities.S_WFENGRAOJIANGSHI;
import static net.mcreator.ceshi.init.PrimogemcraftModItems.YUZHOUSUIPIAN;

public class Event_item_sxRProcedure {
    // 事件注册器 - 使用Function接收EventContext
    private static final Map<Integer, Function<EventContext, Boolean>> EVENT_HANDLERS = new HashMap<>();

    // 注册事件的方法（内部使用）
    private static void registerEventInternal(int eventId, Function<EventContext, Boolean> handler) {
        EVENT_HANDLERS.put(eventId, handler);
    }

    // 兼容API的注册方法（接收BiFunction）
    public static void registerEvent(int eventId, BiFunction<LevelAccessor, Entity, Boolean> handler) {
        EVENT_HANDLERS.put(eventId, ctx -> handler.apply(ctx.getWorld(), ctx.getPlayer()));
    }

    static {
        registerEventInternal(1, ctx -> ctx.costItem(new ItemStack(YUZHOUSUIPIAN.get()), 10) ? ctx.openEnchGui(1) : ctx.no());
        registerEventInternal(2, ctx -> ctx.costItem(new ItemStack(YUZHOUSUIPIAN.get()), 20) ? ctx.openEnchGui(ctx.random(1, 2)) : ctx.no());
        registerEventInternal(3, ctx -> ctx.costItem(new ItemStack(YUZHOUSUIPIAN.get()), 40) ? ctx.openEnchGui(ctx.random(2, 4)) : ctx.no());
        registerEventInternal(4, ctx -> ctx.costHpPercent(0.2) ? ctx.openEnchGui(1) : ctx.no());
        registerEventInternal(5, ctx -> ctx.costHpPercent(0.7) ? ctx.openEnchGui(2) : ctx.no());
        registerEventInternal(6, ctx -> ctx.costHpPercent(0.95) && ctx.costItem(new ItemStack(YUZHOUSUIPIAN.get()), 20) ? ctx.openEnchGui(3) : ctx.no());
        registerEventInternal(7, ctx -> ctx.giveTagLootItem(true, "c:curio/normal/b"));
        registerEventInternal(8, ctx -> ctx.giveTagLootItem(true, "c:curio/normal/a"));
        registerEventInternal(9, ctx -> ctx.giveTagLootItem(true, "c:curio/normal/s"));
        registerEventInternal(10, ctx -> ctx.giveTagLootItem(true, "c:curio/normal/fusion/b"));
        registerEventInternal(11, ctx -> ctx.giveTagLootItem(true, "c:curio/normal/fusion/a"));
        registerEventInternal(12, ctx -> ctx.giveTagLootItem(true, "c:curio/normal/fusion/s"));
        registerEventInternal(13, ctx -> ctx.openEnchGui(1));
        registerEventInternal(14, ctx -> ctx.openEnchGui(2));
        registerEventInternal(15, ctx -> ctx.openEnchGui(3));
        registerEventInternal(16, ctx -> ctx.openEnchGui(4));
        registerEventInternal(17, ctx -> ctx.giveTagLootItem(true, "c:curio/negative"));
        registerEventInternal(18, ctx -> ctx.giveTagLootItem(true, "c:curio/clock"));
        registerEventInternal(19, ctx -> ctx.giveTagLootItem(true, "c:curio/negative/cf"));
        registerEventInternal(20, ctx -> ctx.entityLoottab(ctx.entityType(S_WFENGRAOJIANGSHI.get()), "primogemcraft:fengraozlpevent", false));
        registerEventInternal(21, ctx -> ctx.TimelimitedCombat(S_WFENGRAOJIANGSHI.get(), 2, 0, entity -> {entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(2);entity.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1);}, null));
        registerEventInternal(22, ctx -> ctx.spawnEntitiesInRange(net.minecraft.world.entity.EntityType.ZOMBIE, 5, 5));
        registerEventInternal(23, ctx -> ctx.giveItem(new ItemStack(Items.SHIELD).copy(), 1) ? ctx.prompt("§6<垃圾桶> §f不，盾牌才是你的掉落物。", false) : ctx.no());
        registerEventInternal(24, ctx -> ctx.giveItem(new ItemStack(PrimogemcraftModItems.QWYZZM.get()), 1) ? ctx.prompt("§6<垃圾桶> §c哈哈，你其实掉落了一个愚者面具！", false) : ctx.no());
        registerEventInternal(25, ctx -> ctx.giveItem(new ItemStack(PrimogemcraftModItems.LJTG_01.get()), 1) ? ctx.prompt("§6<垃圾桶> §e我看你长得像摩拉盾牌。", false) : ctx.no());
        registerEventInternal(26, ctx -> ctx.TimelimitedCombat(EntityType.ZOMBIE,6,5,7,14,ctx.getRandomEvemtID(),"§a奖励§e和§c随机"));
        registerEventInternal(27, ctx -> ctx.TimelimitedCombat(EntityType.CREEPER,2,0,null,null));
        registerEventInternal(28, ctx -> ctx.TimelimitedCombat(EntityType.RAVAGER, 1, 0, entity -> {entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);entity.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1);}, null));
        registerEventInternal(29, ctx -> ctx.TimelimitedCombat(EntityType.ZOMBIE, 5, 3, ctx.getRandom(0.5) ? 29 : ctx.getRandomEvemtID(), ctx.getRandomEvemtID(), 13, "§c战斗§e或§a随机"));
        registerEventInternal(30, ctx -> ctx.setGuiItem(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), ctx.random(1, 10), ctx.random(1, 10), ctx.random(1, 10)));
        registerEventInternal(31, ctx -> ctx.setGuiItem(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), ctx.random(5, 20), ctx.random(5, 20), ctx.random(5, 20)));
        registerEventInternal(32, ctx -> ctx.setGuiItem(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), ctx.random(10, 40), ctx.random(10, 40), ctx.random(10, 40)));
        registerEventInternal(33, ctx -> ctx.setGuiItem(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), ctx.random(15, 64), ctx.random(15, 64), ctx.random(15, 64)));
        registerEventInternal(34, ctx -> ctx.updateEventQuotaWorld(1,false));
        registerEventInternal(35, ctx -> ctx.updateEventQuotaWorld(-1,false));
        registerEventInternal(36, ctx -> ctx.updateEventQuotaPlayer(1));
        registerEventInternal(37, ctx -> ctx.updateEventQuotaPlayer(-1));
        registerEventInternal(38, ctx -> ctx.updateEventQuotaWorld(1,true));
        registerEventInternal(39, ctx -> ctx.updateEventQuotaWorld(-1,true));
    }

    public static boolean execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (!(entity instanceof Player)) return false;

        double ie = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");
        int eventId = (int) ie;

        Function<EventContext, Boolean> handler = EVENT_HANDLERS.get(eventId);
        if (handler == null) return false;

        // 创建事件上下文并执行
        EventContext context = new EventContext(eventId, (Player) entity, world);
        boolean result = handler.apply(context);

        if (result) {
            itemstack.shrink(1);
        }

        return result;
    }

    public static class EventContext {
        private final int id;
        private final LevelAccessor world;
        private final Player player;
        private final String eka;
        private final double x;
        private final double y;
        private final double z;
        private final double compare;

        public EventContext(int id, Player player, LevelAccessor world) {
            this.id = id;
            this.world = world;
            this.player = player;
            this.compare = Math.random();
            this.eka = "EventKillAll_" + id;
            this.x = player.getX();
            this.y = player.getY();
            this.z = player.getZ();
        }

        public int getId() {
            return id;
        }

        public Player getPlayer() {
            return player;
        }

        public LevelAccessor getWorld() {
            return world;
        }

        public boolean getRandom(double value) {
            return !world.isClientSide() && compare < value;
        }

        public double x() {
            return x;
        }

        public double y() {
            return y;
        }

        public double z() {
            return z;
        }
        /**
         * 玩家事件修改
         */
        public boolean updateEventQuotaPlayer(int value) {
            PrimogemcraftModVariables.PlayerVariables _ie = player.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
            _ie.Event_entity = _ie.Event_entity += value;
            prompt((value < 0 ? "§c" : "§a") + "当前玩家存储的可触发事件数量：" + new DecimalFormat("##.##").format(_ie.Event_entity), false);
            _ie.markSyncDirty();
            return true;
        }
        /**
         * 世界事件修改
         */
        public boolean updateEventQuotaWorld(int value, boolean rule) {
            if (world == null || world.getServer() == null) {
                return false;
            }
            var _iw = PrimogemcraftModVariables.MapVariables.get(world);
            int w = world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZESHIJIANXIANZHI);
            String s = value < 0 ? "§c" : "§a";
            if (rule && addOrDeductGameRule(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGMINGZHI, value)) {
                world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("§l§6<<" + player.getDisplayName().getString() + ">>" + s + "让世界中事件变得" + (value < 0 ? "稀少了！" : "更多了！")), false);
                return true;
            }
            if (_iw.shijian_xianzhi + -value > w) {
                updateEventQuotaPlayer(value);
                prompt("§9由于世界事件存储已达上限，将转移至玩家存储", false);
            } else {
                _iw.shijian_xianzhi += -value;
            }
            prompt(s + "当前世界可触发事件数：" + new DecimalFormat("##.##").format(w - _iw.shijian_xianzhi), false);
            _iw.markSyncDirty();

            return true;
        }

        /**
         * 添加或减少数字世界规则
         */
        public boolean addOrDeductGameRule(GameRules.Key<GameRules.IntegerValue> ruleKey, int newValue) {
            return setGameRule(ruleKey, world.getLevelData().getGameRules().getInt(ruleKey) + newValue);
        }

        /**
         * 设置数字世界规则
         */
        public boolean setGameRule(GameRules.Key<GameRules.IntegerValue> ruleKey, int newValue) {
            if (newValue>10000)return false;
            world.getLevelData().getGameRules().getRule(ruleKey).set(newValue, world.getServer());
            return true;
        }

        /**
         * 接收对应等级附魔并为实体打开附魔GUI，最大4
         */
        public boolean openEnchGui(int value) {
            player.getPersistentData().putDouble("pgc_shijian_fumo_pinzhi", value);
            PrimogemcraftMod.queueServerWork(1, () -> {
                if (player instanceof ServerPlayer serverPlayer) {
                    BlockPos pos = BlockPos.containing(x, y, z);
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
        public boolean costItem(ItemStack item, int value) {
            int total = 0;
            if (player.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable itemHandler) {
                for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
                    ItemStack slotStack = itemHandler.getStackInSlot(slot).copy();
                    if (slotStack.getItem() == item.getItem()) {
                        total += slotStack.getCount();
                    }
                }
            }

            if (total >= value && player != null) {
                ItemStack toRemove = new ItemStack(item.getItem());
                player.getInventory().clearOrCountMatchingItems(p -> toRemove.getItem() == p.getItem(), value, player.inventoryMenu.getCraftSlots());
                return true;
            }
            return false;
        }

        /**
         * 服务器随机整数
         */
        public int random(int min, int max) {
            return !world.isClientSide() ? Mth.nextInt(RandomSource.create(), min, max) : 0;
        }

        /**
         * 造成百分比的 zhi 伤害
         */
        public boolean costHpPercent(double zhi) {
            if (player instanceof LivingEntity livingEntity) {
                float maxHealth = livingEntity.getMaxHealth();
                if (livingEntity.getHealth() >= maxHealth * zhi) {
                    player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), maxHealth * (float) zhi);
                    return true;
                }
            }
            return false;
        }

        /**
         * 播放条件不足
         */
        public boolean no() {
            if (Timer.isDone(player, "Event_Tri")) {
                Timer.set(player, "Event_Tri", 100);
                prompt("§c§l条件不足", false);
            }
            return false;
        }

        /**
         * 发送消息
         */
        public boolean prompt(String message, boolean bottom) {
            if (!player.level().isClientSide())
                player.displayClientMessage(Component.literal(message), bottom);
            return true;
        }

        /**
         * 立即生成物品三选一界面
         */
        public boolean giveTagLootItem(boolean qd, String tag_) {
            GUIqwxz03Procedure.execute(world, player, qd, tag_);
            return true;
        }

        /**
         * 给物品
         */
        public boolean giveItem(ItemStack itemStack, int value) {
            ItemStack _setstack = itemStack;
            _setstack.setCount(value);
            ItemHandlerHelper.giveItemToPlayer(player, _setstack);
            return true;
        }

        public int getRandomEvemtID(){
            return EventGroupProcedure.getRandomRegisteredEventId(world);
        }

        /**
         * 简单限时挑战
         */
        public boolean TimelimitedCombat(EntityType<?> entityType, int count,int scope, int event1, int event2, int event3, String name) {
            return TimelimitedCombat(entityType, count, scope, event1, event2, event3, name, null, null);
        }

        /**
         * 自定义限时挑战
         */
        public boolean TimelimitedCombat(EntityType<?> entityType, int count, int scope, Consumer<LivingEntity> modifier, Consumer<Player> _true_) {
            return TimelimitedCombat(entityType, count, scope,0,0,0,"", modifier, _true_);
        }

        /**
         * 封装预制限时挑战
         *
         * @param count      生成数量
         * @param scope      最小达成值
         * @param event1     完成后打开临时事件组（省略了2/3和名称注释）
         * @param modifier   生成的实体->自定义实体实现
         * @param _true_     玩家完成挑战后->自定义实现
         * @return 成功执行
         */
        public boolean TimelimitedCombat(EntityType<?> entityType, int count, int scope, int event1, int event2, int event3, String name, Consumer<LivingEntity> modifier, Consumer<Player> _true_) {
            return spawnEntitiesInRange(entityType, count, 10, entity -> {
                applyEntityModifier(entity, livingEntity -> {
                    if (modifier != null) applyEntityModifier(entity, modifier);
                    invokeKillAll(livingEntity, Math.min(count, scope), _true_ != null ? _true_ : _true -> {
                        if (name == "")return;
                        createSimpleGroup(event1, event2, event3, name);
                    });
                });
            });
        }

        /**
         * 将生成的实体赋予可选择额外战利品
         */
        public boolean entityLoottab(Entity spawnedEntity, String lootTable, boolean useTag) {
            if (spawnedEntity == null || player == null) return false;

            if (!world.isClientSide()) {
                spawnedEntity.getPersistentData().putString("Event_Entity_Loot", lootTable);
                spawnedEntity.getPersistentData().putBoolean("Event_Entity_Loot_tag", useTag);
                return true;
            }
            return false;
        }

        /**
         * 返回生成可定义实体
         */
        public Entity entityType(EntityType<?> entityType) {
            if (world.isClientSide() || player == null) return null;

            if (world instanceof ServerLevel serverLevel) {
                Entity spawnedEntity = entityType.spawn(serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                return spawnedEntity;
            }
            return null;
        }

        /**
         * 嵌套事件
         */
        public boolean createSimpleGroup(int event1, int event2, int event3, String neme) {
            GUIqwxz03Procedure.execute(world, player, false, "primogemcraft:event");
            return EventGroupProcedure.createSimpleGroup(player, world, event1, event2, event3, neme);
        }
        /**
         * 简单成多个实体
         */
        public boolean spawnEntitiesInRange(EntityType<?> entityType, int count, double radius) {
            return spawnEntitiesInRange(entityType, count, radius, null);
        }
        /**
         * 多个实体，包含可选tag或战利品表
         */
        public boolean spawnEntitiesInRange(EntityType<?> entityType, int count, String lootTable, boolean useTag) {
            return spawnEntitiesInRange(entityType, count, 5, entity -> {
                entityLoottab(entity, lootTable, useTag);
            });
        }
        /**
         * 在指定范围内生成多个实体
         *
         * @param entityType     实体类型
         * @param count          生成数量
         * @param radius         生成半径
         * @param entityModifier 实体修饰器（可选，可对每个生成的实体进行额外操作）
         * @return 是否至少成功生成一个实体
         */
        public boolean spawnEntitiesInRange(EntityType<?> entityType, int count, double radius, Consumer<Entity> entityModifier) {
            return new EventEntityScopeSpawn(world, player).spawnEntitiesInRange(entityType, count, radius, entityModifier);
        }

        /**
         * 应用实体修饰符 - 专门处理 LivingEntity 类型的修饰
         *
         * @param entity   要修饰的实体
         * @param modifier 对 LivingEntity 进行修饰的操作
         * @return 是否成功应用修饰
         */
        public boolean applyEntityModifier(Entity entity, Consumer<LivingEntity> modifier) {
            if (entity instanceof LivingEntity living) {
                modifier.accept(living);
                return true;
            }
            return false;
        }
        /**
         * 时限判定
         */
        public void killAll(Entity entity) {
            entity.getPersistentData().putDouble("EventKillAll_", id);
            player.getPersistentData().putDouble(eka, 1);
            Timer.set(player, eka, 3600);
            setEffect(MobEffects.GLOWING, entity,3600,0);
            setEffect(MobEffects.FIRE_RESISTANCE, entity,3600,0);
            setTarget(entity);
        }
        /**
         * 挑战实现
         */
        public void invokeKillAll(Entity entity, int value, java.util.function.Consumer<Player> _true) {
            killAll(entity);
            impKillAll(value, _true);
        }

        /**
         * 时限挑战和实现
         */
        public boolean impKillAll(int value, java.util.function.Consumer<Player> _true) {
            var n = (int) player.getPersistentData().getDouble(eka);
            var a = n < value + 1 && n != 0;
            if (Timer.isDone(player, eka)) {
                if (Timer.isDone(player, eka + "0")) {
                    prompt("§c挑战时间结束", false);
                    Timer.set(player, eka + "0", 20);
                }
                player.getPersistentData().putDouble(eka, 0);
                return false;
            }
            if (a) {
                PrimogemcraftMod.queueServerWork(20, () -> {
                    impKillAll(value, _true);
                });
                return false;
            }
            if (_true != null&&Timer.isDone(player,"impKillAll")){
                Timer.set(player,"impKillAll",20);
                _true.accept(player);
            }
            player.getPersistentData().putDouble(eka, 0);
            return true;
        }

        /**
         * 仅设置状态效果
         */
        public boolean setEffect(Holder<MobEffect> eff, Entity entity, int tick, int lv) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect((new MobEffectInstance(eff, tick, lv, false, false)));
                return true;
            }
            return false;
        }
        /**
         * 设置仇恨至玩家
         */
        public void setTarget (Entity entity){
            if (entity instanceof Mob _entity && player instanceof LivingEntity _ent)
                _entity.setTarget(_ent);
        }
        /**
         * 三物品三值
         */
        public boolean setGuiItem(ItemStack item1, ItemStack item2, ItemStack item3, int count1, int count2, int count3) {
            SetItemGui.quickOpen(player, world, item1, count1, item2, count2, item3, count3);
            return true;
        }

        /**
         * 单物品三值
         */
        public boolean setGuiItem(ItemStack item1, int count1, int count2, int count3) {
            SetItemGui.quickOpen(player, world, item1, count1, count2, count3);
            return true;
        }

        /**
         * 单数量Tag或LotTab选择
         */
        public boolean setGuiItem(String tagloot, boolean tag) {
            GUIqwxz03Procedure.execute(world, player, tag, tagloot);
            return true;
        }
    }

    /**
     * 保持原有静态辅助方法
     */
    public static int getRegisteredEventCount() {
        return EVENT_HANDLERS.isEmpty() ? 0 : EVENT_HANDLERS.keySet().stream().max(Integer::compareTo).orElse(0);
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