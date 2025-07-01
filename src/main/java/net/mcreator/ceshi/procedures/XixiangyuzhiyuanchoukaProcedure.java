package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;

public class XixiangyuzhiyuanchoukaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			itemstack.shrink(1);
			entity.getPersistentData().putBoolean("xiangyu", true);
			entity.getPersistentData().putDouble("chouka", 1);
			new ItemStack(PrimogemcraftModItems.XIXIANGYUZHIYUAN.get()).shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:choukaqianxi01")), SoundSource.HOSTILE, 70, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:choukaqianxi01")), SoundSource.HOSTILE, 70, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}