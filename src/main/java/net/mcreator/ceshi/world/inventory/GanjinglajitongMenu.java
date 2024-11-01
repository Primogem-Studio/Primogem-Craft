
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

import net.mcreator.ceshi.procedures.GanjinglajikaiProcedure;
import net.mcreator.ceshi.procedures.GanjinglajiguanProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModMenus;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class GanjinglajitongMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
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

	public GanjinglajitongMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(PrimogemcraftModMenus.GANJINGLAJITONG.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(45);
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
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 8, 17) {
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 26, 17) {
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 44, 17) {
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 62, 17) {
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 80, 17) {
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 98, 17) {
		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 116, 17) {
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 134, 17) {
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 152, 17) {
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 8, 35) {
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 26, 35) {
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 44, 35) {
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 62, 35) {
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 80, 35) {
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 98, 35) {
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 116, 35) {
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 134, 35) {
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 152, 35) {
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 8, 53) {
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 26, 53) {
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 44, 53) {
		}));
		this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 62, 53) {
		}));
		this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 80, 53) {
		}));
		this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 98, 53) {
		}));
		this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 116, 53) {
		}));
		this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 134, 53) {
		}));
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 152, 53) {
		}));
		this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 8, 71) {
		}));
		this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 26, 71) {
		}));
		this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 44, 71) {
		}));
		this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 62, 71) {
		}));
		this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 80, 71) {
		}));
		this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 98, 71) {
		}));
		this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 116, 71) {
		}));
		this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 134, 71) {
		}));
		this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 152, 71) {
		}));
		this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 8, 89) {
		}));
		this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 26, 89) {
		}));
		this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 44, 89) {
		}));
		this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 62, 89) {
		}));
		this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 80, 89) {
		}));
		this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 98, 89) {
		}));
		this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 116, 89) {
		}));
		this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 134, 89) {
		}));
		this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 152, 89) {
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 0 + 8 + sj * 18, 34 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 0 + 8 + si * 18, 34 + 142));
		GanjinglajikaiProcedure.execute(world, x, y, z);
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
			if (index < 45) {
				if (!this.moveItemStackTo(itemstack1, 45, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 45, false)) {
				if (index < 45 + 27) {
					if (!this.moveItemStackTo(itemstack1, 45 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 45, 45 + 27, false))
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
		GanjinglajiguanProcedure.execute(world, x, y, z);
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
