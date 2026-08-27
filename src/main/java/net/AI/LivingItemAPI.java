package net.AI;

import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public final class LivingItemAPI {

	private static final int DEFAULT_TICKS = 1200;

	private LivingItemAPI() {
	}

	public static LivingItemEntity summon(Player player, int ticks) {
		if (player == null) {
			return null;
		}
		return summon(player.level(), player, player.getOffhandItem(), ticks, true);
	}

	public static LivingItemEntity summon(Player player, boolean infinite) {
		if (player == null) {
			return null;
		}
		return summon(player.level(), player, player.getOffhandItem(), infinite ? -1 : DEFAULT_TICKS, true);
	}

	public static LivingItemEntity summon(Level level, Player player, int ticks) {
		if (player == null) {
			return null;
		}
		return summon(level, player, player.getOffhandItem(), ticks, true);
	}

	public static LivingItemEntity summon(Level level, Player player, boolean infinite) {
		if (player == null) {
			return null;
		}
		return summon(level, player, player.getOffhandItem(), infinite ? -1 : DEFAULT_TICKS, true);
	}

	public static LivingItemEntity summon(Level level, Player player, ItemStack stack, int ticks) {
		return summon(level, player, stack, ticks, false);
	}

	public static LivingItemEntity summon(Level level, Player player, ItemStack stack, boolean infinite) {
		return summon(level, player, stack, infinite ? -1 : DEFAULT_TICKS, false);
	}

	public static LivingItemEntity summonInfinite(Player player) {
		if (player == null) {
			return null;
		}
		return summon(player.level(), player, player.getOffhandItem(), -1, true);
	}

	public static LivingItemEntity summonInfinite(Level level, Player player) {
		if (player == null) {
			return null;
		}
		return summon(level, player, player.getOffhandItem(), -1, true);
	}

	public static LivingItemEntity summonInfinite(Level level, Player player, ItemStack stack) {
		return summon(level, player, stack, -1, false);
	}

	private static LivingItemEntity summon(Level level, Player player, ItemStack stack, int ticks, boolean takeOffhand) {
		if (level == null || level.isClientSide || player == null || stack == null || stack.isEmpty()) {
			return null;
		}
		if (!(level instanceof ServerLevel serverLevel)) {
			return null;
		}
		LivingItemEntity entity = PrimogemcraftModEntities.LIVING_ITEM.get().create(serverLevel);
		if (entity == null) {
			return null;
		}
		entity.moveTo(player.getX(), player.getY() + 1.5, player.getZ(), player.getYRot(), 0);
		entity.startLiving(player, stack, ticks);
		serverLevel.addFreshEntity(entity);
		if (takeOffhand && !player.getOffhandItem().isEmpty()) {
			player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
		}
		return entity;
	}
}
