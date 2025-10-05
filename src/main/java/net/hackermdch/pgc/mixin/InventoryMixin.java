package net.hackermdch.pgc.mixin;

import com.google.common.collect.ImmutableSet;
import com.llamalad7.mixinextras.sugar.Local;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.hackermdch.pgc.CustomUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(Inventory.class)
public abstract class InventoryMixin implements Container, Nameable {
    @Shadow
    @Final
    public Player player;
    @Unique
    private final Set<Item> items = CustomUtils.enableInventoryAttribute.stream().map(s -> BuiltInRegistries.ITEM.getHolder(ResourceLocation.parse(s)).orElseThrow().value()).collect(ImmutableSet.toImmutableSet());
    @Unique
    private final Set<ItemStack> cache = new ObjectArraySet<>(), snapshot = new ObjectArraySet<>();

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;inventoryTick(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/Entity;IZ)V"))
    private void inventoryTick(CallbackInfo ci, @Local(ordinal = 1) int i, @Local NonNullList<ItemStack> stacks) {
        var item = stacks.get(i);
        if (items.contains(item.getItem())) {
            var flag = false;
            for (var m : item.getAttributeModifiers().modifiers()) {
                if (m.slot() == EquipmentSlotGroup.ANY) {
                    var attr = player.getAttributes();
                    if (!attr.hasModifier(m.attribute(), m.modifier().id()) && attr.getInstance(m.attribute()) instanceof AttributeInstance ins) {
                        ins.addTransientModifier(m.modifier());
                        flag = true;
                    }
                }
            }
            var copy = item.copy();
            if (flag) cache.add(copy);
            snapshot.add(copy);
        }
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void tick(CallbackInfo ci) {
        cache.forEach(item -> {
            if (snapshot.stream().noneMatch(i -> ItemStack.isSameItemSameComponents(item, i))) {
                item.getAttributeModifiers().modifiers().forEach(m -> {
                    if (m.slot() == EquipmentSlotGroup.ANY) {
                        var attr = player.getAttributes();
                        if (attr.hasModifier(m.attribute(), m.modifier().id()) && attr.getInstance(m.attribute()) instanceof AttributeInstance ins) {
                            ins.removeModifier(m.modifier());
                        }
                    }
                });
                cache.remove(item);
            }
        });
        snapshot.clear();
    }
}
