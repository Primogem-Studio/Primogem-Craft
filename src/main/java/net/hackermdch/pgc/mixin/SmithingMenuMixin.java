package net.hackermdch.pgc.mixin;

import net.minecraft.world.inventory.SmithingMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmithingMenu.class)
public class SmithingMenuMixin {
    @Inject(method = "onTake", at = @At("HEAD"))
    private void onTake(CallbackInfo ci) {
    }
}
