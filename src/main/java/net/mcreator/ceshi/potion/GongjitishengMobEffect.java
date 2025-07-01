package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.PrimogemcraftMod;

public class GongjitishengMobEffect extends MobEffect {
	public GongjitishengMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1266889);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.gongjitisheng_0"), 0.01, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}
}