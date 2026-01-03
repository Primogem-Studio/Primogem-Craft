package net.per.event;

import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.per.tool.ToolPGC;

import java.util.function.Consumer;

public class EventEntityScopeSpawn {
    private final LevelAccessor world;
    private final Player player;
    private final RandomSource random;
    private final double x;
    private final double y;
    private final double z;
    private final ToolPGC.set set;

    public EventEntityScopeSpawn(LevelAccessor world, Player player) {
        this.world = world;
        this.player = player;
        this.random = RandomSource.create();
        this.x = player.getX();
        this.y = player.getY();
        this.z = player.getZ();
        this.set = new ToolPGC.set(player,world);
    }
    public ToolPGC.set getTool(){
        return set;
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
     * 设置仇恨至玩家
     */
    public void setTarget (Entity entity){
        if (entity instanceof Mob _entity && player instanceof LivingEntity _ent)
            _entity.setTarget(_ent);
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
     * 在指定范围内生成多个实体
     *
     * @param entityType     实体类型
     * @param count          生成数量
     * @param radius         生成半径
     * @param entityModifier 实体修饰器（可选，可对每个生成的实体进行额外操作）
     * @return 是否至少成功生成一个实体
     */
    public boolean spawnEntitiesInRange(EntityType<?> entityType, int count, double radius,
                                        Consumer<Entity> entityModifier) {
        if (world.isClientSide() || player == null || count <= 0 || radius < 0) return false;
        if (!(world instanceof ServerLevel serverLevel)) return false;

        boolean success = false;
        BlockPos playerPos = BlockPos.containing(x, y, z);

        for (int i = 0; i < count; i++) {
            // 尝试寻找合适的生成位置
            BlockPos spawnPos = findSafeSpawnPosition(serverLevel, playerPos, radius);

            // 如果找不到合适位置，使用玩家位置
            if (spawnPos == null) {
                spawnPos = playerPos;
            }

            try {
                // 生成实体
                Entity spawnedEntity = entityType.spawn(serverLevel, spawnPos, MobSpawnType.MOB_SUMMONED);

                if (spawnedEntity != null) {

                    // 应用额外的修饰器
                    if (entityModifier != null) {
                        entityModifier.accept(spawnedEntity);
                    }

                    success = true;
                }
            } catch (Exception e) {
                // 生成失败，继续尝试下一个
            }
        }

        return success;
    }

    /**
     * 寻找安全的生成位置
     * 尝试多个随机位置，找到合适的位置生成
     */
    private BlockPos findSafeSpawnPosition(ServerLevel world, BlockPos center, double radius) {
        for (int attempt = 0; attempt < 20; attempt++) {
            double angle = 2 * Math.PI * random.nextDouble();
            double distance = radius * random.nextDouble();

            int xPos = (int) Math.floor(center.getX() + distance * Math.cos(angle));
            int zPos = (int) Math.floor(center.getZ() + distance * Math.sin(angle));

            for (int yOffset = 0; yOffset <= 16; yOffset++) {
                int yUp = Math.min(center.getY() + yOffset, world.getMaxBuildHeight() - 2);
                if (isSuitableSpawnLocation(world, xPos, yUp, zPos)) {
                    return new BlockPos(xPos, yUp, zPos);
                }

                if (yOffset > 0) {
                    int yDown = Math.max(center.getY() - yOffset, world.getMinBuildHeight() + 1);
                    if (isSuitableSpawnLocation(world, xPos, yDown, zPos)) {
                        return new BlockPos(xPos, yDown, zPos);
                    }
                }
            }
        }

        for (int attempt = 0; attempt < 10; attempt++) {
            double angle = 2 * Math.PI * random.nextDouble();
            double distance = radius * random.nextDouble();

            int xPos = (int) Math.floor(center.getX() + distance * Math.cos(angle));
            int zPos = (int) Math.floor(center.getZ() + distance * Math.sin(angle));

            for (int y = world.getMaxBuildHeight() - 1; y >= world.getMinBuildHeight(); y--) {
                if (!world.getBlockState(new BlockPos(xPos, y, zPos)).isAir() &&
                        world.getBlockState(new BlockPos(xPos, y + 1, zPos)).isAir()) {
                    return new BlockPos(xPos, y + 1, zPos);
                }
            }
        }

        return null;
    }

    /**
     * 检查位置是否适合生成生物
     */
    private boolean isSuitableSpawnLocation(ServerLevel world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        BlockPos belowPos = pos.below();
        BlockPos abovePos = pos.above();

        boolean currentAir = world.getBlockState(pos).isAir();
        boolean aboveAir = world.getBlockState(abovePos).isAir();

        if (!currentAir || !aboveAir) {
            return false;
        }

        BlockState belowState = world.getBlockState(belowPos);
        return belowState.isSolid() || belowState.isCollisionShapeFullBlock(world, belowPos);
    }

    public  class TimedChallenge extends EventEntityScopeSpawn{
        private final String eka;
        private final int id;

        public TimedChallenge(String sID, int id) {
            super(world, player);
            this.eka = sID;
            this.id = id;
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
                         set.createSimpleGroup(event1, event2, event3, name);
                    });
                });
            });
        }
        /**
         * 时限判定
         */
        private void killAll(Entity entity) {
            entity.getPersistentData().putDouble("EventKillAll_", id);
            player.getPersistentData().putDouble(eka, 1);
            Timer.set(player, eka, 3600);
            setEffect(MobEffects.GLOWING, entity,3600,0);
            setEffect(MobEffects.FIRE_RESISTANCE, entity,3600,0);
            setTarget(entity);
        }
        private void invokeKillAll(Entity entity, int value, java.util.function.Consumer<Player> _true) {
            killAll(entity);
            impKillAll(value, _true);
        }
        /**
         * 时限挑战和实现
         */
        private void impKillAll(int value, Consumer<Player> _true) {
            var n = (int) player.getPersistentData().getDouble(eka);
            var a = n < value + 1 && n != 0;
            if (Timer.isDone(player, eka)) {
                if (Timer.isDone(player, eka + "0")) {
                    set.prompt("§c挑战时间结束", false);
                    Timer.set(player, eka + "0", 20);
                }
                player.getPersistentData().putDouble(eka, 0);
                return;
            }
            if (a) {
                PrimogemcraftMod.queueServerWork(20, () -> {
                    impKillAll(value, _true);
                });
                return;
            }
            if (_true != null&&Timer.isDone(player,"impKillAll")){
                Timer.set(player,"impKillAll",20);
                _true.accept(player);
            }
            player.getPersistentData().putDouble(eka, 0);
        }
    }
}
