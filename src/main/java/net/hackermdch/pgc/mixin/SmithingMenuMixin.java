package net.hackermdch.pgc.mixin;

import net.mcreator.ceshi.procedures.YsqhsxProcedure;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmithingMenu.class)
public class SmithingMenuMixin {
    @Inject(method = "onTake", at = @At("HEAD"))
    private void onTake(Player player, ItemStack item, CallbackInfo ci) {
//        YsqhsxProcedure.execute(item);
    }
}
