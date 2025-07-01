package net.mcreator.ceshi.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import net.mcreator.ceshi.procedures.JjlkjsxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;
import java.util.EnumMap;

import com.google.common.collect.Iterables;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class JlkjhjItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 6);
				map.put(ArmorItem.Type.LEGGINGS, 7);
				map.put(ArmorItem.Type.CHESTPLATE, 9);
				map.put(ArmorItem.Type.HELMET, 6);
				map.put(ArmorItem.Type.BODY, 9);
			}), 20, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_netherite")),
					() -> Ingredient.of(new ItemStack(PrimogemcraftModItems.ZHAPIANDINGZHENGSHI.get()), new ItemStack(PrimogemcraftModItems.JIANLAODUANPIAN.get())), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("primogemcraft:jlhj_"))),
					1.5f, 0.45f);
			registerHelper.register(ResourceLocation.parse("primogemcraft:jlkjhj"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public JlkjhjItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends JlkjhjItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(234)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.primogemcraft.jlkjhj_helmet.description_0"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_helmet.description_1"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_helmet.description_2"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_helmet.description_3"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_helmet.description_4"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_helmet.description_5"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				JjlkjsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Chestplate extends JlkjhjItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(234)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.primogemcraft.jlkjhj_chestplate.description_0"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_chestplate.description_1"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_chestplate.description_2"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_chestplate.description_3"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_chestplate.description_4"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_chestplate.description_5"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				JjlkjsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Leggings extends JlkjhjItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(234)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.primogemcraft.jlkjhj_leggings.description_0"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_leggings.description_1"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_leggings.description_2"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_leggings.description_3"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_leggings.description_4"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_leggings.description_5"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				JjlkjsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Boots extends JlkjhjItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(234)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.primogemcraft.jlkjhj_boots.description_0"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_boots.description_1"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_boots.description_2"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_boots.description_3"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_boots.description_4"));
			list.add(Component.translatable("item.primogemcraft.jlkjhj_boots.description_5"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				JjlkjsxProcedure.execute(entity, itemstack);
			}
		}
	}
}