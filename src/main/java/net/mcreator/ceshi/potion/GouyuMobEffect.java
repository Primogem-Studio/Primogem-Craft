package net.mcreator.ceshi.potion;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.procedures.GouyukaishiProcedure;
import net.mcreator.ceshi.procedures.Gouyu_shuxingProcedure;
import net.mcreator.ceshi.PrimogemcraftMod;

public class GouyuMobEffect extends MobEffect {
	public GouyuMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1878800);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.gouyu_0"), 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.gouyu_1"), 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.gouyu_2"), 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.gouyu_3"), 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GouyukaishiProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Gouyu_shuxingProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}