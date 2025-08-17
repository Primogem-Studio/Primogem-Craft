package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class GUIhldztan0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		double b = 0;
		boolean lg0 = false;
		i1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
		if (!(i1.getItem() == Blocks.AIR.asItem()) && i1.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi")))) {
			for (int index0 = 0; index0 < 4; index0++) {
				b = b + 1;
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get((int) b).getItem() : ItemStack.EMPTY)
						.getItem() == PrimogemcraftModItems.TEZHIDIEYINGQI.get()) {
					if (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") < 4) {
						{
							final String _tagName = "jing_lian";
							final double _tagValue = (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") + 1);
							CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get((int) b).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
						lg0 = true;
					}
				}
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
					{
						final String _tagName = "jing_lian_shua_xin";
						final boolean _tagValue = false;
						CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putBoolean(_tagName, _tagValue));
					}
					JlqhewaiProcedure.execute(entity, i1);
				}
			}
		}
	}
}