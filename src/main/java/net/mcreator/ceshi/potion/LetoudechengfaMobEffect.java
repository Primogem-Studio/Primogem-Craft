package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.procedures.ZLetouchengfahenshuxingProcedure;
import net.mcreator.ceshi.PrimogemcraftMod;

public class LetoudechengfaMobEffect extends MobEffect {
	public LetoudechengfaMobEffect() {
		super(MobEffectCategory.NEUTRAL, -39169);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "effect.letoudechengfa_0"), -100, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		ZLetouchengfahenshuxingProcedure.execute();
		return super.applyEffectTick(entity, amplifier);
	}
}