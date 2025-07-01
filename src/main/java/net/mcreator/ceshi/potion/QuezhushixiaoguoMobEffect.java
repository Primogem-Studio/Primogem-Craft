package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.PrimogemcraftMod;

public class QuezhushixiaoguoMobEffect extends MobEffect {
	public QuezhushixiaoguoMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.quezhushixiaoguo_0"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}