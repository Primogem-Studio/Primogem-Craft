package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class TcllksxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		ItemStack i1 = ItemStack.EMPTY;
		double a = 0;
		double b = 0;
		double a1 = 0;
		double a2 = 0;
		double c = 0;
		double bb = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + 1;
		b = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian_zhen") + (DiaoyongNBTluojiProcedure.execute(itemstack, "jing_lian_zhen") || JinglianmmkjProcedure.execute(itemstack) ? 1 : 0);
		bb = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian_jia") + (DiaoyongNBTluojiProcedure.execute(itemstack, "jing_lian_jia") ? 1 : 0);
		if (a > 1 || b > 0 || bb > 0 || itemstack.getItem() == PrimogemcraftModItems.TCLLK.get()) {
			if (itemstack.getItem() == PrimogemcraftModItems.TCLLK.get()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PrimogemcraftModItems.TCLZHAIQUAN.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fu_mo") > 0) {
				i1 = new ItemStack(Items.ENCHANTED_BOOK);
				i1.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), 2);
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, i1, Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fu_mo") / 2));
			}
			itemstack.shrink(1);
			DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.TEZHIDIEYINGQI.get()), b);
			DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.XINGHUI.get()), bb * 4);
			a1 = 30;
			a2 = 60;
			if (a > a2) {
				c = a - a2;
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLMO.get()), c);
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLLIANG.get()), 30);
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLZA.get()), 29);
			} else if (a >= a1 && a <= a2) {
				c = a - a1;
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLLIANG.get()), c);
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLZA.get()), 29);
			} else if (a < a1 && a > 1) {
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLZA.get()), a - 1);
			}
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.destroy")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.destroy")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		}
	}
}