package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Flggz_sx_1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double jingyan = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_0)) {
			jingyan = DiaoyongjisuanjingyanzhiProcedure.execute(entity);
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(-(itemstack.getDamageValue()));
			itemstack.setDamageValue((int) ((itemstack.getMaxDamage() - jingyan) - (itemstack.getMaxDamage() - itemstack.getDamageValue())));
			if (itemstack.getDamageValue() == 0 && !(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1))) {
				entity.getPersistentData().putBoolean("fenlie_ggz_a", false);
				entity.getPersistentData().putBoolean("fenlie_ggz_b", false);
				entity.getPersistentData().putBoolean("fenlie_ggz_c", false);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.FZGGZXG_0);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PrimogemcraftModMobEffects.FZGGZXG_1);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7a\u3013\u00A75\u5206\u88C2\u5495\u5495\u949F \u505C\u6B62\u4E86\u5206\u88C2\uFF01"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74\u3013\u00A7c\u5F53\u524D\u7ECF\u9A8C\u4E0D\u8DB3\u6216\u6B63\u5728\u88AB\u590D\u5236\u54C1\u5206\u88C2\u5495\u5495\u949F\u5E72\u6270\uFF01"), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76\u3013\u00A7a\u4F60\u5DF2\u4E0D\u53D7\u5206\u88C2\u5495\u5495\u949F\u7684\u5F71\u54CD\uFF01"), false);
		}
		DiaoyonghuishouProcedure.execute(entity, itemstack);
	}
}