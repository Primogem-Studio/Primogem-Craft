package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class GUIhldztjlhsProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, ItemStack itemstack, double zhi) {
		if (entity == null)
			return false;
		ItemStack i1 = ItemStack.EMPTY;
		double b = 0;
		double on1 = 0;
		if (!world.isClientSide()) {
			b = zhi;
			i1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get((int) b).getItem() : ItemStack.EMPTY);
			if (NBTzhi(itemstack) + NBTzhi(i1) < 4) {
				if (i1.getItem() == PrimogemcraftModItems.TEZHIDIEYINGQI.get()) {
					JLnbt(itemstack, 1, true);
					on1 = on1 + 1;
				} else if (i1.getItem() == itemstack.getItem()) {
					double a = NBTzhi(i1) + 1;
					if (itemstack.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi/5")))) {
						JLnbt(itemstack, (int) a, true);
						on1 = on1 + 1;
					} else {
						JLnbt(itemstack, (int) a, false);
						on1 = on1 + 1;
					}
				}
				if (on1 == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof PrimogemcraftModMenus.MenuAccessor _menu) {
						_menu.getSlots().get((int) b).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					return true;
				}
			}
		}
		return false;
	}

	public static void JLnbt(ItemStack itemstack, int zhi, boolean o1) {
		var a = DataComponents.CUSTOM_DATA;
		var ab = CustomData.EMPTY;
		String s = "jing_lian";
		String s2 = o1 ? "_zhen" : "_jia";
		final double nzhi = (itemstack.getOrDefault(a, ab).copyTag().getDouble(s + s2));
		final double jzhi = (itemstack.getOrDefault(a, ab).copyTag().getDouble(s));
		CustomData.update(a, itemstack, tag -> tag.putDouble(s + s2, nzhi + zhi));
		CustomData.update(a, itemstack, tag -> tag.putDouble(s, jzhi + zhi));
		final String _tagName = "jing_lian_mmkj";
		final String _tagValue = (BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString());
		CustomData.update(a, itemstack, tag -> tag.putString(_tagName, _tagValue));
	}

	public static double NBTzhi(ItemStack itemstack) {
		return (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian"));
	}

	public boolean abc() {
		return false;
	}
}