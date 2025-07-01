package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

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

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Ydggz_sx_1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (itemstack.getDamageValue() != 0 && !world.isClientSide()) {
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (itemstackiterator.getItem() == PrimogemcraftModItems.GUZHONGLINGJIAN.get()) {
						a = a + itemstackiterator.getCount();
					}
				}
			}
			if (a >= itemstack.getDamageValue()) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.GUZHONGLINGJIAN.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getDamageValue(), _player.inventoryMenu.getCraftSlots());
				}
				itemstack.setDamageValue(0);
				entity.getPersistentData().putBoolean("yongdongguguzhong", false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76\u6C38\u52A8\u5495\u5495\u949F\u5DF2\u505C\u6B62\u8FD0\u4F5C......"), false);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.YYDGGZXG);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.PLAYERS, (float) 0.2, (float) 1.4);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.PLAYERS, (float) 0.2, (float) 1.4, false);
					}
				}
			} else {
				if (a > 0) {
					itemstack.setDamageValue((int) (itemstack.getMaxDamage() - (a + itemstack.getMaxDamage() - itemstack.getDamageValue())));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.GUZHONGLINGJIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) a, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.PLAYERS, (float) 0.2, (float) 1.4);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.PLAYERS, (float) 0.2, (float) 1.4, false);
						}
					}
				}
			}
			DiaoyonghuishouProcedure.execute(entity, itemstack);
		}
	}
}