package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class JjlcjlqsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == PrimogemcraftModItems.JLQ.get() && entity.isShiftKeyDown()) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, Mth.nextInt(RandomSource.create(), 2, 8), Level.ExplosionInteraction.TNT);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 10, 40), _level, null, _stkprov -> {
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), Mth.nextInt(RandomSource.create(), (int) (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQYAN.get())) ? 80 : 160),
						(int) (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQYAN.get())) ? 160 : 320)));
		}
		if (itemstack.getItem() == PrimogemcraftModItems.JLC.get()) {
			if (Math.random() < (hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.HQYAN.get())) ? 0.0015 : 0.001)) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(PrimogemcraftModItems.JIANLAOHUANGYU.get()));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
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