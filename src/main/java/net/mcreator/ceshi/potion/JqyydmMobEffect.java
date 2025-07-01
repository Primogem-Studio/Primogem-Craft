package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.PrimogemcraftMod;

public class JqyydmMobEffect extends MobEffect {
	public JqyydmMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jqyydm_0"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jqyydm_1"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jqyydm_2"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jqyydm_3"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jqyydm_4"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jqyydm_5"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}