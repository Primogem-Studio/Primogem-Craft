package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class Jianmuhs2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack item, double zhi) {
		if (item.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:ceshifumo_01")))) != 0) {
			JianmufuzhuoHSProcedure.execute(world, x, y, z, item, zhi);
		}
	}
}