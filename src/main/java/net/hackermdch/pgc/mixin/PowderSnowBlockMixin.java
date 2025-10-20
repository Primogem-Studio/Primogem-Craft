package net.hackermdch.pgc.mixin;

import net.hackermdch.pgc.interfaces.IPlayerExt;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.world.level.block.PowderSnowBlock;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin {
    @Inject(method = "canEntityWalkOnPowderSnow", at = @At("HEAD"), cancellable = true)
    private static void canEntityWalkOnPowderSnow(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof IPlayerExt pl && pl.pgc$getWalkSnow()) cir.setReturnValue(true);
    }
}
