package net.ai;

import net.hackermdch.genshincraft.element.Element;
import net.hackermdch.genshincraft.misc.Helper;
import net.hackermdch.pgc.CustomComponents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

final class LivingItemGenshin {
	private LivingItemGenshin() {
	}

	static DamageSource elementSource(ItemStack stack, DamageSource source, LivingEntity target) {
		Integer type = stack.get(CustomComponents.ELEMENT_TYPE);
		Element.Type t = type != null && type > 0 && type < Element.Type.values().length ? Element.Type.values()[type] : Element.Type.Null;
		return Helper.getSpecialDamage(stack, source, target, t);
	}
}
