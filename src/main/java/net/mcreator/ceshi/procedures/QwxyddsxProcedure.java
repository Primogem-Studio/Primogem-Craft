package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class QwxyddsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double n1 = 0;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			n1 = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zhi");
			i1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			if (n1 > 0 && i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") < 0) {
				WuqidengjiHSProcedure.execute(world, entity, i1, 1, Double.POSITIVE_INFINITY);
				{
					final String _tagName = "zhi";
					final double _tagValue = (n1 - 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (Math.random() < 0.3) {
					DiaoyongqwyisunhuaiProcedure.execute(world, x, y, z, entity, itemstack);
					itemstack.shrink(1);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal("\u00A7c\u6CA1\u6709\u53D7\u5F71\u54CD\u7948\u613F\u6B66\u5668\uFF0C\u6216\u8C10\u4E50\u5927\u5178\u4F7F\u7528\u6B21\u6570\u8017\u5C3D\uFF0C\u9700\u7B49\u5F85\u51B7\u5374\u5B8C\u6210"), false);
			}
		}
	}
}