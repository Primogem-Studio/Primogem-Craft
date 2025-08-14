package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class QywuqimsleiProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack i = ItemStack.EMPTY;
		String s1 = "";
		i = itemstack;
		s1 = qywqmslei(i, "danshou", "§e单手剑");
		s1 = qywqmslei(i, "changbing", "§e长柄武器");
		return s1;
	}

	public static String qywqmslei(ItemStack itemstack, String qw_lei, String lei) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse((qw_lei).toLowerCase(java.util.Locale.ENGLISH))))) {
			return lei;
		}
		return "";
	}
}