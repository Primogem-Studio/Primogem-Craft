package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Xyzp_sx_0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("dai_kai_jiang")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PrimogemcraftModItems.XINGQIONG.get()).copy();
				_setstack.setCount(10);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			itemstack.shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:dashengchulan01")), SoundSource.PLAYERS, (float) 0.3, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:dashengchulan01")), SoundSource.PLAYERS, (float) 0.3, 1, false);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7e\u4F60\u9009\u62E9\u7A33\u8D5A10\u661F\u7A79\uFF01\u65E0\u9700\u7B49\u5F85\uFF01"), true);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u53C2\u4E0E\u540E\u4E0D\u80FD\u53CD\u6094\u54E6~"), false);
		}
	}
}