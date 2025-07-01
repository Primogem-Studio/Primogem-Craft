package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class Wyzp_sx_1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("kai_jiang")) {
				if (!entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).xyzp_shou_ci) {
					Xyzpsxhs0Procedure.execute(entity, itemstack, 60, "\u00A7c\u00A7l\u4E00\u7B49\u5956\uFF01");
					{
						PrimogemcraftModVariables.PlayerVariables _vars = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
						_vars.xyzp_shou_ci = true;
						_vars.syncPlayerVariables(entity);
					}
				} else {
					if (Math.random() < 0.0001) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PrimogemcraftModBlocks.XYDX.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						Xyzpsxhs0Procedure.execute(entity, itemstack, 5000, "\u00A76\u00A7l\u7279\u7B49\u5956\uFF01");
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:yhxyx"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					} else if (Math.random() < 0.1) {
						Xyzpsxhs0Procedure.execute(entity, itemstack, 60, "\u00A7c\u00A7l\u4E00\u7B49\u5956\uFF01");
					} else {
						Xyzpsxhs0Procedure.execute(entity, itemstack, 5, "\u00A7e\u00A7l\u4E8C\u7B49\u5956\uFF01");
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:dashengchulan01")), SoundSource.PLAYERS, (float) 0.3, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:dashengchulan01")), SoundSource.PLAYERS, (float) 0.3, 1, false);
						}
					}
				}
			} else if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("dai_kai_jiang")) {
				itemstack.shrink(1);
				i1 = new ItemStack(PrimogemcraftModItems.XYZP.get()).copy();
				i1.setCount(1);
				{
					final String _tagName = "dai_kai_jiang";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, i1);
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7d\u5DF2\u53C2\u4E0E\u5F00\u5956\uFF01"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7c\u00A7l\u7B49\u5F85\u5F00\u5956\u4E2D......"), true);
			}
		}
	}
}