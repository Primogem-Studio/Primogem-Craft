package net.mcreator.ceshi.item.inventory;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.world.inventory.MaoxianjiazhinangguiMenu;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nonnull;

@EventBusSubscriber
public class MaoxianjiazhinangInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == PrimogemcraftModItems.MAOXIANJIAZHINANG.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof MaoxianjiazhinangguiMenu)
				player.closeContainer();
		}
	}

	public MaoxianjiazhinangInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 27);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != PrimogemcraftModItems.MAOXIANJIAZHINANG.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}