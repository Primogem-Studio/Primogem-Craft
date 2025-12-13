package net.per.wish;

import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.entity.QQQyuanchulan01Entity;
import net.mcreator.ceshi.entity.QQyuanchuzi01Entity;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.procedures.CaptureWishProgressProcedure;
import net.mcreator.ceshi.procedures.QyNBTProcedure;
import net.mcreator.ceshi.procedures.Scmjsx0Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;
import java.util.function.Consumer;

import static net.mcreator.ceshi.init.PrimogemcraftModEntities.QQIYUAN_JIN_GUANG;
import static net.mcreator.ceshi.init.PrimogemcraftModEntities.Q_QYUANCHUZI_01;

public class WishiEntityDuringSpawn {
    private final LevelAccessor world;
    private final Entity wishentity;
    private final Player player;
    private final double x;
    private final double y;
    private final double z;
    private final CompoundTag enbt;
    private final CompoundTag pnbt;
    private final PrimogemcraftModVariables.PlayerVariables _vars;

    public WishiEntityDuringSpawn(LevelAccessor world,Entity wishentity,double x,double y,double z) {
        this.world = world;
        this.wishentity = wishentity;
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = getPlayer();
        this.enbt = wishentity.getPersistentData();
        this.pnbt = player.getPersistentData();
        this._vars = player.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
    }
    public void execute (){
        if (!world.isClientSide()){
            if (wishentity instanceof QQQyuanchulan01Entity) {
                if (wishConclusion(wishRate(0.1,0.3,10),_vars.jin_baodi,49,false,_true->{
                    _vars.jin_baodi = 0;
                    _vars.wj_ck_jin ++;
                    _vars.zi_baodi ++;
                    spawnNewWishEntity(QQIYUAN_JIN_GUANG.get());
                })) return;
                else if (wishConclusion(wishRate(0.1,0.3,10),_vars.zi_baodi,9,false,_true->{
                    setXiangyuNbt();
                    _vars.wj_ck_zi ++;
                    _vars.zi_baodi =0;
                    spawnNewWishEntity(Q_QYUANCHUZI_01.get());
                })) return;
                else {
                    wishConclusion(true, _true -> {
                        _vars.wj_ck_lan++;
                        _vars.zi_baodi++;
                        wishNBT(true,"0");
                        setXiangyuNbt();
                    });return;
                }
            }
            if (wishentity instanceof QQyuanchuzi01Entity) {
                wishNBT(true,"1");
                Scmjsx0Procedure.execute(player, wishentity);
            }
            if (wishentity instanceof QqiyuanJinGuangEntity) {
                var n2 = pnbt.getBoolean("baodi_shoudong");
                if (pnbt.getBoolean("chouka") || n2) {
                    if (n2) {
                        pnbt.putBoolean("baodi_shoudong", false);
                        wishNBT(false, "2");
                    } else {
                        wishNBT(true, "2");
                    }
                    Scmjsx0Procedure.execute(player, wishentity);
                }
                captureWish();

            }
        }
    }
    private Player getPlayer() {
        final Vec3 _center = new Vec3(x, (y - 10), z);
        for (Entity entityiterator : world.getEntitiesOfClass(net.minecraft.world.entity.Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
            if (entityiterator instanceof Player && entityiterator.getPersistentData().getDouble("chouka") > 0) return (Player) entityiterator;}
        return null;
    }
    private double wishRate(double value1, double value2, double value3) {
        return enbt.getBoolean("xiangyu") ? value1 : value2 + (enbt.getDouble("chouka_jiacheng") > 0 ? (enbt.getDouble("Prayers_strengthen") / value3) * 0.01 : 0);
    }

    private boolean wishConclusion(boolean logic, Consumer<Player> _true_) {
        double a = logic ? 1 : 0;
        return wishConclusion(1, 0, a, logic, _true_);
    }
    private boolean wishConclusion(double value, double _var, double varsvalue, boolean logic, Consumer<Player> _true_){
        if (_true_ != null && Math.random() < value && (_var > varsvalue || logic)) {
            _true_.accept(player);
            _vars.markSyncDirty();
            return true;
        }
        return false;
    }
    private void spawnNewWishEntity(EntityType<?> entityType) {
        if (!wishentity.level().isClientSide()) wishentity.discard();
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = entityType.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
        }
    }
    private void setXiangyuNbt(){
        if (!enbt.getBoolean("xiangyu")){
            _vars.jin_baodi ++;
        }
    }
    private void wishNBT(boolean logic,String zhi){
        enbt.putString("qiyuan_guishu", (wishentity.getDisplayName().getString()));
        if (logic) {
            pnbt.putDouble("chouka", (pnbt.getDouble("chouka") - 1));
            pnbt.putDouble("chouka_jiacheng", (pnbt.getDouble("chouka_jiacheng") - 1));
        }
        enbt.putBoolean(("chouka_jiance_" + zhi), true);
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
}
