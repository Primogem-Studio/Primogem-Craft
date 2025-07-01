package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class DijiansxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity, ItemStack itemstack) {
		if (sourceentity == null)
			return;
		double a = 0;
		double b = 0;
		boolean i1 = false;
		if (!world.isClientSide()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("yin_fu") > 4) {
				b = (1 + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") * 0.25)
						* (sourceentity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity5.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0);
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator == sourceentity) && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 1) {
							if (a <= 5) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC), entityiterator, sourceentity), (float) b);
							}
							a = a + 1;
							{
								final String _tagName = "yin_fu";
								final double _tagValue = 0;
								CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
							}
							i1 = true;
						}
					}
				}
				if (i1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:djpp02")), SoundSource.PLAYERS, 2, (float) 0.3);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:djpp02")), SoundSource.PLAYERS, 2, (float) 0.3, false);
						}
					}
				}
			} else if (!(sourceentity instanceof Player _plrCldCheck15 && _plrCldCheck15.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				{
					final String _tagName = "yin_fu";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("yin_fu") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.flute")), SoundSource.PLAYERS, (float) 1.6,
								(float) Mth.nextDouble(RandomSource.create(), 0.3, 5));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.flute")), SoundSource.PLAYERS, (float) 1.6, (float) Mth.nextDouble(RandomSource.create(), 0.3, 5), false);
					}
				}
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
			}
		}
	}
}