package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.g;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModEntities;

public class Ceshi_3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		Entity e = null;
		boolean o1 = false;
		if (entity.isShiftKeyDown()) {
			o1 = world instanceof ServerLevel _level1 && _level1.isVillage(BlockPos.containing(x, y, z));
			e = entity;
			EventGroupProcedure.execute(world, entity, 12);//为实体打开20号事件组
			java.util.List<Integer> g = net.mcreator.ceshi.procedures.EventGroupProcedure.getRegisteredGroupIds();
			System.out.println(g);//这两行不管！！
		} else {
			if (!world.isClientSide()) {
				e = world instanceof ServerLevel _level3 ? PrimogemcraftModEntities.S_WFENGRAOJIANGSHI.get().spawn(_level3, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED) : null;
				e.getPersistentData().putString("Event_Entity_Loot", "primogemcraft:entities/fengraozlp");
				e.getPersistentData().putBoolean("Event_Entity_Loot_tag", true);
			}
		}
	}
}