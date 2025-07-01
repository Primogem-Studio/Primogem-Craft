package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.PrimogemcraftMod;

public class TkzrsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double a = 0;
		double b = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("tkzr_sx");
		if (a == 1) {
			b = 0;
			XsfhsyidongProcedure.execute(itemstack, false, true, b);
			XsfhsgjsuduProcedure.execute(itemstack, false, true, b);
			{
				final String _tagName = "tkzr_sx";
				final double _tagValue = 0;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.PLAYERS, (float) 1.5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.PLAYERS, (float) 1.5, 1, false);
					}
				}
			}
		} else if (a > 0) {
			PrimogemcraftMod.queueServerWork(10, () -> {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC), sourceentity),
						(float) ((sourceentity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity6.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0)
								* (0.14 + 0.035 * HSjinglianupProcedure.execute(sourceentity, itemstack))));
			});
			{
				final String _tagName = "tkzr_sx";
				final double _tagValue = (a - 1);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}