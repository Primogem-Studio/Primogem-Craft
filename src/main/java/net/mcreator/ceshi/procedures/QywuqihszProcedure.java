package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.CustomAPI;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class QywuqihszProcedure {
    private static class WQType {
        private final TagKey<Item> tag;
        private final double cheng;
        private final Holder<Attribute> z;


        public WQType(String tag, double cheng, Holder<Attribute> z) {
            this.tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", tag));
            this.cheng = cheng;
            this.z = z;
        }

        public boolean ss(ItemStack stack, double c) {
            if (stack.is(tag)) {
                var attr = CustomAPI.getAttributes(stack);
                attr.add(z, "djjc", c * cheng, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
                attr.apply();
                return true;
            }
            return false;
        }
    }

    private static final List<WQType> types = List.of(
            new WQType("wuqi/danshou", 1f, Attributes.ATTACK_DAMAGE),
            new WQType("wuqi/changbing", 1.3f, Attributes.ATTACK_DAMAGE),
            new WQType("wuqi/gongju", 0.7f, Attributes.MINING_EFFICIENCY),
            new WQType("wuqi/shuangshou", 2f, Attributes.ATTACK_DAMAGE),
            new WQType("wuqi", 1, Attributes.ATTACK_DAMAGE)
    );

    public static boolean execute(ItemStack itemstack, double c) {
        for (var t : types) {
            if (t.ss(itemstack, c)) return true;
        }
        return false;
    }
}
