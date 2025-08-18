package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class CunzheguibwdProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack a1 = ItemStack.EMPTY;
		double a = 0;
		a1 = new ItemStack(PrimogemcraftModItems.CUNQUPINGZHENG.get());
		a = entity.getPersistentData().getDouble("GUI_yzsp_sl");
		if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "cunzhe_shuliang", (new java.text.DecimalFormat("##.##").format(a)), true);
		if (!world.isClientSide()) {
			{
				final String _tagName = "pgc_cunchu";
				final double _tagValue = (a1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("pgc_cunchu") + a);
				CustomData.update(DataComponents.CUSTOM_DATA, a1, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "bwd_yinhang";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, a1, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A77\u66F4\u6539\u4E86" + new java.text.DecimalFormat("##.##").format(a))), false);
		a1.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7e\u5B58\u53D6\u51ED\u8BC1\u00A7d\uFF08\u7279\u8D28\uFF09"));
		if (entity instanceof Player _player) {
			ItemStack _setstack = a1.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}