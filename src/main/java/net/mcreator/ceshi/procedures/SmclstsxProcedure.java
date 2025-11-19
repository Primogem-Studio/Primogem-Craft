package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.t;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SmclstsxProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double a = 0;
		String s1 = "";
		Entity e1 = null;
		if (!world.isClientSide()) {
			if (sourceentity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PrimogemcraftModMobEffects.SMCLXG) && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.SMCLZF))
					&& entity.getType().is(EntityTypeTags.UNDEAD)) {
				if (Math.random() <= 0.3) {
					if (sourceentity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
						for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
							ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == PrimogemcraftModItems.QWSMCL.get()) {
								a = a + 1;
							}
						}
					}
					if (a != 0) {
						sourceentity.getPersistentData().putBoolean("smcl_cf", true);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SMCLZF, 80, 0, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.PLAYERS, 1, 20);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.PLAYERS, 1, 20, false);
							}
						}
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack15 = (Math.random() < 0.5 ? new ItemStack(PrimogemcraftModItems.ZSF.get()) : new ItemStack(PrimogemcraftModItems.YUANSHIJIAN.get())).copy();
								_setstack15.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack15);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (hasEntityInInventory(sourceentity, new ItemStack(PrimogemcraftModItems.QWCLHY.get()))) {
							sourceentity.getPersistentData().putBoolean("cl_hy", true);
							s1 = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString();
							var t = entity.getType();
							var p = entity.blockPosition();
							var sw = (ServerLevel) world;
							e1 = t.spawn(sw, p, MobSpawnType.MOB_SUMMONED);
							if (e1 instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SMCLZF, 80, 0, false, false));
							if ((e1 instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
								if (e1 instanceof LivingEntity _entity) {
									ItemStack _setstack22 = (Math.random() < 0.5 ? new ItemStack(PrimogemcraftModItems.ZSF.get()) : new ItemStack(PrimogemcraftModItems.YUANSHIJIAN.get())).copy();
									_setstack22.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack22);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if ((e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
								{
									Entity _entity = e1;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
									}
								}
							}
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