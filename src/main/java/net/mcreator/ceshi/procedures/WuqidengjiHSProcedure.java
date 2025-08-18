package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class WuqidengjiHSProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, ItemStack item, double xian_zhi, double zhi) {
		if (entity == null)
			return false;
		ItemStack i1 = ItemStack.EMPTY;
		double a = 0;
		double b = 0;
		if (item.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi")))) {
			a = xian_zhi == Double.POSITIVE_INFINITY ? (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGXIAN)) : xian_zhi - 1;
			i1 = item;
			b = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			if (b >= a) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("dengji_hs_0").getString())), false);
				return false;
			} else {
				{
					final String _tagName = "deng_ji";
					final double _tagValue = (b + zhi);
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") > a) {
					{
						final String _tagName = "deng_ji";
						final double _tagValue = a;
						CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
				WuqishuaxinProcedure.execute(world, entity, i1);
				return true;
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("dengji_hs_2").getString())), false);
		}
		return false;
	}
}