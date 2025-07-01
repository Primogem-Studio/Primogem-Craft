package net.mcreator.ceshi.potion;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.PrimogemcraftMod;

public class Jdsbcf2xgMobEffect extends MobEffect {
	public Jdsbcf2xgMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jdsbcf_2xg_0"), -0.01, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jdsbcf_2xg_1"), -0.01, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.FLYING_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jdsbcf_2xg_2"), -0.01, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jdsbcf_2xg_3"), -0.01, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.SNEAKING_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jdsbcf_2xg_4"), -0.01, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.SUBMERGED_MINING_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jdsbcf_2xg_5"), -0.01, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jdsbcf_2xg_6"), -0.01, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}