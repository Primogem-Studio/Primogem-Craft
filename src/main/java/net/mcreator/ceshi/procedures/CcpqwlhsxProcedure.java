package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class CcpqwlhsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pig.saddle")), SoundSource.PLAYERS, (float) 0.3, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1));
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pig.saddle")), SoundSource.PLAYERS, (float) 0.3, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1), false);
			}
		}
		if (entity.isShiftKeyDown()) {
			a = itemstack.getCount();
			itemstack.shrink((int) a);
			for (int index0 = 0; index0 < (int) a; index0++) {
				if (Math.random() < 0.5) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (Math.random() < 0.25 ? new ItemStack(PrimogemcraftModItems.QWTHHJIII.get()) : new ItemStack(PrimogemcraftModItems.QWTHHJ.get())));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(
								(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:curio/normal/b"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		} else {
			itemstack.shrink(1);
			if (Math.random() < 0.5) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (Math.random() < 0.25 ? new ItemStack(PrimogemcraftModItems.QWTHHJIII.get()) : new ItemStack(PrimogemcraftModItems.QWTHHJ.get())));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(
							(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("c:curio/normal/b"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}