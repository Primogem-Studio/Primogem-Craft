package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class WfjmsProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		return MSHSwuqi00Procedure.execute(itemstack,
				"\u00A76\u00A7n\u666E\u901A\u653B\u51FB" + "\n"
						+ ("\u00A7e\u6BCF\u6B21\u653B\u51FB\u76EE\u6807\u90FD\u5C06\u4FEE\u590D\u00A7b" + new java.text.DecimalFormat("##.##").format(0.5 * HSjinglianProcedure.execute(itemstack)) + "\u00A7e\u70B9\u8010\u4E45\u5EA6") + "\n"
						+ "\u00A76\u00A7n\u53F3\u952E" + "\n"
						+ ("\u00A7e\u6D88\u8017\u9971\u98DF\u5EA6\u5BF9\u9644\u8FD1\u751F\u7269\u9020\u6210\u00A7b" + (new java.text.DecimalFormat("##.##")
								.format((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0) * 0.3
										* HSjinglianProcedure.execute(itemstack)))
								+ "\u500D\u00A7e\u653B\u51FB\u529B\u7684\u95EA\u7535\u4F24\u5BB3")
						+ "\n" + "\u00A76\u00A7n\u6F5C\u884C+\u53F3\u952E\u653B\u51FB" + "\n" + ("\u00A7e\u6D88\u801720%\u6700\u5927\u751F\u547D\u503C\u83B7\u5F97\u00A7b"
								+ new java.text.DecimalFormat("").format(1 + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian")) + "\u00A7e\u7EA7\u6301\u7EED0.25\u79D2\u9971\u548C\u6548\u679C"));
	}
}
