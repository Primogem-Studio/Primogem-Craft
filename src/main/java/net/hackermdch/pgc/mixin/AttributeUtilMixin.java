package net.hackermdch.pgc.mixin;

import com.google.common.collect.ImmutableSet;
import net.mcreator.ceshi.GlobalAttributeModifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.util.AttributeUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Set;

@Mixin(AttributeUtil.class)
public class AttributeUtilMixin {
    @Unique
    private static final Set<Item> items = GlobalAttributeModifier.inventoryAttributeItems.stream().map(s -> BuiltInRegistries.ITEM.getHolder(ResourceLocation.parse(s)).orElseThrow().value()).collect(ImmutableSet.toImmutableSet());

    @Redirect(method = "applyModifierTooltips", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlotGroup;getSerializedName()Ljava/lang/String;"))
    private static String applyModifierTooltips(EquipmentSlotGroup group, ItemStack stack) {
        if (group == EquipmentSlotGroup.ANY && items.contains(stack.getItem())) return "inventory";
        return group.getSerializedName();
    }
}
