package net.mcreator.ceshi.item;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class Hpy extends MaceItem {
    private static final Tier TOOL_TIER = new Tier() {
        @Override
        public int getUses() {
            return 3000;
        }

        @Override
        public float getSpeed() {
            return 4f;
        }

        @Override
        public float getAttackDamageBonus() {
            return 0;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 20;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack(PrimogemcraftModItems.JLLIANG.get()));
        }
    };
    public Hpy() {
        super(new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 9f, -2f)).fireResistant());
    }
}
