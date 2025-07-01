package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class HsnjxfProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, ItemStack itemstack, boolean NBTi, boolean pan_ding, double beilv, double gai_lv, double sun_huai_gai_lv, String NBT, String TAG) {
		if (entity == null || NBT == null || TAG == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (pan_ding) {
				entity.getPersistentData().putBoolean(NBT, NBTi);
				if (Math.random() < gai_lv) {
					a = item;
					if (a.is(ItemTags.create(ResourceLocation.parse((TAG).toLowerCase(java.util.Locale.ENGLISH)))) && a.getDamageValue() >= 1) {
						a.setDamageValue((int) (a.getDamageValue() - (1 + beilv)));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((a.getDisplayName().getString() + "\u00A7a\u00A7l\u5DF2\u4FEE\u590D!")), false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						if (Math.random() < sun_huai_gai_lv) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal((itemstack.getDisplayName().getString() + "\u00A7c\u5DF2\u635F\u574F!")), false);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = itemstack;
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						}
					}
				}
			}
		}
	}
}