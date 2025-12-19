package net.mcreator.ceshi.procedures;

import net.per.wish.WishVale;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.hackermdch.pgc.CustomAPI;

public class Qyhxsx0Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean o1 = false;
		ItemStack i = ItemStack.EMPTY;
		ItemStack item = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			i = itemstack;
			item = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			var wish = new WishVale(i);
			o1 = entity.isShiftKeyDown() ? wish.set(item) : wish.set(item, 1);
			if (o1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.PLAYERS, (float) 0.5,
								(float) (CustomAPI.getCustomBar(i).numerator * 0.05));
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7c\u526F\u624B\u7269\u54C1\u65E0\u6548\u6216\u5DF2\u8FBE\u6700\u5927\uFF01\uFF01"), false);
			}
		}
	}
}