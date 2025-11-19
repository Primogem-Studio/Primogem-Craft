/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.ceshi.PrimogemcraftMod;

@EventBusSubscriber
public class PrimogemcraftModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, PrimogemcraftMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> LQSJP = REGISTRY.register("lqsjp", () -> new RangedAttribute("attribute.primogemcraft.lqsjp", -20, -10240, 10240).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> EWAI_SHANGHAI_MF = REGISTRY.register("ewai_shanghai_mf", () -> new RangedAttribute("attribute.primogemcraft.ewai_shanghai_mf", 0, 0, 10240).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, LQSJP);
		event.add(EntityType.PLAYER, EWAI_SHANGHAI_MF);
	}
}