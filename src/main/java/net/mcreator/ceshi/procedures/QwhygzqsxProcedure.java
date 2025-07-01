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

public class QwhygzqsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			i1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
			if (i1.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi")))) {
				if (Math.random() < 0.1) {
					WuqidengjiHSProcedure.execute(world, entity, i1, Double.POSITIVE_INFINITY, 30);
				} else {
					{
						final String _tagName = "deng_ji";
						final double _tagValue = (-1000);
						CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
					}
					WuqishuaxinProcedure.execute(world, entity, i1);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				itemstack.shrink(1);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7c\u62D2\u7EDD"), false);
			}
		}
	}
}