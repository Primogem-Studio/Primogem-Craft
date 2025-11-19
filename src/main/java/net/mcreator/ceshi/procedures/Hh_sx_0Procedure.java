package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ceshi.init.PrimogemcraftModBlocks;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.Comparator;

public class Hh_sx_0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double n1 = 0;
		double n2 = 0;
		if (!world.isClientSide()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("daojishi", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "daojishi") + 1));
					_blockEntity.getPersistentData().putDouble("daojishi2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "daojishi2") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			n1 = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "daojishi");
			n2 = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "daojishi2");
			if (n1 >= 600) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:hh_boo")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:hh_boo")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				PrimogemcraftMod.queueServerWork(40, () -> {
					if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR)) {
						if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "hh_baozha")) {
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, y, z, 42, Level.ExplosionInteraction.TNT);
						} else {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1, false);
								}
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof ItemEntity && (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:fumoyuzhezn")))) != 0) {
										EnchantmentHelper.updateEnchantments((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), mutableEnchantments -> mutableEnchantments.removeIf(
												enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:fumoyuzhezn"))))));
									}
								}
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon minecraft:firework_rocket ~3 ~1 ~ {CustomName:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",FireworksItem:{tag:{Fireworks:{Flight:40,Explosions:[{Flicker:1b,Type:1,Colors:[I;15882071],FadeColors:[I;3438841]},{Flicker:1b,Type:2,Colors:[I;16773394],FadeColors:[I;5701425]}]}},id:\"minecraft:firework_rocket\",Count:1},Life:40,LifeTime:60}");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon minecraft:firework_rocket ~ ~1 ~5 {CustomName:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",FireworksItem:{tag:{Fireworks:{Flight:20,Explosions:[{Trail:1b,Flicker:1b,Type:4,Colors:[I;14873175],FadeColors:[I;3471673]},{Flicker:1b,Type:2,Colors:[I;16730642],FadeColors:[I;16009471]}]}},id:\"minecraft:firework_rocket\",Count:1},Life:30,LifeTime:50}");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon minecraft:firework_rocket ~-4 ~1 ~ {CustomName:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",FireworksItem:{tag:{Fireworks:{Flight:20,Explosions:[{Trail:1b,Type:1,Colors:[I;15095794],FadeColors:[I;16331918]},{Flicker:1b,Type:3,Colors:[I;2757375],FadeColors:[I;4784112]}]}},id:\"minecraft:firework_rocket\",Count:1},Life:30,LifeTime:50}");
						}
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					}
				});
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PrimogemcraftModBlocks.HHZDBOO.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata(world.registryAccess());
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.loadWithComponents(_bnbt, world.registryAccess());
							} catch (Exception ignored) {
							}
						}
					}
				}
			} else {
				if (n1 < 400 && n2 >= 16) {
					HuahuohsProcedure.execute(world, x, y, z, PrimogemcraftModBlocks.HHZD_1.get().defaultBlockState(), n1);
				} else if (n1 > 400 && n1 < 560 && n2 >= 8) {
					HuahuohsProcedure.execute(world, x, y, z, PrimogemcraftModBlocks.HHZD_1.get().defaultBlockState(), n1);
				} else if (n1 > 560 && n2 >= 4) {
					HuahuohsProcedure.execute(world, x, y, z, PrimogemcraftModBlocks.HHZD_1.get().defaultBlockState(), n1);
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}