package net.mcreator.ceshi;

import com.google.common.collect.ImmutableList;
import net.hackermdch.pgc.CustomBar;
import net.hackermdch.pgc.CustomBarRender;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.client.IItemDecorator;

import java.util.List;

public class CustomBarRegister {
    private static void init(Builder builder) {
        builder.add(lookup("primogemcraft:example"), bar(13, 0xc145c3), bar(0, 100, true));
        builder.add(lookup("primogemcraft:dayingxiongdejingyan"), bar(13, 0x6A75EA), bar(0, 2920, true));
        builder.add(lookup("primogemcraft:maoxianjiadejingyan"), bar(13, 0x6A75EA), bar(0, 1395, true));
        builder.add(lookup("primogemcraft:liulangzhedejingyan"), bar(13, 0x6A75EA), bar(0, 1089, true));
        builder.add(lookup("primogemcraft:kongyuezhufu"), bar(13, 0xFEA01B), bar(30, 30, false));
        builder.add(lookup("primogemcraft:qyhx"), bar(13, 0xFECCFF), bar(0, 30, true));
        builder.add(lookup("primogemcraft:qyhxshilian"), bar(13, 0xFECCFF), bar(0, 300, true));
    }

    private static Item lookup(String id) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.parse(id));
    }

    private static CustomBarRender bar(int offset, int color) {
        return new CustomBarRender(offset, color);
    }

    private static CustomBar bar(int num, int den, boolean visible) {
        return new CustomBar(num, den, visible);
    }

    private static class Builder {
        private final ImmutableList.Builder<Entry> builder = ImmutableList.builder();

        private List<Entry> build() {
            init(this);
            return builder.build();
        }

        private void add(ItemLike item, IItemDecorator decorator, CustomBar component) {
            builder.add(new Entry(item, decorator, component));
        }
    }

    public record Entry(ItemLike item, IItemDecorator decorator, CustomBar component) {
    }

    public static final List<Entry> registers = new Builder().build();
}
