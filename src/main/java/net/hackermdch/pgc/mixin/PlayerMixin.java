package net.hackermdch.pgc.mixin;

import net.hackermdch.pgc.interfaces.IPlayerExt;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity implements IPlayerExt {
    @Unique
    private static final EntityDataAccessor<Boolean> WalkSnowID = SynchedEntityData.defineId(PlayerMixin.class, EntityDataSerializers.BOOLEAN);

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "defineSynchedData", at = @At("RETURN"))
    private void ind(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(WalkSnowID, false);
    }

    @Override
    public boolean pgc$getWalkSnow() {
        return entityData.get(WalkSnowID);
    }

    @Override
    public void pgc$setWalkSnow(boolean value) {
        entityData.set(WalkSnowID, value);
    }
}
