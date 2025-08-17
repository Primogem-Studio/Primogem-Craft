package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class HSWzswsProcedure {
	public static boolean execute(LevelAccessor world, double x, double z, Entity entity, ItemStack itemstack, double deng_dai_ke, double fan_wei) {
		if (entity == null)
			return false;
		ItemStack i1 = ItemStack.EMPTY;
		double z1 = 0;
		double y1 = 0;
		double x1 = 0;
		double n1 = 0;
		if (!world.isClientSide()) {
			n1 = fan_wei;
			i1 = itemstack.copy();
			if (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("wzsw") <= deng_dai_ke) {
				{
					final String _tagName = "wzsw";
					final double _tagValue = (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("wzsw") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if (!i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("sun_huai")) {
				x1 = x + Mth.nextInt(RandomSource.create(), (int) (0 - n1), (int) n1);
				y1 = Mth.nextInt(RandomSource.create(), -60, 255);
				z1 = z + Mth.nextInt(RandomSource.create(), (int) (0 - n1), (int) n1);
				{
					final String _tagName = "xa";
					final double _tagValue = x1;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "ya";
					final double _tagValue = y1;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "za";
					final double _tagValue = z1;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if ((world.getBlockState(BlockPos.containing(x1, y1, z1))).getBlock() == Blocks.AIR) {
					world.setBlock(BlockPos.containing(x1, y1, z1), PrimogemcraftModBlocks.QIYU.get().defaultBlockState(), 3);
				}
				{
					final String _tagName = "sun_huai";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7d\u201C\u5947\u9047\u201D\u5DF2\u751F\u6210\uFF01\u67E5\u770B\u5947\u7269\u63CF\u8FF0\u83B7\u53D6\u4F4D\u7F6E"), false);
				return true;
			}
			return false;
		}
		return false;
	}
}