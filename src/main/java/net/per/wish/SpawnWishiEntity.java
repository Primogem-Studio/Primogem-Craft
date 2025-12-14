package net.per.wish;

import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.procedures.CaptureWishProgressProcedure;
import net.mcreator.ceshi.procedures.Scmjsx0Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.function.Consumer;

import static net.mcreator.ceshi.init.PrimogemcraftModEntities.*;

public class SpawnWishiEntity {
    private final LevelAccessor world;
    private final Player player;
    private final double x;
    private final double y;
    private final double z;
    private final int entityVale;
    private final double wishVale;
    private final boolean fallback;

    private final PrimogemcraftModVariables.PlayerVariables _vars;

    private final Entity wishentity;
    private final CompoundTag enbt;

    public SpawnWishiEntity(LevelAccessor world, Player player, int entityVale, double wishVale, double x, double y, double z, boolean fallback) {
        this.world = world;
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
        this.entityVale = entityVale;
        this.wishVale = wishVale / entityVale;
        this.fallback = fallback;

        this._vars = player.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);

        this.wishentity = getWishEntity();
        this.enbt = wishentity != null ? wishentity.getPersistentData() : new CompoundTag();
    }


    public Entity entityType(EntityType<?> entityType) {
        if (world.isClientSide() || player == null) return null;

        if (world instanceof ServerLevel serverLevel) {
            Entity spawnedEntity = entityType.spawn(serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            spawnedEntity.getPersistentData().putString("qiyuan_guishu", (player.getDisplayName().getString()));
            spawnedEntity.getPersistentData().putBoolean("chouka_jiance", true);
            Scmjsx0Procedure.execute(player, spawnedEntity);
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
        if (!world.isClientSide())
            System.out.println(value);
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

    public static void Spawn(LevelAccessor world, Player player, int entityVale, double wishVale) {
        Spawn(world, player, entityVale, wishVale, true);
    }

    public static void SpawnTiming(LevelAccessor world, Player player, int entityVale, double wishVale, int timing) {
        PrimogemcraftMod.queueServerWork(timing, () -> {
            Spawn(world, player, entityVale, wishVale, true);
        });
    }

    public static void Spawn(LevelAccessor world, Player player, int entityVale, double wishVale, boolean fallback) {
        double R_radius = 0;
        double D_delta_theta = 0;
        double T_theta = 0;
        double N_number = 0;
        N_number = entityVale == 10 ? entityVale - 2 : entityVale;
        R_radius = 3;
        D_delta_theta = (2 * Math.PI) / N_number;
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();
        switch (entityVale) {
            case 1 -> new SpawnWishiEntity(world, player, entityVale, wishVale, x, y + 10, z, fallback);
            case 10 -> {
                for (int index0 = 0; index0 < (int) N_number; index0++) {
                    T_theta = index0 * D_delta_theta;
                    new SpawnWishiEntity(world, player, 8, wishVale * 0.8, x + R_radius * Math.sin(T_theta), y + 6, z + R_radius * Math.cos(T_theta), fallback);
                }
                new SpawnWishiEntity(world, player, 1, wishVale / 10, x, y + 6, z, fallback);
                new SpawnWishiEntity(world, player, 1, wishVale / 10, x, y + 7, z, fallback);
            }
            default -> {
                for (int index0 = 0; index0 < (int) N_number; index0++) {
                    T_theta = index0 * D_delta_theta;
                    new SpawnWishiEntity(world, player, entityVale, wishVale, x + R_radius * Math.sin(T_theta), y + 6, z + R_radius * Math.cos(T_theta), fallback);
                }
            }
        }
    }
}
