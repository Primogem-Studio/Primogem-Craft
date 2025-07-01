package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QwxydltsxProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String a = "";
		String c = "";
		boolean d = false;
		ItemStack f = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.QWXYDLT.get()) {
				d = false;
				f = (Math.random() < 0.7 ? new ItemStack(PrimogemcraftModItems.JLLIANG.get()) : new ItemStack(PrimogemcraftModItems.JLMO.get()));
				if (HSYhdltsxProcedure.execute(world, x, y, z, entity, f, entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY, false, false, true, true, false, false, true, false, false, 0, 0, 0.2,
						Mth.nextDouble(RandomSource.create(), 1, 5), 0, 0.5, 0, 0, 0, 0, "\u00A7d\u83B7\u5F97\u7CBE\u953B\u77FF\u77F3\uFF01",
						(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getDisplayName().getString(), "")) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.SHQWYHDLT.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}