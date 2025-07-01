package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.PrimogemcraftMod;

public class DiguixiaoguoMobEffect extends MobEffect {
	public DiguixiaoguoMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.diguixiaoguo_0"), 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}