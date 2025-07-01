package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class JingyanshutongyongsuijijingyanjiangliProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean((entity.getDisplayName().getString()))) {
			DiaoyonghuishouProcedure.execute(entity, itemstack);
			if (itemstack.getItem() == PrimogemcraftModItems.JIANGLILIULANGZHEJINGYAN.get()) {
				if (Math.random() <= 0.5) {
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(Mth.nextInt(RandomSource.create(), 100, 550));
				} else {
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(Mth.nextInt(RandomSource.create(), 70, 200));
				}
			}
			if (itemstack.getItem() == PrimogemcraftModItems.JIANGLIMAOXIANJIAJINGYAN.get()) {
				if (Math.random() <= 0.5) {
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(Mth.nextInt(RandomSource.create(), 300, 1090));
				} else {
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(Mth.nextInt(RandomSource.create(), 100, 600));
				}
			}
			if (itemstack.getItem() == PrimogemcraftModItems.JIANGLIDAYINXIONGJINGYAN.get()) {
				if (Math.random() <= 0.5) {
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(Mth.nextInt(RandomSource.create(), 500, 1398));
				} else {
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(Mth.nextInt(RandomSource.create(), 200, 800));
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.NEUTRAL, (float) 0.5, Mth.nextInt(RandomSource.create(), 1, (int) 1.2));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.NEUTRAL, (float) 0.5, Mth.nextInt(RandomSource.create(), 1, (int) 1.2), false);
				}
			}
			{
				final String _tagName = (entity.getDisplayName().getString());
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
	}
}