package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;

public class Cunzheshuxing3Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			a = entity.getPersistentData().getDouble("GUI_yzsp_sl");
			if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "cunzhe_shuliang", (new java.text.DecimalFormat("##.##").format(a)), true);
			{
				final String _tagName = "pgc_cunchu";
				final double _tagValue = ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("pgc_cunchu") - a);
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY),
						tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A77\u66F4\u6539\u4E86" + new java.text.DecimalFormat("##.##").format(a))), false);
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).set(DataComponents.CUSTOM_NAME,
					Component.literal("\u00A7e\u5B58\u53D6\u51ED\u8BC1\u00A7d\uFF08\u7279\u8D28\uFF09"));
		}
	}
}