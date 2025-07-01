package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class QwsksjsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double n1 = 0;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			i1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			n1 = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
			if (i1.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi"))) && n1 <= 4) {
				if (Math.random() < 0.5) {
					{
						final String _tagName = "jing_lian";
						final double _tagValue = (n1 + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
					}
					WuqishuaxinProcedure.execute(world, entity, i1);
				}
				itemstack.shrink(1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7d\u62D2\u7EDD"), false);
			}
		}
	}
}