package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class HeiyinqmsProcedure {
	public static String execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		double hunt = 0;
		double en = 0;
		String s = "";
		a = HSjinglianupProcedure.execute(entity, itemstack);
		en = itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("primogemcraft:hunt"))));
		hunt = a + en;
		s = en > 0 ? "\u00A7d" : "\u00A7b";
		return MSHSwuqi00Procedure.execute(entity, itemstack, "\u00A76\u00A7l\u00A7n\u666E\u901A\u653B\u51FB" + "\n" + "\u00A7e\u5BF9\u4EA1\u7075\u751F\u7269\u65BD\u52A0\u7981\u9522\uFF0C\u6301\u7EED\u00A7b"
				+ new java.text.DecimalFormat("##.##\u79D2").format(2 + 0.5 * a) + "\u00A7e\u51B7\u53744\u79D2" + "\n" + "\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u653B\u51FB\u4EA1\u7075\u751F\u7269\u540E\uFF0C\u83B7\u5F97\u00A7b"
				+ new java.text.DecimalFormat("##.##%").format(0.4 + 0.1 * a) + "\u00A7e\u653B\u51FB\u529B\u52A0\u6210" + "\n"
				+ "\u00A7e\u653B\u51FB\u975E\u4EA1\u7075\u751F\u7269\u65F6\uFF0C\u52A0\u6210\u5931\u6548\u5E76-1\u5F53\u524D\u653B\u51FB\u529B"
				+ ("\n" + "\u00A76\u00A7l\u00A7n\u7279\u6B8A\u88AB\u52A8" + "\n" + "\u00A7e\u653B\u51FB\u53D7\u4E30\u9976\u6548\u679C\u5F71\u54CD\u7684\u654C\u4EBA\u65F6\u4F1A\u5C06\u5176\u6548\u679C\u79FB\u9664" + "\n" + ("\u00A7e\u51B7\u5374" + s)
						+ new java.text.DecimalFormat("").format(25 - 5 * hunt) + "\u00A7e\u79D2\uFF0C\u53EF\u4E0E \u00A7d\u5DE1\u730E\u00A7e \u9644\u9B54\u53E0\u52A0" + "\n"
						+ "\u00A7e\u7CBE\u70BC+\u9644\u9B54\u5C42\u6570\u5927\u4E8E4\u65F6\uFF0C\u4F1A\u5C06\u5176\u6548\u679C\u8F6C\u79FB\u81F3\u81EA\u8EAB" + "\n" + "\u00A7e\u6700\u5927\u4E0D\u8D85\u8FC7 300 \u79D2\uFF0C\u51B7\u5374 300 \u79D2"));
	}
}