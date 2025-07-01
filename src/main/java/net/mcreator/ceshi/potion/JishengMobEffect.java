package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.procedures.XgjssxProcedure;
import net.mcreator.ceshi.PrimogemcraftMod;

public class JishengMobEffect extends MobEffect {
	public JishengMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -4756225);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.jisheng_0"), 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		XgjssxProcedure.execute();
	}
}