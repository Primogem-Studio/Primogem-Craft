package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.Calendar;

public class Ysdc_sxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String s1 = "";
		String s2 = "";
		if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u5DF2\u8BB0\u5F55\uFF0C\u53F3\u952E\u67E5\u770B"), false);
			{
				final String _tagName = "vhoukajiance_shijian";
				final String _tagValue = Calendar.getInstance().getTime().toString();
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "vhoukajiance_mingcheng";
				final String _tagValue = (entity.getDisplayName().getString());
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "vhoukajiance_lan";
				final double _tagValue = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_lan;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "vhoukajiance_zi";
				final double _tagValue = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_zi;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "vhoukajiance_jin";
				final double _tagValue = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_jin;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "vhoukajiance_zi_1";
				final double _tagValue = (10 - entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).zi_baodi);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "vhoukajiance_jin_1";
				final double _tagValue = (50 - entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jin_baodi);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "vhoukajiance_pinjun";
				final double _tagValue = Math
						.round((entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_jin + entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_zi + entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_lan)
								/ entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_jin);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(("<" + entity.getDisplayName().getString() + ">\u5206\u4EAB\u7684\u7948\u613F\u8BB0\u5F55")));
		} else {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.SCMJ_HELMET.get()) {
				s1 = "\u5F69";
				s2 = "\u91D1";
			} else {
				s1 = "\u91D1";
				s2 = "\u7D2B";
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u73A9\u5BB6<" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("vhoukajiance_mingcheng") + ">\u7684\u62BD\u5361\u8BB0\u5F55\uFF1A")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u622A\u81F3\u7CFB\u7EDF\u65F6:" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("vhoukajiance_shijian") + "\u8BB0\u5F55")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A77\u5F53\u524D\u51FA\u84DD\u00A7b" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("vhoukajiance_lan") + "\u00A77\u603B\u5171")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal((("\u00A77\u5F53\u524D\u51FA" + s2 + "\u00A7d") + "" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("vhoukajiance_zi") + "\u00A77\u603B\u5171")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal((("\u00A77\u5F53\u524D\u51FA" + s1 + "\u00A7e") + "" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("vhoukajiance_jin") + "\u00A77\u603B\u5171")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal((("\u00A77\u8DDD\u79BB\u51FA" + s2 + "\u00A7a\u8FD8\u5269\u00A77") + "" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("vhoukajiance_zi_1") + "\u00A7a\u62BD")),
						false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal((("\u00A77\u8DDD\u79BB\u51FA" + s1 + "\u00A7a\u8FD8\u5269\u00A77") + "" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("vhoukajiance_jin_1") + "\u00A7a\u62BD")),
						false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7e\u5E73\u5747\u7EA6" + new java.text.DecimalFormat("").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("vhoukajiance_jin") > 0
						? itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("vhoukajiance_pinjun")
						: 0) + ("\u53D1\u51FA\u73B0\u00A7b1\u4E2A\u00A7e" + s1 + "\u5149\uFF01"))), false);
		}
	}
}
