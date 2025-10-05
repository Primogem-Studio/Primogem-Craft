package net.mcreator.ceshi;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;
import static net.minecraft.world.entity.EquipmentSlotGroup.*;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_BASE;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE;
import static net.minecraft.world.entity.ai.attributes.Attributes.*;

@EventBusSubscriber(modid = MODID)
public class GlobalAttributeModifier {
    private static final Map<ResourceLocation, Consumer<ItemAttributeModifierEvent>> modifiers = getModifiers();

    public static final Set<String> inventoryAttributeItems = Set.of("primogemcraft:qwjlbhy", "primogemcraft:qwtldhy", "primogemcraft:qwjzyj", "primogemcraft:chunmeizhipao");

    private static void init(Map<String, Consumer<ItemAttributeModifierEvent>> modifiers) {
        modifiers.put("primogemcraft:ljtg_02", e -> e.replaceModifier(ARMOR_TOUGHNESS, modifier("ljta", 1.5, ADD_VALUE), HAND));
        modifiers.put("primogemcraft:xzcfyxwzd", e -> e.replaceModifier(ARMOR_TOUGHNESS, modifier("ljtb", 2, ADD_VALUE), HAND));
        modifiers.put("primogemcraft:qwtldhy", e -> e.replaceModifier(MOVEMENT_SPEED, modifier("tldhy", 0.05, ADD_VALUE), ANY));
        modifiers.put("primogemcraft:qwjlbhy", e -> e.replaceModifier(MOVEMENT_SPEED, modifier("jlbhy", 0.02, ADD_VALUE), ANY));
        modifiers.put("primogemcraft:sanyuezhufu", e -> e.replaceModifier(FALL_DAMAGE_MULTIPLIER, modifier("sany", -100, ADD_MULTIPLIED_BASE), ANY));
        modifiers.put("primogemcraft:xinshoucq", e -> e.replaceModifier(ENTITY_INTERACTION_RANGE, modifier("cbwq", 1, ADD_VALUE), MAINHAND));
        modifiers.put("primogemcraft:heiyinq", e -> e.replaceModifier(ENTITY_INTERACTION_RANGE, modifier("hyq", 1.5, ADD_VALUE), MAINHAND));
        modifiers.put("primogemcraft:hmzz", e -> e.replaceModifier(ENTITY_INTERACTION_RANGE, modifier("hmzz", 3, ADD_VALUE), MAINHAND));
        modifiers.put("primogemcraft:xfcq", e -> e.replaceModifier(ENTITY_INTERACTION_RANGE, modifier("hmzz", 2, ADD_VALUE), MAINHAND));
        modifiers.put("primogemcraft:tczdg", e -> e.replaceModifier(ENTITY_INTERACTION_RANGE, modifier("hmzz", 3, ADD_VALUE), MAINHAND));
        modifiers.put("primogemcraft:jdzq", e -> e.replaceModifier(ENTITY_INTERACTION_RANGE, modifier("hmzz", 2, ADD_VALUE), MAINHAND));
        modifiers.put("primogemcraft:xldj", e -> e.replaceModifier(SWEEPING_DAMAGE_RATIO, modifier("hmzz", 1, ADD_VALUE), MAINHAND));
    }

    private static void custom(ItemAttributeModifierEvent event) {
    }

    private static AttributeModifier modifier(String id, double amount, AttributeModifier.Operation operation) {
        return new AttributeModifier(ResourceLocation.parse(id), amount, operation);
    }

    private static Map<ResourceLocation, Consumer<ItemAttributeModifierEvent>> getModifiers() {
        var modifiers = new HashMap<String, Consumer<ItemAttributeModifierEvent>>();
        init(modifiers);
        return modifiers.entrySet().stream().collect(ImmutableMap.toImmutableMap(e -> ResourceLocation.parse(e.getKey()), Map.Entry::getValue));
    }

    @SubscribeEvent
    static void onEvent(ItemAttributeModifierEvent event) {
        modifiers.getOrDefault(BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem()), GlobalAttributeModifier::custom).accept(event);
    }
}
