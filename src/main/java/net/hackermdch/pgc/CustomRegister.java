package net.hackermdch.pgc;

import net.hackermdch.pgc.network.WishInfoConfiguration;
import net.hackermdch.pgc.tacz.TaczEventHandler;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

public class CustomRegister {
    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITION_TYPES = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, MODID);
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, MODID);
    public static final Supplier<LootItemConditionType> IS_CHEST = LOOT_CONDITION_TYPES.register("is_chest", () -> new LootItemConditionType(IsChestCondition.CODEC));
    public static final Supplier<RecipeType<StardustConverterRecipe>> STARDUST_CONVERTER = RECIPE_TYPES.register("stardust_converter", () -> new RecipeType<>() {
        public String toString() {
            return String.format("%s:%s", MODID, "stardust_converter");
        }
    });

    static {
        DATA_COMPONENT_TYPES.register("custom_bar", () -> CustomComponents.CUSTOM_BAR);
        DATA_COMPONENT_TYPES.register("element_type", () -> CustomComponents.ELEMENT_TYPE);
        DATA_COMPONENT_TYPES.register("yszujian_jian", () -> CustomComponents.YSZUJIAN_JIAN);
        ShapedWithComponentsRecipe.register();
        MaterialRecoveryRecipe.register();
        StardustConverterRecipe.register();
        WishInfoConfiguration.addRare(ResourceLocation.fromNamespaceAndPath(MODID, "qq_qqylan"));
        WishInfoConfiguration.addSuperRare(ResourceLocation.fromNamespaceAndPath(MODID, "q_qqyzi"));
        WishInfoConfiguration.addSuperSuperRare(ResourceLocation.fromNamespaceAndPath(MODID, "qqyjin"));
    }

    public static void register(IEventBus modBus) {
        LOOT_CONDITION_TYPES.register(modBus);
        DATA_COMPONENT_TYPES.register(modBus);
        RECIPE_TYPES.register(modBus);
        RECIPE_SERIALIZERS.register(modBus);
        if (ModList.get().isLoaded("tacz")) TaczEventHandler.register();
    }
}
