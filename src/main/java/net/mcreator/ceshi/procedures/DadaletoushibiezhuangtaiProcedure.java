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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DadaletoushibiezhuangtaiProcedure {
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
		double b = 0;
		String a = "";
		String c = "";
		boolean d = false;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.YIYINHEDALETOU.get()) {
				d = true;
				if (Math.random() < 0.006) {
					c = "\u00A7c\u00A7l\u53F2\u65E0\u524D\u4F8B\u7684\u5956\u52B1\uFF01\uFF01";
					b = Mth.nextInt(RandomSource.create(), 64, 32);
					if (!(entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel
							&& _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:nibaodimeila"))).isDone())) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:nibaodimeila"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
				} else {
					if (Math.random() < 0.1) {
						b = Mth.nextInt(RandomSource.create(), 8, 20);
						c = "\u00A7a\u4E0D\u4E8F\u5C31\u662F\u8D5A\uFF01";
					} else if (Math.random() < 0.2) {
						b = Mth.nextInt(RandomSource.create(), 3, 12);
						c = "\u00A7a\u5C0F\u8D5A\u4E00\u7B14\uFF01";
					} else {
						d = false;
						if (Math.random() < 0.3) {
							a = "loot spawn ~ ~ ~ loot primogemcraft:entities/qqiwuzhanlipinshiti";
							c = "\u00A7a\u83B7\u5F97\u968F\u673A\u5947\u7269";
						} else if (Math.random() < 0.3) {
							a = "loot spawn ~ ~ ~ loot primogemcraft:entities/curionegative";
							c = "\u00A7a\u83B7\u5F97\u968F\u673A\u00A7c\u8D1F\u9762\u5947\u7269";
						} else {
							if (entity instanceof ServerPlayer _plr8 && _plr8.level() instanceof ServerLevel
									&& _plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:lletouderenke"))).isDone()) {
								a = "loot spawn ~ ~ ~ loot primogemcraft:feiqiutongdao";
								c = "\u00A7a\u7A33\u8D5A\u4E0D\u8D54";
							} else {
								a = "loot spawn ~ ~ ~ loot primogemcraft:blocks/yinhedaletouzhanlipinbiao";
								c = "\u00A7a\u5C0F\u8D5A\u4E00\u7B14\uFF01";
							}
						}
					}
				}
				if (HSYhdltsxProcedure
						.execute(world, x, y, z, entity, new ItemStack(Items.DIAMOND), entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY, true, true, d, true, false, true, true,
								hasEntityInInventory(entity, new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get())), true, 0, 0.98, 0.4, b, 0,
								entity instanceof ServerPlayer _plr9 && _plr9.level() instanceof ServerLevel
										&& _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:lletouderenke"))).isDone() ? 0.8 : 0.5,
								1, Mth.nextInt(RandomSource.create(), 1, 5), Mth.nextInt(RandomSource.create(), 1, 2), 1, c, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getDisplayName().getString(), a)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 127));
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.SHQWYHDLT.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						PrimogemcraftModVariables.PlayerVariables _vars = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
						_vars.daletou_jishu = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).daletou_jishu + 1;
						_vars.syncPlayerVariables(entity);
					}
					if (entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).daletou_jishu >= 100) {
						if (!(entity instanceof ServerPlayer _plr18 && _plr18.level() instanceof ServerLevel
								&& _plr18.getAdvancements().getOrStartProgress(_plr18.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:lletouderenke"))).isDone())) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:lletouderenke"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7e\u5C0F\u73A9\u6021\u60C5\uFF0C\u5927\u8D4C\u4F24\u8EAB\uFF01"), false);
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