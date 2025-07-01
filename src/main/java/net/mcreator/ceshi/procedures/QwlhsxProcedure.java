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

public class QwlhsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack qwlh, String qwlh_tag) {
		if (entity == null || qwlh_tag == null)
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
			a = qwlh.getCount();
			qwlh.shrink((int) a);
			for (int index0 = 0; index0 < (int) a; index0++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse((qwlh_tag).toLowerCase(java.util.Locale.ENGLISH))))
							.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else {
			qwlh.shrink(1);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse((qwlh_tag).toLowerCase(java.util.Locale.ENGLISH))))
						.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
				entityToSpawn.setPickUpDelay(0);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}