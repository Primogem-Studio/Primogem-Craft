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
		double a = 0;
		ItemStack i1 = ItemStack.EMPTY;
		i1 = new ItemStack(PrimogemcraftModItems.HQYAN.get());
		a = YsjianzhihsProcedure.execute(entity, i1, itemstack, true, 4);
		if (itemstack.getItem() == PrimogemcraftModItems.JLQ.get() && entity.isShiftKeyDown()) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, Mth.nextInt(RandomSource.create(), 2, (int) (a * 2)), Level.ExplosionInteraction.TNT);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 10, 40), _level, null, _stkprov -> {
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (a * 10));
		}
		if (itemstack.getItem() == PrimogemcraftModItems.JLC.get()) {
			if (Math.random() < a / 1000) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(PrimogemcraftModItems.JIANLAOHUANGYU.get()));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}