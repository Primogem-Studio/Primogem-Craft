package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.entity.QQyuanchuzi01Entity;

public class ScmjSxProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof QqiyuanJinGuangEntity) {
			return entity instanceof QqiyuanJinGuangEntity _datEntL1 && _datEntL1.getEntityData().get(QqiyuanJinGuangEntity.DATA_scmj);
		} else if (entity instanceof QQyuanchuzi01Entity) {
			return entity instanceof QQyuanchuzi01Entity _datEntL3 && _datEntL3.getEntityData().get(QQyuanchuzi01Entity.DATA_scmj);
		}
		return false;
	}
}