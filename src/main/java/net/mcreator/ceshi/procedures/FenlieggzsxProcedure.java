package net.mcreator.ceshi.procedures;

import org.checkerframework.checker.units.qual.t;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.component.CustomData;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FenlieggzsxProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity e1 = null;
		String s1 = "";
		ItemStack a = ItemStack.EMPTY;
		ItemStack b = ItemStack.EMPTY;
		ItemStack c0 = ItemStack.EMPTY;
		ItemStack c1 = ItemStack.EMPTY;
		ItemStack c2 = ItemStack.EMPTY;
		ItemStack c3 = ItemStack.EMPTY;
		if (entity.getType().is(EntityTypeTags.UNDEAD) && !(sourceentity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(PrimogemcraftModItems.QWGGZFENLIE_A.get())) && sourceentity instanceof LivingEntity _livEnt2
				&& _livEnt2.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_0) && sourceentity instanceof Player
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
				&& Math.random() <= ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1).getAmplifier() : 0) + 2) * 0.05) {
			if (!world.isClientSide()) {
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown(PrimogemcraftModItems.QWGGZFENLIE_A.get(), 20);
				s1 = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString();
				var t = entity.getType();
				var p = entity.blockPosition();
				var sw = (ServerLevel) world;
				e1 = t.spawn(sw, p, MobSpawnType.MOB_SUMMONED);
				if (e1 instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.HSLGGZFUZHIPIN, 24000, 0));
				{
					Entity _entity = e1;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(PrimogemcraftModItems.TESHUKUIJIA_01_HELMET.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PrimogemcraftModItems.TESHUKUIJIA_01_HELMET.get()));
					}
				}
				if (e1 instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PrimogemcraftModItems.QWGGZFENLIE_B.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (sourceentity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1)) {
					if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1).getAmplifier() : 0) == 0) {
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.IRON_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.IRON_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.IRON_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
							}
						}
						if (e1 instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.GOLDEN_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1).getAmplifier() : 0) == 1) {
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.DIAMOND_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.DIAMOND_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.DIAMOND_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
							}
						}
						if (e1 instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.IRON_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1).getAmplifier() : 0) == 2) {
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.NETHERITE_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.NETHERITE_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.NETHERITE_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
							}
						}
						if (e1 instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
				a = (e1 instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
				b = (e1 instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
				c0 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy();
				c1 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy();
				c2 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy();
				c3 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy();
				{
					final String _tagName = "bukeshiquwupin";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "bukeshiquwupin";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, b, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "bukeshiquwupin";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, c0, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "bukeshiquwupin";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, c1, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "bukeshiquwupin";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, c2, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "bukeshiquwupin";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, c3, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
				c0.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
				c1.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
				c2.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
				c3.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
				if (world instanceof ServerLevel _level) {
					a.hurtAndBreak((int) (a.getMaxDamage() * 0.8), _level, null, _stkprov -> {
					});
				}
				if (world instanceof ServerLevel _level) {
					c0.hurtAndBreak((int) (c0.getMaxDamage() * 0.8), _level, null, _stkprov -> {
					});
				}
				if (world instanceof ServerLevel _level) {
					c1.hurtAndBreak((int) (c1.getMaxDamage() * 0.8), _level, null, _stkprov -> {
					});
				}
				if (world instanceof ServerLevel _level) {
					c2.hurtAndBreak((int) (c2.getMaxDamage() * 0.8), _level, null, _stkprov -> {
					});
				}
				if (world instanceof ServerLevel _level) {
					c3.hurtAndBreak((int) (c3.getMaxDamage() * 0.8), _level, null, _stkprov -> {
					});
				}
			}
		}
	}
}