package net.mcreator.ceshi.potion;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.neoforged.neoforge.common.NeoForgeMod;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FeixingMobEffect extends MobEffect {
	public FeixingMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		addAttributeModifier(NeoForgeMod.CREATIVE_FLIGHT, ResourceLocation.fromNamespaceAndPath(MODID, "fly"), 1, AttributeModifier.Operation.ADD_VALUE);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, PrimogemcraftModMobEffects.FEIXING.get());
	}
}