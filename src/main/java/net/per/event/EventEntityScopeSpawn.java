package net.per.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class EventEntityScopeSpawn {
    private final LevelAccessor world;
    private final Player player;
    private final RandomSource random;
    private final double x;
    private final double y;
    private final double z;

    public EventEntityScopeSpawn(LevelAccessor world, Player player) {
        this.world = world;
        this.player = player;
        this.random = RandomSource.create();
        this.x = player.getX();
        this.y = player.getY();
        this.z = player.getZ();
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
}
