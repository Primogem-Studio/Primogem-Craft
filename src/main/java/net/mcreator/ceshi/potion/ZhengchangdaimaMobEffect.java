package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.PrimogemcraftMod;

public class ZhengchangdaimaMobEffect extends MobEffect {
	public ZhengchangdaimaMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
		this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.zhengchangdaima_0"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}