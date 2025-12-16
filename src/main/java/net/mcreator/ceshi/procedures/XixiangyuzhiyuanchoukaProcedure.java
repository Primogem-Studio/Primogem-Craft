package net.mcreator.ceshi.procedures;

import net.per.wish.SpawnWishiEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class XixiangyuzhiyuanchoukaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double in = 0;
		if (!world.isClientSide()) {
			in = entity.isShiftKeyDown() ? itemstack.getCount() : 1;
			new SpawnWishiEntity.Spawn(world, entity, (int) in, 0, false).Spawn();
			itemstack.shrink((int) in);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:choukaqianxi01")), SoundSource.HOSTILE, 4, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:choukaqianxi01")), SoundSource.HOSTILE, 4, 1, false);
				}
			}
		}
	}
}