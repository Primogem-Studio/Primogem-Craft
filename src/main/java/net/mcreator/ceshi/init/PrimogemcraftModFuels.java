/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class PrimogemcraftModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == PrimogemcraftModBlocks.MUTANKUAI.get().asItem())
			event.setBurnTime(16000);
		else if (itemstack.getItem() == PrimogemcraftModBlocks.DISUIKUAI_1.get().asItem())
			event.setBurnTime(40);
		else if (itemstack.getItem() == PrimogemcraftModBlocks.DISUISHUIJINGTI.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == PrimogemcraftModItems.DISUI.get())
			event.setBurnTime(2000);
	}
}