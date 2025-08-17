package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QwxgdltsxProcedure {
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
		double b = 0;
		ItemStack f = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.QWYHJB.get()) {
				d = false;
				if (Math.random() < 0.15) {
					a = "loot spawn ~ ~ ~ loot primogemcraft:entities/qqiwuzhanlipinshiti";
					c = "\u00A7a\u83B7\u5F97\u968F\u673A\u5947\u7269";
				} else if (Math.random() < 0.15) {
					a = "loot spawn ~ ~ ~ loot primogemcraft:entities/curionegative";
					c = "\u00A7a\u83B7\u5F97\u968F\u673A\u00A7c\u8D1F\u9762\u5947\u7269";
				} else if (Math.random() < 0.1) {
					a = "loot spawn ~ ~ ~ loot primogemcraft:blocks/yinhedaletouzhanlipinbiao";
					c = "\u00A7a\u5C0F\u8D5A\u4E00\u7B14\uFF01";
				} else {
					d = true;
					c = "\u83B7\u5F97\u666E\u901A\u5956\u52B1";
					b = Mth.nextInt(RandomSource.create(), 1, 2);
				}
				f = (Math.random() < 0.5 ? new ItemStack(PrimogemcraftModItems.YUANSHI.get()) : new ItemStack(Items.DIAMOND)).copy();
				if (HSYhdltsxProcedure.execute(world, x, y, z, entity, f, entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY, false, false, d, true, false, true, true, false, true, 0, 0, 0.9, b, 0, 0.5, 1, 0, 0, 1, c,
						(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getDisplayName().getString(), a)) {
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