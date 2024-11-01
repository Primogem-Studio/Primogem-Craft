
package net.mcreator.ceshi.world.inventory;

import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.procedures.Ddaizi_yinpinProcedure;
import net.mcreator.ceshi.procedures.Daizi_guanbiProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModMenus;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class ZhangquanzhezhinangguiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public ZhangquanzhezhinangguiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(PrimogemcraftModMenus.ZHANGQUANZHEZHINANGGUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(66);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				IItemHandler cap = itemstack.getCapability(Capabilities.ItemHandler.ITEM);
				if (cap != null) {
					this.internal = cap;
					this.bound = true;
				}
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null) {
					IItemHandler cap = boundEntity.getCapability(Capabilities.ItemHandler.ENTITY);
					if (cap != null) {
						this.internal = cap;
						this.bound = true;
					}
				}
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity instanceof BaseContainerBlockEntity baseContainerBlockEntity) {
					this.internal = new InvWrapper(baseContainerBlockEntity);
					this.bound = true;
				}
			}
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 10, 16) {
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 28, 16) {
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 46, 16) {
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 64, 16) {
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 82, 16) {
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 100, 16) {
		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 118, 16) {
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 136, 16) {
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 154, 16) {
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 172, 16) {
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 190, 16) {
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 10, 34) {
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 28, 34) {
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 46, 34) {
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 64, 34) {
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 82, 34) {
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 100, 34) {
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 118, 34) {
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 136, 34) {
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 154, 34) {
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 172, 34) {
		}));
		this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 190, 34) {
		}));
		this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 10, 52) {
		}));
		this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 28, 52) {
		}));
		this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 46, 52) {
		}));
		this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 64, 52) {
		}));
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 82, 52) {
		}));
		this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 100, 52) {
		}));
		this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 118, 52) {
		}));
		this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 136, 52) {
		}));
		this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 154, 52) {
		}));
		this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 172, 52) {
		}));
		this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 190, 52) {
		}));
		this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 10, 70) {
		}));
		this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 28, 70) {
		}));
		this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 46, 70) {
		}));
		this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 64, 70) {
		}));
		this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 82, 70) {
		}));
		this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 100, 70) {
		}));
		this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 118, 70) {
		}));
		this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 136, 70) {
		}));
		this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 154, 70) {
		}));
		this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 172, 70) {
		}));
		this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 190, 70) {
		}));
		this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 10, 88) {
		}));
		this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 28, 88) {
		}));
		this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 46, 88) {
		}));
		this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 64, 88) {
		}));
		this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 82, 88) {
		}));
		this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 100, 88) {
		}));
		this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 118, 88) {
		}));
		this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 136, 88) {
		}));
		this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 154, 88) {
		}));
		this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 172, 88) {
		}));
		this.customSlots.put(54, this.addSlot(new SlotItemHandler(internal, 54, 190, 88) {
		}));
		this.customSlots.put(55, this.addSlot(new SlotItemHandler(internal, 55, 10, 106) {
		}));
		this.customSlots.put(56, this.addSlot(new SlotItemHandler(internal, 56, 28, 106) {
		}));
		this.customSlots.put(57, this.addSlot(new SlotItemHandler(internal, 57, 46, 106) {
		}));
		this.customSlots.put(58, this.addSlot(new SlotItemHandler(internal, 58, 64, 106) {
		}));
		this.customSlots.put(59, this.addSlot(new SlotItemHandler(internal, 59, 82, 106) {
		}));
		this.customSlots.put(60, this.addSlot(new SlotItemHandler(internal, 60, 100, 106) {
		}));
		this.customSlots.put(61, this.addSlot(new SlotItemHandler(internal, 61, 118, 106) {
		}));
		this.customSlots.put(62, this.addSlot(new SlotItemHandler(internal, 62, 136, 106) {
		}));
		this.customSlots.put(63, this.addSlot(new SlotItemHandler(internal, 63, 154, 106) {
		}));
		this.customSlots.put(64, this.addSlot(new SlotItemHandler(internal, 64, 172, 106) {
		}));
		this.customSlots.put(65, this.addSlot(new SlotItemHandler(internal, 65, 190, 106) {
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 20 + 8 + sj * 18, 51 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 20 + 8 + si * 18, 51 + 142));
		Ddaizi_yinpinProcedure.execute(world, x, y, z);
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 66) {
				if (!this.moveItemStackTo(itemstack1, 66, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 66, false)) {
				if (index < 66 + 27) {
					if (!this.moveItemStackTo(itemstack1, 66 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 66, 66 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0)
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override /**
				* Merges provided ItemStack with the first available one in the container/player inventor between minIndex (included) and maxIndex (excluded). Args : stack, minIndex, maxIndex, negativDirection. [!] the Container implementation do not check if the item is valid for the slot
				*/
	protected boolean moveItemStackTo(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
		boolean flag = false;
		int i = startIndex;
		if (reverseDirection) {
			i = endIndex - 1;
		}
		if (stack.isStackable()) {
			while (!stack.isEmpty() && (reverseDirection ? i >= startIndex : i < endIndex)) {
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameComponents(stack, itemstack)) {
					int j = itemstack.getCount() + stack.getCount();
					int k = slot.getMaxStackSize(itemstack);
					if (j <= k) {
						stack.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < k) {
						stack.shrink(k - itemstack.getCount());
						itemstack.setCount(k);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (reverseDirection) {
					i--;
				} else {
					i++;
				}
			}
		}
		if (!stack.isEmpty()) {
			if (reverseDirection) {
				i = endIndex - 1;
			} else {
				i = startIndex;
			}
			while (reverseDirection ? i >= startIndex : i < endIndex) {
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(stack)) {
					int l = slot1.getMaxStackSize(stack);
					slot1.setByPlayer(stack.split(Math.min(stack.getCount(), l)));
					slot1.setChanged();
					flag = true;
					break;
				}
				if (reverseDirection) {
					i--;
				} else {
					i++;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		Daizi_guanbiProcedure.execute(world, x, y, z);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.getStackInSlot(j), false);
					if (internal instanceof IItemHandlerModifiable ihm)
						ihm.setStackInSlot(j, ItemStack.EMPTY);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.getStackInSlot(i));
					if (internal instanceof IItemHandlerModifiable ihm)
						ihm.setStackInSlot(i, ItemStack.EMPTY);
				}
			}
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
