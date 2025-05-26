package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.entity.QQyuanchuzi01Entity;

public class Scmjsx0Procedure {
	public static void execute(Entity e1, Entity entity) {
		if (e1 == null || entity == null)
			return;
		boolean o1 = false;
		o1 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.SCMJ_HELMET.get();
		if (entity instanceof QqiyuanJinGuangEntity _datEntSetL)
			_datEntSetL.getEntityData().set(QqiyuanJinGuangEntity.DATA_scmj, o1);
		if (entity instanceof QQyuanchuzi01Entity _datEntSetL)
			_datEntSetL.getEntityData().set(QQyuanchuzi01Entity.DATA_scmj, o1);
	}
}
