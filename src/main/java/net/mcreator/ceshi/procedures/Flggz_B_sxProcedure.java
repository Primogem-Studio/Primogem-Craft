package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Flggz_B_sxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.35));
		entity.getPersistentData().putDouble("fenlieggz_fenlie", 0);
		if (entity.getPersistentData().getDouble("fenlie_ggz_c") == 1) {
			entity.getPersistentData().putBoolean("fenlie_ggz_b", false);
			entity.getPersistentData().putDouble("fenlie_ggz_c", 0);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.FZGGZXG_1);
			itemstack.shrink(1);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7a\u3013\u00A76\u6682\u65F6\u6CA1\u6709\u590D\u5236\u5495\u5495\u949F\u4E86....\u6682\u65F6..."), false);
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FZGGZXG_1, 60, (int) (entity.getPersistentData().getDouble("fenlie_ggz_c") - 1), false, false));
			entity.getPersistentData().putDouble("fenlie_ggz_c", (entity.getPersistentData().getDouble("fenlie_ggz_c") - 1));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.FZGGZXG_1);
			itemstack.shrink(1);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7e\u3013\u00A76\u4E00\u4E2A\u590D\u5236\u54C1\u5206\u88C2\u5495\u5495\u949F\u88AB\u6E05\u7406\u4E86\uFF01"), false);
		}
	}
}