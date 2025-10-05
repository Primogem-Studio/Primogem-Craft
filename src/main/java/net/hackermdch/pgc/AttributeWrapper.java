package net.hackermdch.pgc;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.ArrayList;
import java.util.List;

public class AttributeWrapper {
    private final List<ItemAttributeModifiers.Entry> entries = new ArrayList<>();
    private final ItemStack item;

    AttributeWrapper(ItemStack stack) {
        item = stack;
    }

    public void add(String attr, String id, double amount, AttributeModifier.Operation operation, EquipmentSlotGroup group) {
        entries.add(new ItemAttributeModifiers.Entry(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse(attr)).orElseThrow(), new AttributeModifier(ResourceLocation.parse(id), amount, operation), group));
    }

    public void add(Holder<Attribute> attr, String id, double amount, AttributeModifier.Operation operation, EquipmentSlotGroup group) {
        entries.add(new ItemAttributeModifiers.Entry(attr, new AttributeModifier(ResourceLocation.parse(id), amount, operation), group));
    }

    public void add(Holder<Attribute> attribute, AttributeModifier modifier, EquipmentSlotGroup slot) {
        entries.add(new ItemAttributeModifiers.Entry(attribute, modifier, slot));
    }

    public void apply() {
        if (entries.isEmpty()) item.set(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
        var builder = ImmutableList.<ItemAttributeModifiers.Entry>builder();
        item.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY).modifiers().forEach(e -> {
            if (entries.stream().noneMatch(e2 -> e.matches(e2.attribute(), e2.modifier().id()))) builder.add(e);
        });
        builder.addAll(entries);
        item.set(DataComponents.ATTRIBUTE_MODIFIERS, new ItemAttributeModifiers(builder.build(), true));
    }
}
