package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class ZsjgjsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (!(sourceentity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PrimogemcraftModMobEffects.GOUYU))) {
				if (itemstack.getItem() == PrimogemcraftModItems.ZSTJ.get()) {
					if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQLEI.get())) ? 0.075 : 0.05)) {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));;
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
				if (itemstack.getItem() == PrimogemcraftModItems.ZSZSJ.get()) {
					if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQLEI.get())) ? 0.105 : 0.07)) {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));;
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
				if (itemstack.getItem() == PrimogemcraftModItems.ZSHJJ.get()) {
					if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQLEI.get())) ? 0.15 : 0.1)) {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));;
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}