package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class JianmufuzhuoHSProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack item, double zhi) {
		ItemStack i1 = ItemStack.EMPTY;
		double n1 = 0;
		double n2 = 0;
		i1 = item;
		n1 = i1.getDamageValue();
		n2 = i1.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:ceshifumo_01"))));
		if (n1 > i1.getMaxDamage() - zhi) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			i1.setDamageValue((int) (n1 - n1 * n2 * 0.2));
			EnchantmentHelper.updateEnchantments(i1, mutableEnchantments -> mutableEnchantments
					.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:ceshifumo_01"))))));
			if (n2 > 1) {
				i1.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:ceshifumo_01"))), (int) (n2 - 1));
			}
		}
	}
}