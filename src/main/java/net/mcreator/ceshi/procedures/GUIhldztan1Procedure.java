package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class GUIhldztan1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		boolean lg0 = false;
		double a = 0;
		double b = 0;
		double c = 0;
		if (!world.isClientSide()) {
			i1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(5).getItem() : ItemStack.EMPTY).copy();
			if (Math.random() < i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("qianghua_touzi_gailv")) {
				b = 0.01;
				c = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("touzi_fenwei_1");
				if (world instanceof ServerLevel _level) {
					i1.hurtAndBreak(Mth.nextInt(RandomSource.create(), 1, 3), _level, null, _stkprov -> {
					});
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7a\u00A7l\u89E6\u53D1\u547D\u8FD0\u8DB3\u8FF9\uFF01\u5C06\u968F\u673A\u51CF\u5C11\u77FF\u77F3\u6D88\u8017\uFF01"), false);
			}
		}
		i1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
		WuqishuaxinProcedure.execute(world, entity, i1);
		if (!(i1.getItem() == Blocks.AIR.asItem()) && i1.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi")))) {
			a = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			if (a < 29 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.JLZA.get()) {
				lg0 = GUIhldztan1SHProcedure.execute(world, entity, i1, 29, b, c, 6);
			}
			a = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			if (a >= 29 && a < 59
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.JLLIANG.get()) {
				lg0 = GUIhldztan1SHProcedure.execute(world, entity, i1, 59, b, c, 7);
			}
			a = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			if (a >= 59
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.JLMO.get()) {
				lg0 = GUIhldztan1SHProcedure.execute(world, entity, i1, (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGXIAN)), b, c, 8);
			}
			if (!world.isClientSide()) {
				if (lg0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			}
		}
	}
}