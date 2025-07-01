package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class FtyjsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		if (!world.isClientSide()) {
			if (!(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				a = HSjinglianupProcedure.execute(entity, itemstack);
				if (entity.isShiftKeyDown()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FEIXING, (int) (60 + 20 * a), 0, false, false));
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.bat.takeoff")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.bat.takeoff")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else {
					if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ftyj_sx") < 1) {
						b = 0.12 + 0.03 * a;
						XsfHSProcedure.execute(itemstack, true, false, b);
						XsfhsyidongProcedure.execute(itemstack, true, false, b);
						{
							final String _tagName = "ftyj_sx";
							final double _tagValue = 10;
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.PLAYERS, (float) 1.5, (float) 1.2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.PLAYERS, (float) 1.5, (float) 1.2, false);
							}
						}
					}
				}
			}
		}
	}
}