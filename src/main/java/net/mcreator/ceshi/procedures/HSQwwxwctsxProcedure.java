package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

public class HSQwwxwctsxProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item0, ItemStack itemstack, boolean bao_zang, boolean dan_ci, boolean tong_zhi, boolean xiao_hui, boolean yi_fumo, double dengji,
			double zui_da, String itemx, String xianzhi_cishu) {
		if (entity == null || itemx == null || xianzhi_cishu == null)
			return false;
		if ((yi_fumo ? item0.isEnchanted() : !item0.isEnchanted() && item0.isEnchantable())
				&& (!item0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean(xianzhi_cishu) || item0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(xianzhi_cishu) < zui_da)) {
			item0.applyComponents((EnchantmentHelper.enchantItem(world.getRandom(), (item0.copy()), (int) dengji,
					(bao_zang)
							? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
							: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
					.getComponents());
			if (dan_ci) {
				{
					final String _tagName = xianzhi_cishu;
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, item0, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			} else {
				{
					final String _tagName = xianzhi_cishu;
					final double _tagValue = (item0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(xianzhi_cishu) + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, item0, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 5, 1, false);
				}
			}
			if (xiao_hui) {
				itemstack.shrink(1);
				if (tong_zhi) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((itemx + "\u00A7c\u5DF2\u6D88\u8017")), false);
				}
			} else {
				if (itemstack.getDamageValue() == itemstack.getMaxDamage() - 1) {
					itemstack.shrink(1);
					if (tong_zhi) {
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((itemx + "\u00A7c\u5DF2\u6D88\u8017")), false);
					}
				} else {
					if (world instanceof ServerLevel _level) {
						itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				}
			}
			return true;
		} else {
			if (tong_zhi) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							(item0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean(xianzhi_cishu) || item0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(xianzhi_cishu) >= zui_da
									? "\u00A7c\u00A7l\u8BE5\u88C5\u5907\u5DF2\u65E0\u6CD5\u7EE7\u7EED\u4F7F\u7528\u8BE5\u5947\u7269"
									: "\u00A75\u63D0\u4F9B\u7684\u7269\u54C1\u65E0\u6548")),
							false);
			}
		}
		return false;
	}
}