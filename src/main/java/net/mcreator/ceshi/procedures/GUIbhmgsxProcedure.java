package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class GUIbhmgsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double n1 = 0;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			i1 = new ItemStack(PrimogemcraftModItems.XINGHUI.get());
			i1.setCount(Mth.nextInt(RandomSource.create(), 10, 20));
			if (!GUIbhmgsxhs1Procedure.execute(entity)) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(Mth.nextInt(RandomSource.create(), 0, 2)).getItem() : ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, i1);
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
				n1 = 0;
				GUIqingchu012Procedure.execute(entity);
			} else if (!entity.getPersistentData().getBoolean("truea")) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, i1);
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:dashengchujin")), SoundSource.NEUTRAL, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:dashengchujin")), SoundSource.NEUTRAL, 2, 1, false);
				}
			}
		}
	}
}