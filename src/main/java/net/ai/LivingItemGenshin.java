package net.ai;

import net.hackermdch.genshincraft.element.Element;
import net.hackermdch.genshincraft.misc.Helper;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

final class LivingItemGenshin {
    private LivingItemGenshin() {
    }

    static DamageSource elementSource(ItemStack stack, DamageSource source, LivingEntity target) {
        return Helper.getSpecialDamage(stack, source, target, Element.Type.Null);
    }
}
