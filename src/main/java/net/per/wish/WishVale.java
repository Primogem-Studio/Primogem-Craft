package net.per.wish;

import net.hackermdch.pgc.CustomAPI;
import net.hackermdch.pgc.CustomBar;
import net.hackermdch.pgc.CustomComponents;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WishVale {
    private final ItemStack stack;
    private final CustomBar bar;
    private final DataComponentType<Integer> wishvale;

    public WishVale(ItemStack stack) {
        this.stack = stack;
        this.bar = CustomAPI.getCustomBar(stack);
        this.wishvale = CustomComponents.WISH_VALE;
    }

    public boolean set(ItemStack item, int itemCount) {
        if (item == null || item.getItem() == Blocks.AIR.asItem() || bar.numerator >= bar.denominator) return false;
        boolean a = (bar.numerator + itemCount) > bar.denominator;
        int actualConsume = a ? bar.denominator - bar.numerator : itemCount;
        int singleSacrificeValue = getItemWishVale(item);
        int wishValueIncrement = (singleSacrificeValue * actualConsume) / stack.getCount();
        item.shrink(actualConsume);
        bar.numerator = a ? bar.denominator : bar.numerator + itemCount;
        int currentWishValue = stack.getOrDefault(wishvale, 0);
        int newWishValue = currentWishValue + wishValueIncrement;
        stack.set(wishvale, newWishValue);
        return true;
    }

    public boolean set(ItemStack item) {
        return set(item,item.getCount());
    }

    public boolean set(int vale) {
        stack.set(wishvale, vale);
        return true;
    }

    private static final Map<Item, Integer> DIRECT_ITEM_VALUES = new HashMap<>();
    private static final Map<TagKey<Item>, Integer> TAG_VALUES = new LinkedHashMap<>();
    private static final Map<String, TagKey<Item>> TAG_CACHE = new HashMap<>();

    static {
        DIRECT_ITEM_VALUES.put(Blocks.COMMAND_BLOCK.asItem(), 1000);

        registerTagValue("pgc:qysz_10", 10);
        registerTagValue("pgc:qysz_7", 7);
        registerTagValue("pgc:qysz_5", 5);
        registerTagValue("pgc:qysz_3", 3);
        registerTagValue("minecraft:beacon_payment_items", 4);
        registerTagValue("minecraft:trim_materials", 2);
        registerTagValue("minecraft:trimmable_armor", 6);
        registerTagValue("minecraft:breaks_decorated_pots", 4);
        registerTagValue("c:storage_blocks", 6);
    }

    public static void registerDirectItemValue(Item item, int value) {
        DIRECT_ITEM_VALUES.put(item, value);
    }

    public static void registerTagValue(String tagName, int value) {
        TagKey<Item> tag = TAG_CACHE.computeIfAbsent(tagName,
                key -> ItemTags.create(ResourceLocation.parse(key)));
        TAG_VALUES.put(tag, value);
    }

    public static int getItemWishVale(ItemStack item) {
        if (item.isEmpty()) return 1;

        Item itemType = item.getItem();

        Integer directValue = DIRECT_ITEM_VALUES.get(itemType);
        if (directValue != null) return directValue;

        for (Map.Entry<TagKey<Item>, Integer> entry : TAG_VALUES.entrySet()) {
            if (item.is(entry.getKey())) {
                return entry.getValue();
            }
        }

        return 1;
    }
}