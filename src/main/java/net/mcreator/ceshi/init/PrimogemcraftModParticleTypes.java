/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.ceshi.PrimogemcraftMod;

public class PrimogemcraftModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, PrimogemcraftMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MOYIN = REGISTRY.register("moyin", () -> new SimpleParticleType(true));
}