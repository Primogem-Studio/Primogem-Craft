package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;

public class BhmgsxProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof QqiyuanJinGuangEntity _datEntL0 && _datEntL0.getEntityData().get(QqiyuanJinGuangEntity.DATA_bhmg);
	}
}