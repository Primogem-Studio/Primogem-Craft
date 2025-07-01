package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Flggz_xg_0_sx_0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1).getAmplifier() : 0) < 2) {
				entity.getPersistentData().putDouble("fenlieggz_fenlie", (entity.getPersistentData().getDouble("fenlieggz_fenlie") + 1));
				if (entity.getPersistentData().getDouble("fenlieggz_fenlie") >= 6000) {
					a = new ItemStack(PrimogemcraftModItems.QWGGZFENLIE_B.get()).copy();
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 10, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 10, 1, false);
						}
					}
					entity.getPersistentData().putDouble("fenlieggz_fenlie", 0);
					entity.getPersistentData().putBoolean("fenlie_ggz_b", true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FZGGZXG_1, 60, (int) entity.getPersistentData().getDouble("fenlie_ggz_c"), false, false));
					entity.getPersistentData().putDouble("fenlie_ggz_c", (entity.getPersistentData().getDouble("fenlie_ggz_c") + 1));
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1).getAmplifier() : 0) == 1) {
						a.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7d\u5206\u88C2\u5495\u5495\u949F \u00A7cII"));
					} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1).getAmplifier() : 0) == 2) {
						a.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7d\u5206\u88C2\u5495\u5495\u949F \u00A7cIII"));
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = a.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7c\u5206\u88C2\u5495\u5495\u949F\u8FDB\u884C\u4E86\u4E00\u6B21\u5206\u88C2"), false);
				}
			}
		}
	}
}