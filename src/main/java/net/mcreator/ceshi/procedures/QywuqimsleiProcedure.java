package net.mcreator.ceshi.procedures;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

public class QywuqimsleiProcedure {
    private static class Type {
        public TagKey<Item> tag;
        public String desc;

        public Type(String tag, String desc) {
            this.tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MODID, tag));
            this.desc = desc;
        }
    }

    private static final List<Type> types = List.of(
			new Type("pgc:wuqi/danshou", "§e单手剑"),
			new Type("pgc:wuqi/changbing", "§e长柄武器"),
			new Type("pgc:wuqi/shuangshou", "§e双手剑")
	);

    public static String execute(ItemStack itemstack) {
        for (var t : types) {
            if (itemstack.is(t.tag)) return t.desc;
        }
        return "";
    }
}