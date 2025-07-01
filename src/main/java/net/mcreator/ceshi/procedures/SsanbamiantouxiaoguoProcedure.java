package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class SsanbamiantouxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, ItemStack mu_biao, ItemStack shuchu_2, boolean jin_rong_he, boolean qw_0, boolean tong_zhi, boolean zhan_li_pin, double beilv,
			double beilv_0, double lengque, String zhiling) {
		if (entity == null || zhiling == null)
			return;
		HSsbmtsxProcedure.execute(world, x, y, z, entity, item, mu_biao, shuchu_2, jin_rong_he, qw_0, tong_zhi, zhan_li_pin, beilv, beilv_0, lengque, zhiling);
	}
}