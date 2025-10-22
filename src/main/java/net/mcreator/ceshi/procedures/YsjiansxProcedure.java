package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import net.hackermdch.pgc.CustomComponents;

public class YsjiansxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double a = 0;
		double Lq = 0;
		double Gl = 0;
		if (!world.isClientSide()) {
			switch (itemstack.getOrDefault(CustomComponents.YSZUJIAN_JIAN, 0)) {
				case 1 -> {
					if (Math.random() < YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQFENG.get()), itemstack, true, 0.2)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQFENG.get()), itemstack, true, 4), 20, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_2")), SoundSource.PLAYERS, (float) 0.5,
										(float) Mth.nextDouble(RandomSource.create(), 1.5, 3));
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_2")), SoundSource.PLAYERS, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 1.5, 3), false);
							}
						}
					}
				}
				case 2 -> {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQYAN.get()), itemstack, true, 60),
								(int) (PrimogemcraftModVariables.genshincraft
										? YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQYAN.get()), itemstack, true, 5)
										: YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQYAN.get()), itemstack, true, 0.5)),
								false, false));
				}
				case 3 -> {
					if (!(sourceentity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(PrimogemcraftModMobEffects.GOUYU))) {
						if (Math.random() < YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQLEI.get()), itemstack, true, 0.1)) {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));;
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
				case 4 -> {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.POISON,
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.POISON) ? _livEnt.getEffect(MobEffects.POISON).getDuration() : 0)
										+ YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQCAO.get()), itemstack, true, 100)),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getAmplifier() : 0) - 1
										+ YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQCAO.get()), itemstack, true, 2))));
				}
				case 5 -> {
					if (Math.random() < YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQSHUI.get()), itemstack, true, 0.1)) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJPP, (int) YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQSHUI.get()), itemstack, true, 200),
									(int) YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQSHUI.get()), itemstack, true, 1)));
					}
				}
				case 6 -> {
					if (Math.random() < YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQHUO.get()), itemstack, true, 0.1)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.ZHUOSHAO, (int) YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQHUO.get()), itemstack, true, 400),
									(int) YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQHUO.get()), itemstack, true, 1)));
					}
				}
				case 7 -> {
					if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))
							&& Math.random() <= YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQBING.get()), itemstack, true, 0.2)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQBING.get()), itemstack, true, 200),
									(int) YsjianzhihsProcedure.execute(sourceentity, new ItemStack(PrimogemcraftModItems.HQBING.get()), itemstack, true, 1)));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.hit")), SoundSource.PLAYERS, (float) 0.5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.hit")), SoundSource.PLAYERS, (float) 0.5, 1, false);
							}
						}
					}
				}
				default -> MoladlhsProcedure.execute(world, x, y, z, sourceentity, itemstack);
			}
		}
	}
}