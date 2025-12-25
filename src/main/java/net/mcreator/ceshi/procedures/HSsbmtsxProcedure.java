package net.mcreator.ceshi.procedures;

import net.per.curio.CurioEffectPGC;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class HSsbmtsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, ItemStack mu_biao, ItemStack shuchu_2, boolean jin_rong_he, boolean qw_0, boolean tong_zhi, boolean zhan_li_pin, double beilv,
			double beilv_0, double lengque, String zhiling) {
		if (entity == null || zhiling == null)
			return;
		Entity e = null;
		ItemStack a = ItemStack.EMPTY;
		double out = 0;
		double b = 0;
		double c = 0;
		boolean o1 = false;
		if (!world.isClientSide()) {
			if (tong_zhi) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((item.getDisplayName().getString() + "\u00A7c\u5DF2\u635F\u574F\uFF01")), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(item.getItem(), (int) lengque);
			}
			e = entity;
			if (qw_0) {
				e = entity;
				o1 = jin_rong_he;
				var cep = new CurioEffectPGC();
				out = new CurioEffectPGC.Processor(world, entity).curioDice(true, items -> {
					return jin_rong_he
							? cep.isInAnyCurioDiceTag(items, "c:curio", "c:curio/normal/fusion/s", "c:curio/normal/fusion/a", "c:curio/normal/fusion/b")
							: cep.isInAnyCurioDiceTag(items, "c:curio", "c:curio/bad") && items.getItem() != item.getItem();
				});
			} else {
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
					for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
						if (itemstackiterator.getItem() == mu_biao.getItem()) {
							out = out + itemstackiterator.getCount();
						}
					}
				}
			}
			if (zhan_li_pin) {
				for (int index0 = 0; index0 < (int) (out + Math.floor(out * beilv + beilv_0)); index0++) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), zhiling);
				}
			} else {
				a = shuchu_2;
				a.setCount((int) (out + Math.floor(out * beilv + beilv_0)));
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, a);
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}