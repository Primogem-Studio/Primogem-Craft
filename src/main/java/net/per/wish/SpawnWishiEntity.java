package net.per.wish;

import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.entity.QQyuanchuzi01Entity;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.procedures.CaptureWishProgressProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.function.Consumer;

import static net.mcreator.ceshi.init.PrimogemcraftModEntities.*;
import static net.minecraft.util.datafix.fixes.ItemIdFix.getItem;

public class SpawnWishiEntity {
    private final LevelAccessor world;
    private final Player player;
    private final double x;
    private final double y;
    private final double z;
    private final int entityVale;
    private final double wishVale;
    private final boolean fallback;
    private final boolean easteregg;

    private final PrimogemcraftModVariables.PlayerVariables _vars;

    private final Entity wishentity;
    private final CompoundTag enbt;

    public SpawnWishiEntity(LevelAccessor world, Player player, int entityVale, double wishVale, double x, double y, double z, boolean fallback,boolean easteregg) {
        this.world = world;
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
        this.entityVale = entityVale;
        this.wishVale = wishVale / entityVale;
        this.fallback = fallback;
        this.easteregg = easteregg;
        
        this._vars = player.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);

        this.wishentity = getWishEntity();
        this.enbt = wishentity != null ? wishentity.getPersistentData() : new CompoundTag();
    }


    private Entity entityType(EntityType<?> entityType) {
        if (world.isClientSide() || player == null) return null;

        if (world instanceof ServerLevel serverLevel) {
            Entity spawnedEntity = entityType.spawn(serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            spawnedEntity.getPersistentData().putString("qiyuan_guishu", (player.getDisplayName().getString()));
            spawnedEntity.getPersistentData().putBoolean("chouka_jiance", true);
            setColorGlassesEffect(spawnedEntity);
            return spawnedEntity;
        }
        return null;
    }

    private Entity getWishEntity() {
        if (wishConclusion(wishRate(0.3, 10), _vars.jin_baodi, 49, false, _true -> {
            _vars.wj_ck_jin++;_vars.jin_baodi = 0;_vars.zi_baodi++;
            captureWish();
        })) return entityType(QQIYUAN_JIN_GUANG.get());
        else if (wishConclusion(wishRate(2, 5), _vars.zi_baodi, 9, false, _true -> {
            _vars.wj_ck_zi++;_vars.zi_baodi = 0;if (fallback) _vars.jin_baodi++;
        })) return entityType(Q_QYUANCHUZI_01.get());
        else {wishConclusion(true, _true -> {_vars.wj_ck_lan++;_vars.zi_baodi++;if (fallback) _vars.jin_baodi++;});
            return entityType(QQ_QYUANCHULAN_01.get());
        }
    }

    private double wishRate(double value2, double value3) {
        return (value2 + (wishVale > 0 ? (wishVale / value3) * 0.1 : 0)) / 10;
    }

    private boolean wishConclusion(boolean logic, Consumer<Player> _true_) {
        double a = logic ? 1 : 0;
        return wishConclusion(1, 0, a, logic, _true_);
    }

    private boolean wishConclusion(double value, double _var, double varsvalue, boolean logic, Consumer<Player> _true_) {
        if (world.isClientSide())return false;
        if (_true_ != null && Math.random() < value || (_var >= varsvalue || logic)) {
            _true_.accept(player);
            _vars.markSyncDirty();
            return true;
        }
        return false;
    }

    private void captureWish() {
        if (Math.random() < (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEBUHUOMINGGUANGZHI)) * 0.01) {
            PrimogemcraftMod.queueServerWork(20, () -> {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:bhmg_y")), SoundSource.NEUTRAL, 4, 1);
                    }
                }
            });
            PrimogemcraftMod.queueServerWork(40, () -> {
                if (wishentity instanceof QqiyuanJinGuangEntity _datEntSetL)
                    _datEntSetL.getEntityData().set(QqiyuanJinGuangEntity.DATA_bhmg, true);
                enbt.putBoolean("lizi", true);
                CaptureWishProgressProcedure.execute(player);
            });
        }
    }

    private void setColorGlassesEffect(Entity entity) {
        switch (entity) {
            case QqiyuanJinGuangEntity g -> g.getEntityData().set(QqiyuanJinGuangEntity.DATA_scmj, easteregg);
            case QQyuanchuzi01Entity c -> c.getEntityData().set(QQyuanchuzi01Entity.DATA_scmj, easteregg);
            default -> {}
        }
    }

    public static class Spawn {
        private final LevelAccessor world;
        private final Player player;
        private final boolean easteregg;
        private final int entityVale;
        private final double wishVale;
        private final boolean fallback;

        public Spawn(LevelAccessor world, Entity player, int entityVale, double wishVale, boolean fallback) {
            this.world = world;
            this.player = (Player) player;
            this.easteregg = (player instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.SCMJ_HELMET.get();
            this.entityVale = entityVale;
            this.wishVale = easteregg ? wishVale + (wishVale * 0.05) : wishVale;
            this.fallback = fallback;
        }

        public void SpawnTiming(int timing) {
            PrimogemcraftMod.queueServerWork(timing, () -> {
                Spawn();
            });
        }

        private void SpawnNew(int entityVale, double wishVale, double x, double y, double z, boolean fallback) {
            new SpawnWishiEntity(world, player, entityVale, wishVale, x, y, z, fallback,easteregg);
        }

        private void SpawnNew(double x, double y, double z, boolean fallback) {
            new SpawnWishiEntity(world, player, entityVale, wishVale, x, y, z, fallback,easteregg);
        }

        public void Spawn() {
            double R_radius = 0;
            double D_delta_theta = 0;
            double T_theta = 0;
            double N_number = 0;
            double x = player.getX();
            double y = player.getY();
            double z = player.getZ();

            R_radius = Math.max(3, 3 + (entityVale - 10) * 0.1);

            switch (entityVale) {
                case 1 -> SpawnNew(x, y + 10, z, fallback);
                case 10 -> {
                    double case10Radius = 5;
                    N_number = entityVale - 2;
                    D_delta_theta = (2 * Math.PI) / N_number;
                    for (int index0 = 0; index0 < (int) N_number; index0++) {
                        T_theta = index0 * D_delta_theta;
                        SpawnNew(8, wishVale * 0.8, x + case10Radius * Math.sin(T_theta), y + 6, z + case10Radius * Math.cos(T_theta), fallback);
                    }
                    SpawnNew(1, wishVale / 10, x, y + 6, z, fallback);
                    SpawnNew(1, wishVale / 10, x, y + 7, z, fallback);
                }
                default -> {
                    if (entityVale > 10) {
                        // 实心圆生成逻辑
                        int totalPoints = entityVale;
                        int layers = (int) Math.max(3, Math.sqrt(totalPoints / Math.PI));

                        // 计算每层的点数
                        int pointsInOuterCircle = (int) (totalPoints * 0.4);
                        int pointsPerLayer = Math.max(3, pointsInOuterCircle / layers);

                        for (int layer = 0; layer < layers; layer++) {
                            // 当前层半径（从内到外）
                            double currentRadius = R_radius * (layer + 1) / layers;

                            // 当前层点数，内层点数少，外层点数多
                            int pointsInCurrentLayer;
                            if (layer == layers - 1) { // 最外层
                                pointsInCurrentLayer = Math.max(3, totalPoints - (layers - 1) * pointsPerLayer);
                            } else {
                                pointsInCurrentLayer = pointsPerLayer + layer; // 每层递增一些点数
                            }

                            // 生成当前层的点
                            D_delta_theta = (2 * Math.PI) / pointsInCurrentLayer;
                            for (int index0 = 0; index0 < pointsInCurrentLayer; index0++) {
                                T_theta = index0 * D_delta_theta;
                                // 添加一些随机偏移使分布更自然
                                double randomOffset = 0.1 * Math.random();
                                double offsetRadius = currentRadius * (1 + randomOffset - 0.05);

                                SpawnNew(x + offsetRadius * Math.sin(T_theta),
                                        y + 6 + (Math.min((entityVale * 0.2), 58)),
                                        z + offsetRadius * Math.cos(T_theta),
                                        fallback);
                            }
                        }
                    } else {
                        N_number = entityVale;
                        R_radius = 3;
                        D_delta_theta = (2 * Math.PI) / N_number;
                        for (int index0 = 0; index0 < (int) N_number; index0++) {
                            T_theta = index0 * D_delta_theta;
                            SpawnNew(x + R_radius * Math.sin(T_theta), y + 6, z + R_radius * Math.cos(T_theta), fallback);
                        }
                    }
                }
            }
            if (!world.isClientSide()) {
                world.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:choukaqianxi01")), SoundSource.BLOCKS, 4, 1);
            }
        }
    }
}
