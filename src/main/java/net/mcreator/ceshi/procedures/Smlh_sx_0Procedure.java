package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
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
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class Smlh_sx_0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			{
				final String _tagName = "lihe_jishi";
				final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lihe_jishi") + 1);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lihe_jishi") >= 20) {
				{
					final String _tagName = "lihe_jishi";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "lihe_jishi_0";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lihe_jishi_0") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lihe_jishi_0") == 61) {
					if (Math.random() < 0.5) {
						for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY() + 0.8), (entity.getZ()), new ItemStack(
										(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("pgc:lihe_0"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
								entityToSpawn.setPickUpDelay(0);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY() + 0.8), (entity.getZ()), new ItemStack(
									(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("pgc:lihe_1"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					itemstack.shrink(1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.glow_item_frame.break")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.glow_item_frame.break")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5, false);
						}
					}
				}
			}
		}
	}
}