package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.PrimogemcraftMod;

public class XllysxProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double a = 0;
		if (!world.isClientSide()) {
			a = HSjinglianupProcedure.execute(sourceentity, itemstack);
			if (entity.getRemainingFireTicks() > 0) {
				if (!(sourceentity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown(itemstack.getItem()))) {
					PrimogemcraftMod.queueServerWork(10, () -> {
						entity.hurt(
								FullToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("primogemcraft:s_hchixushanghai"))), sourceentity), true, false, true, false,
										1, 1),
								(float) ((sourceentity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity4.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0)
										* (0.18 + 0.045 * itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian"))));
						if (sourceentity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
					});
				}
			} else {
				if (Math.random() < 0.3 + 0.1 * a + 0.05 * itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fu_mo")) {
					entity.igniteForSeconds((int) (8 + 2 * a));
				}
			}
		}
	}
}