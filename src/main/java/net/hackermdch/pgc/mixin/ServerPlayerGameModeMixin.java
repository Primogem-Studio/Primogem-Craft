package net.hackermdch.pgc.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hackermdch.pgc.interfaces.UseAlways;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerPlayerGameMode.class)
public class ServerPlayerGameModeMixin {
    @WrapOperation(method = "useItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemCooldowns;isOnCooldown(Lnet/minecraft/world/item/Item;)Z"))
    private boolean canUse(ItemCooldowns instance, Item item, Operation<Boolean> original) {
        return !(item instanceof UseAlways) && original.call(instance, item);
    }
}
