package net.ai;

import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;

import java.util.ArrayList;
import java.util.List;

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

	/** 设置主人所有正在生存的生命物品的剩余时长为 ticks（-1 表示无限），返回受影响数量 */
	public static int setDurationForAll(Player owner, int ticks) {
		List<LivingItemEntity> items = collectAll(owner);
		for (LivingItemEntity entity : items) {
			entity.setRemainingTicks(ticks);
		}
		return items.size();
	}

	/** 给主人所有正在生存的生命物品的时长增减 deltaTicks（正数延长、负数缩短），返回受影响数量 */
	public static int addDurationForAll(Player owner, int deltaTicks) {
		List<LivingItemEntity> items = collectAll(owner);
		for (LivingItemEntity entity : items) {
			entity.setRemainingTicks(entity.getRemainingTicks() + deltaTicks);
		}
		return items.size();
	}

	private static List<LivingItemEntity> collectAll(Player owner) {
		if (owner == null || owner.level().isClientSide) {
			return List.of();
		}
		ServerLevel serverLevel = (ServerLevel) owner.level();
		EntityTypeTest<Entity, LivingItemEntity> test = EntityTypeTest.forClass(LivingItemEntity.class);
		return new ArrayList<>(serverLevel.getEntities(test, entity -> owner.getUUID().equals(entity.getOwnerUuid())));
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
