package net.mcreator.ceshi.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class QywuqimsleiProcedure {
    private static class Type {
        public TagKey<Item> tag;
        public String desc;

        public Type(String tag, String desc) {
            this.tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", tag));
            this.desc = desc;
        }
    }

    private static final List<Type> types = List.of(
            new Type("wuqi/danshou", "§e单手剑"),
            new Type("wuqi/changbing", "§e长柄武器"),
            new Type("wuqi/shuangshou", "§e双手剑"),
            new Type("wuqi", "§e其他特殊装备")
    );

    public static String execute(ItemStack itemstack) {
        for (var t : types) {
            if (itemstack.is(t.tag)) return t.desc;
        }
        return "";
    }
}