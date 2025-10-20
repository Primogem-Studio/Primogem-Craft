package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.procedures.Cxbd_sxProcedure;
import net.mcreator.ceshi.PrimogemcraftMod;

public class CxbdMobEffect extends MobEffect {
	public CxbdMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10027009);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.cxbd_0"), -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Cxbd_sxProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}