package net.hackermdch.pgc.mixin;

import net.mcreator.ceshi.custom.TrimTooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.armortrim.ArmorTrim;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ArmorTrim.class)
public class ArmorTrimMixin {
    @Shadow
    @Final
    private boolean showInTooltip;

    @Inject(method = "addToTooltip", at = @At("RETURN"))
    private void addToTooltip(Item.TooltipContext context, Consumer<Component> tooltip, TooltipFlag flag, CallbackInfo ci) {
        if (!showInTooltip) return;
        TrimTooltip.addToTooltip((ArmorTrim) (Object) this).forEach(tooltip);
    }
}
