package net.ai;

import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
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

	/** 从玩家副手召唤生命物品实体，持续 ticks 刻（-1 表示无限），召唤成功后清空副手物品 */
	public static LivingItemEntity summon(Player player, int ticks) {
		if (player == null) {
			return null;
		}
		return summon(player.level(), player, player.getOffhandItem(), ticks, true);
	}

	/** 从玩家副手召唤生命物品实体；infinite 为 true 时无限持续，否则持续默认时长 */
	public static LivingItemEntity summon(Player player, boolean infinite) {
		if (player == null) {
			return null;
		}
		return summon(player.level(), player, player.getOffhandItem(), infinite ? -1 : DEFAULT_TICKS, true);
	}

	/** 在指定世界中从玩家副手召唤生命物品实体，持续 ticks 刻（-1 表示无限） */
	public static LivingItemEntity summon(Level level, Player player, int ticks) {
		if (player == null) {
			return null;
		}
		return summon(level, player, player.getOffhandItem(), ticks, true);
	}

	/** 在指定世界中从玩家副手召唤生命物品实体；infinite 为 true 时无限持续，否则持续默认时长 */
	public static LivingItemEntity summon(Level level, Player player, boolean infinite) {
		if (player == null) {
			return null;
		}
		return summon(level, player, player.getOffhandItem(), infinite ? -1 : DEFAULT_TICKS, true);
	}

	/** 在指定世界中以指定物品召唤生命物品实体，持续 ticks 刻（-1 表示无限） */
	public static LivingItemEntity summon(Level level, Player player, ItemStack stack, int ticks) {
		return summon(level, player, stack, ticks, false);
	}

	/** 在指定世界中以指定物品召唤生命物品实体；infinite 为 true 时无限持续，否则持续默认时长 */
	public static LivingItemEntity summon(Level level, Player player, ItemStack stack, boolean infinite) {
		return summon(level, player, stack, infinite ? -1 : DEFAULT_TICKS, false);
	}

	/** 从玩家副手召唤一个无限持续的生命物品实体 */
	public static LivingItemEntity summonInfinite(Player player) {
		if (player == null) {
			return null;
		}
		return summon(player.level(), player, player.getOffhandItem(), -1, true);
	}

	/** 在指定世界中从玩家副手召唤一个无限持续的生命物品实体 */
	public static LivingItemEntity summonInfinite(Level level, Player player) {
		if (player == null) {
			return null;
		}
		return summon(level, player, player.getOffhandItem(), -1, true);
	}

	/** 在指定世界中以指定物品召唤一个无限持续的生命物品实体 */
	public static LivingItemEntity summonInfinite(Level level, Player player, ItemStack stack) {
		return summon(level, player, stack, -1, false);
	}

	/** 将玩家背包所有物品（主背包与副手）逐个幻化为生命物品实体，持续 ticks 刻；召唤成功的物品从背包移除，返回召唤数量 */
	public static int summonAllFromInventory(Player player, int ticks) {
		if (player == null || player.level().isClientSide) {
			return 0;
		}
		int count = 0;
		Inventory inv = player.getInventory();
		for (int i = 0; i < inv.items.size(); i++) {
			ItemStack stack = inv.items.get(i);
			if (stack.isEmpty()) {
				continue;
			}
			if (summon(player.level(), player, stack, ticks, false) != null) {
				inv.setItem(i, ItemStack.EMPTY);
				count++;
			}
		}
		ItemStack offhand = player.getOffhandItem();
		if (!offhand.isEmpty() && summon(player.level(), player, offhand, ticks, false) != null) {
			player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
			count++;
		}
		return count;
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

	/** 收集主人所有正在生存的生命物品 */
	public static List<LivingItemEntity> collectAll(Player owner) {
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
