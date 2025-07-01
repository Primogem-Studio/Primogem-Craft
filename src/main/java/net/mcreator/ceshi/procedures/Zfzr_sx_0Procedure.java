package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class Zfzr_sx_0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		double a = 0;
		double b = 0;
		if (!world.isClientSide()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zfzr_ceng_shu") >= 8) {
				{
					final String _tagName = "zfzr_ceng_shu";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				a = sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.ABSORPTION) ? _livEnt.getEffect(MobEffects.ABSORPTION).getAmplifier() : 0;
				b = sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.ABSORPTION) ? _livEnt.getEffect(MobEffects.ABSORPTION).getDuration() : 0;
				if (sourceentity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.ABSORPTION);
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, (int) (b <= 0 ? 600 : b), (int) (a <= 1 ? 0 : a)));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")), SoundSource.NEUTRAL, (float) 0.5, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")), SoundSource.NEUTRAL, (float) 0.5, (float) 0.5, false);
					}
				}
			} else if (Math.random() < 0.2 + HSjinglianupProcedure.execute(sourceentity, itemstack) * 0.05) {
				{
					final String _tagName = "zfzr_ceng_shu";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zfzr_ceng_shu") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.PLAYERS, 2, 5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.PLAYERS, 2, 5, false);
					}
				}
			}
		}
	}
}