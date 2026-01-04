package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.per.event.EventEntityScopeSpawn;
import net.per.tool.ToolPGC;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        registerEventInternal(20, ctx -> ctx.ees.entityLoottab(ctx.ees.entityType(S_WFENGRAOJIANGSHI.get()), "primogemcraft:fengraozlpevent", false));
        registerEventInternal(21, ctx -> ctx.TimelimitedCombat(S_WFENGRAOJIANGSHI.get(), 2, 0, entity -> {entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(2);entity.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1);}, null));
        registerEventInternal(22, ctx -> ctx.ees.spawnEntitiesInRange(EntityType.ZOMBIE, 5, 5));
        registerEventInternal(23, ctx -> ctx.giveItem(new ItemStack(Items.SHIELD).copy(), 1) ? ctx.prompt("§6<垃圾桶> §f不，盾牌才是你的掉落物。", false) : ctx.no());
        registerEventInternal(24, ctx -> ctx.giveItem(new ItemStack(PrimogemcraftModItems.QWYZZM.get()), 1) ? ctx.prompt("§6<垃圾桶> §c哈哈，你其实掉落了一个愚者面具！", false) : ctx.no());
        registerEventInternal(25, ctx -> ctx.giveItem(new ItemStack(PrimogemcraftModItems.LJTG_01.get()), 1) ? ctx.prompt("§6<垃圾桶> §e我看你长得像摩拉盾牌。", false) : ctx.no());
        registerEventInternal(26, ctx -> ctx.TimelimitedCombat(EntityType.ZOMBIE,6,5,7,14,ctx.getRandomEvemtID(),"§a奖励§e和§c随机"));
        registerEventInternal(27, ctx -> ctx.TimelimitedCombat(EntityType.CREEPER,2,0,null,null));
        registerEventInternal(28, ctx -> ctx.TimelimitedCombat(EntityType.RAVAGER, 1, 0, entity -> {entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);entity.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1);}, null));
        registerEventInternal(29, ctx -> ctx.TimelimitedCombat(EntityType.ZOMBIE, 5, 3, ctx.getRandom(0.5) ? 29 : ctx.getRandomEvemtID(), ctx.getRandomEvemtID(), 13, "§c战斗§e或§a随机"));
        registerEventInternal(30, ctx -> ctx.setGuiItem(new ItemStack(YUZHOUSUIPIAN.get()), ctx.random(1, 10), ctx.random(1, 10), ctx.random(1, 10)));
        registerEventInternal(31, ctx -> ctx.setGuiItem(new ItemStack(YUZHOUSUIPIAN.get()), ctx.random(5, 20), ctx.random(5, 20), ctx.random(5, 20)));
        registerEventInternal(32, ctx -> ctx.setGuiItem(new ItemStack(YUZHOUSUIPIAN.get()), ctx.random(10, 40), ctx.random(10, 40), ctx.random(10, 40)));
        registerEventInternal(33, ctx -> ctx.setGuiItem(new ItemStack(YUZHOUSUIPIAN.get()), ctx.random(15, 64), ctx.random(15, 64), ctx.random(15, 64)));
        registerEventInternal(34, ctx -> ctx.updateEventQuotaWorld(1,false));
        registerEventInternal(35, ctx -> ctx.updateEventQuotaWorld(-1,false));
        registerEventInternal(36, ctx -> ctx.updateEventQuotaPlayer(1));
        registerEventInternal(37, ctx -> ctx.updateEventQuotaPlayer(-1));
        registerEventInternal(38, ctx -> ctx.updateEventQuotaWorld(1,true));
        registerEventInternal(39, ctx -> ctx.updateEventQuotaWorld(-1,true));
        registerEventInternal(40, ctx -> ctx.giveItem(new ItemStack(Items.REDSTONE),8,item->{item.set(DataComponents.CUSTOM_NAME, Component.literal("雷石东"));}));
        registerEventInternal(41, ctx -> ctx.giveItem(new ItemStack(Blocks.CHEST), 1, item -> {item.enchant(ctx.getWorld().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), 1);}));
        registerEventInternal(42, ctx -> ctx.TimelimitedCombat(EntityType.SILVERFISH, 1, 1, 40, 41, 0, "§e抢劫！"));
        registerEventInternal(43, ctx -> ctx.eventMultiple(10));
        registerEventInternal(44, ctx -> ctx.set.giveTagLootItem(true,"c:curio/code"));
        registerEventInternal(45, ctx -> {Timer.set(ctx.player, "lotteryX",72000);ctx.prompt("§c一小时内无法使用乐透奇物！",false);return true;});
        registerEventInternal(46, ctx -> {boolean ok = ctx.costHpPercent(0.5); Timer.set(ctx.player, "lotteryX", ok ? 6000 : 72000);ctx.prompt((ok?"§e5分钟":"§c一小时")+"内无法使用乐透奇物！",false);return true;});
        registerEventInternal(47, ctx -> {Timer.set(ctx.player, "lotteryX",72000);ctx.set.createSimpleGroup(48,49,0,"§e交付勒索");ctx.prompt("§c一小时内无法使用乐透奇物！",false); return true;});
        registerEventInternal(48, ctx -> {boolean ok = ctx.costItem(new ItemStack(YUZHOUSUIPIAN.get()), 20);if (ok) Timer.set(ctx.player, "lotteryX", 6000 );ctx.prompt(ok?"§e5分钟内无法使用乐透奇物！":"§c条件不足",false); ;return ok;});
        registerEventInternal(49, ctx -> {boolean ok = ctx.costItem(new ItemStack(YUZHOUSUIPIAN.get()), 40);if (ok) Timer.set(ctx.player, "lotteryX", 0 );ctx.prompt(ok?"§a遭遇解除，你可以使用乐透类奇物了！":"§c条件不足",false);return ok;});
    }

    public static boolean execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (!(entity instanceof Player)) return false;

        double ie = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");
        int eventId = (int) ie;

        Function<EventContext, Boolean> handler = EVENT_HANDLERS.get(eventId);
        if (handler == null) return false;

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
        private final double x;
        private final double y;
        private final double z;
        private final double compare;
        private final ToolPGC.set set;
        private final EventEntityScopeSpawn ees;

        public EventContext(int id, Player player, LevelAccessor world) {
            this.id = id;
            this.world = world;
            this.player = player;
            this.compare = Math.random();
            this.x = player.getX();
            this.y = player.getY();
            this.z = player.getZ();
            this.set = new ToolPGC.set(player,world);
            this.ees = new EventEntityScopeSpawn(world, player);
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

        public boolean eventMultiple(int value) {
            if (world.isClientSide())return false;
            if (Timer.isDone(player, "maxUes")) {
                Timer.set(player, "maxUes", 20);
                for (int i = 0; i < value; i++) {
                    EventGroupProcedure.execute(world, player, EventGroupProcedure.getWeightedRandomGroupId(world));
                }
                PrimogemcraftMod.queueServerWork(5, player::closeContainer);
            } else return false;
            return true;
        }
        /**
         * 玩家事件修改
         */
        public boolean updateEventQuotaPlayer(int value) {
            PrimogemcraftModVariables.PlayerVariables _ie = player.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
            _ie.Event_entity += value;
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
            set.openEnchGui(value);
            return true;
        }

        /**
         * 移除特定数量的item
         */
        public boolean costItem(ItemStack item, int value) {
            return set.costItem(item,value);
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
                set.prompt("§c§l条件不足", false);
            }
            return false;
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
        public boolean giveItem(ItemStack baseItem, int value, Consumer<ItemStack> itemModifier) {
            return set.giveItem(baseItem,value,itemModifier);
        }
        public boolean giveItem(ItemStack baseItem, int value) {
            return set.giveItem(baseItem,value,null);
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
            return ees.new TimedChallenge("EventKillAll_" + id, id).TimelimitedCombat(entityType, count, scope, event1, event2, event3, name, modifier, _true_);
        }

        /**
         * 应用实体修饰符 - 专门处理 LivingEntity 类型的修饰
         *
         * @param entity   要修饰的实体
         * @param modifier 对 LivingEntity 进行修饰的操作
         * @return 是否成功应用修饰
         */
        public boolean applyEntityModifier(Entity entity, Consumer<LivingEntity> modifier) {
            return ees.applyEntityModifier(entity,modifier);
        }

        /**
         * 仅设置状态效果
         */
        public boolean setEffect(Holder<MobEffect> eff, Entity entity, int tick, int lv) {
            return ees.setEffect(eff,entity,tick,lv);
        }
        /**
         * 三物品三值
         */
        public boolean setGuiItem(ItemStack item1, ItemStack item2, ItemStack item3, int count1, int count2, int count3) {
            return set.setGuiItem(item1, item3, item2, count2, count1, count3);
        }

        /**
         * 单物品三值
         */
        public boolean setGuiItem(ItemStack item1, int count1, int count2, int count3) {
            return set.setGuiItem(item1, count1, count2, count3);
        }

        /**
         * 单数量Tag或LotTab选择
         */
        public boolean setGuiItem(String tagloot, boolean tag) {
            set.setGuiItem(tagloot, tag);
            return true;
        }
        /**
         * 发送消息
         */
        public boolean prompt(String s,boolean bottom){
            return set.prompt(s,bottom);
        }
    }

    /**
     * 保持原有静态辅助方法
     */
    public static int getRegisteredEventCount() {
        return EVENT_HANDLERS.isEmpty() ? 0 : EVENT_HANDLERS.keySet().stream().max(Integer::compareTo).orElse(0);
    }

    public static List<Integer> getRegisteredEventIds() {
        return new ArrayList<>(EVENT_HANDLERS.keySet());
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