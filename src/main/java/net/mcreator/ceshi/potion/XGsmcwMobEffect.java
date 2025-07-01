package net.mcreator.ceshi.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.procedures.XGsmcwsxProcedure;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.Set;

public class XGsmcwMobEffect extends MobEffect {
	public XGsmcwMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10092544);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.x_gsmcw_0"), -2, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		XGsmcwsxProcedure.execute();
	}
}